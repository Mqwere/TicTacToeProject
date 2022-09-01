package main.ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import main.GameException;
import main.GameTileState;

public class GameImageHandler
{
	private static GameImageHandler singleton;
	
	private HashMap<GameTileState, BufferedImage> imagesHashMap;
	
	public static GameImageHandler getHandler()
	{
		if(singleton == null) singleton = new GameImageHandler();
		return singleton;
	}
	
	private GameImageHandler()
	{
		imagesHashMap = new HashMap<>(); 
		
		for( GameTileState state: GameTileState.values( ) )
		{
			imagesHashMap.put( state, loadImageForGivenTileState(state) );
		}
	}
	
	private BufferedImage loadImageForGivenTileState(GameTileState state)
	{
		try
		{
			return ImageIO.read( new File("./res/" + state.toString( ).toLowerCase( ) + ".png") );
		} 
		catch (IOException e)
		{
			throw new GameException("Loading failed for an image for state \"%s\".", state.toString( ));
		}
	}
	
	public BufferedImage getImageByTileState(GameTileState state)
	{
		return imagesHashMap.get( state );
	}
}
