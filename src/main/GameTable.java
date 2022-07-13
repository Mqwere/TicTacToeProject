package main;

import java.util.ArrayList;

public class GameTable
{
	private ArrayList<GameTile> content;
	
	private int height, width;
	
	public GameTable(int height, int width)
	{
		this.height = height;
		this.width	= width;
		this.content = new ArrayList<> ();
		for(int i = 0; i < height * width; i++)
		{
			content.add( new GameTile() );
		}
		
	}
	
	public GameTile get(int height, int width)
	{
		validateCoordinates(height, width);
		return content.get( heightAndWidthToIndx(height, width) );
	}
	
	public void set(int height, int width, GameTileState state)
	{
		validateCoordinates(height, width);
		content.get( heightAndWidthToIndx(height, width) );
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public boolean isValidMove(int height, int width)
	{
		return !(height < 0 || height > this.height) && !(width < 0 || width > this.width);
	}
	
	private int heightAndWidthToIndx(int height, int width)
	{
		return height * this.width + width;
	}
	
	private void validateCoordinates(int height, int width)
	{
		if(height < 0 || height > this.height) 
			throw new 
			GameException
			(
				"Invalid height [%s].", 
					height < 0
						? height + " < 0" 
						: height + " > " + this.height 
			);
		
		if(width < 0 || width > this.width) 
			throw new 
			GameException
			(
				"Invalid width [%s].", 
					width < 0
						? width + " < 0" 
						: width + " > " + this.width 
			);
	}

}
