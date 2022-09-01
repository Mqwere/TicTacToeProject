package main.ui;

import java.util.ArrayList;

import javax.swing.JPanel;

import main.GameTable;
import main.GameTileState;

import static main.GameTileState.*;

public class GameBoard extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	private GameTable tileTable;
	private ArrayList< GameBoardTile > frontendTiles;
	private GameTileState nextTileSymbol = CROSS;
	private int size;
	
	public GameBoard()
	{
		this(3);
	}
	
	public GameBoard(int size)
	{
		this.size = size;
		frontendTiles = new ArrayList<> ();
		tileTable = new GameTable(size);
		this.setLayout(null);
		for(int y = 0; y < size; y++)
		{
			for(int x = 0; x < size; x++)
			{
				GameBoardTile tile;
				tile = new GameBoardTile( this, y, x );
				frontendTiles.add( tile );
				this.add( tile );

			}
		}
	}
	
//	public void playerClickedTile( Coords2D coords )
//	{
//		playerClickedTile( coords.Y, coords.X );
//	}
	
	public void playerClickedTile( int Y, int X )
	{
		GameBoardTile clickedTile = get( Y, X );
		
		tileTable.set( Y, X, nextTileSymbol );
		clickedTile.setImageState( nextTileSymbol );
		clickedTile.removeMouseListener( clickedTile.currentMouseListener );
		
		switchNextTileSymbol( );
	}
	
	@Override
	public void setBounds( int x, int y, int width, int height )
	{
		super.setBounds( x, y, width, height );
		
		int margin = 10;
		int 
			smallerDimension = width < height ? width : height,
			compX,
			compY = margin,
			compSize = (smallerDimension - (( size + 1 ) * margin))/size;
		
		for(int h = 0; h < size; h++ )
		{	
			compX = margin;
			for(int w = 0; w < size; w++ )
			{
				GameBoardTile tile = frontendTiles.get( h * size + w );
				tile.setBounds( compX, compY, compSize, compSize );
				//tile.setFontSize( ( int )( compSize * 1 ) );
				
				compX += margin + compSize;
			}
			compY += margin + compSize;
		}
		
	}
	
	private void switchNextTileSymbol( )
	{
		nextTileSymbol = nextTileSymbol.equals( CROSS ) ? CIRCLE : CROSS;
	}
	
	private GameBoardTile get( int Y, int X )
	{
		return frontendTiles.get( tileTable.coordinatesToIndx( Y, X ) );
	}
	
}
