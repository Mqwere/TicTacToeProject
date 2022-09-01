package main;

import java.util.ArrayList;

import main.util.TileTrinity;

import static main.GameTileState.*;
import static main.GameTileNickname.*;

public class GameTable
{
	private ArrayList< GameTile > content;
	
	private int size;
	private int movesMade;
	
	public GameTable( )
	{
		this( 3 );
	}
	
	public GameTable( int size )
	{
		this.size = size;
		this.movesMade = 0;
		this.content = new ArrayList< >( );
		for( int i = 0; i < size * size; i++ )
		{
			content.add( new GameTile( ) );
		}
	}
	
	public GameTile get( int height, int width )
	{
		validateCoordinates(height, width);
		return content.get( coordinatesToIndx(height, width) );
	}
	
	public GameTile get( GameTileNickname nick )
	{
		return get(nick.coords.Y, nick.coords.X);
	}
	
	public void set( int height, int width, GameTileState state )
	{
		validateCoordinates(height, width);
		movesMade++;
		content.get( coordinatesToIndx(height, width) ).setState( state );;
	}
	
	public int getSize( )
	{
		return this.size;
	}
	
	public boolean isValidMove( int height, int width )
	{
		return !( height < 0 || height > this.size ) && !( width < 0 || width > this.size );
	}
	
	public GameTileState checkIfGameWon( )
	{
		if( movesMade + 1 < ( size *2 ) ) return EMPTY;
		
		GameTileState checkedState;
		int height, width;
		
		// first checking win conditions tied to the center of the board
		if( !( checkedState = get( CC ).getState( ) ).equals( EMPTY ) ) 
		{
			for(height = 0, width = 0; width < this.size; width++)
			{
				if( hasStraightLineThroughCenter( height, width, checkedState ) ) 
				{
					return checkedState;
				}	
			}
			
			if( hasStraightLineThroughCenter( height + 1, width, checkedState ) ) 
			{
				return checkedState;
			}
		}
		
		// second, checking the trinities on the edges of the board if the edgepiece is not empty
		ArrayList< TileTrinity > trinities = new ArrayList< >( );
		
		if( !get( NW ).getState( ).equals( EMPTY ) ) 
		{
			trinities.add( new TileTrinity( get( NW ), get( NC ), get( NE ) ) );
			trinities.add( new TileTrinity( get( NW ), get( CW ), get( SW ) ) );
		}
		
		if( !get( SE ).getState( ).equals( EMPTY ) ) 
		{
			trinities.add( new TileTrinity( get( SW ), get( SC ), get( SE ) ) );
			trinities.add( new TileTrinity( get( NE ), get( CE ), get( SE ) ) );
		}
		
		for( TileTrinity trinity: trinities )
		{
			if( !( checkedState = trinity.solve( ) ).equals( EMPTY ) ) return checkedState;
		}
		
		return EMPTY;
	}
	
	public int coordinatesToIndx( int height, int width )
	{
		return height * this.size + width;
	}
	
	private GameTile getTileOpositeToThisThroughCenter( int height, int width )
	{
		return get( this.size - 1 - height, this.size - 1 - width );
	}
	
	private boolean hasStraightLineThroughCenter( int height, int width, GameTileState state )
	{
		return
			get( height, width )
				.getState( )
				.equals( state )
			&& 
			getTileOpositeToThisThroughCenter( height, width )
				.getState( )
				.equals( state );
	}
	
	private void validateCoordinates( int height, int width )
	{
		if( height < 0 || height > this.size ) 
			throw new 
			GameException
			(
				"Invalid height [%s].", 
					height < 0
						? height + " < 0" 
						: height + " > " + this.size 
			);
		
		if( width < 0 || width > this.size ) 
			throw new 
			GameException
			(
				"Invalid width [%s].", 
					width < 0
						? width + " < 0" 
						: width + " > " + this.size 
			);
	}

}
