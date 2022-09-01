package main.util;

import main.GameTile;
import main.GameTileState;

import static main.GameTileState.*;

public class TileTrinity
{
	private GameTile center;
	private GameTile leftSide, rightSide; // pardon the unnecessary reference to Kanaria - King
	
	public TileTrinity(GameTile leftSide, GameTile center, GameTile rightSide)
	{
		this.leftSide	= leftSide;
		this.center		= center;
		this.rightSide	= rightSide;
	}
	
	public static GameTileState solve(GameTile leftSide, GameTile center, GameTile rightSide)
	{
		GameTileState watchedState;
		
		if( ( watchedState = center.getState( ) ).equals( EMPTY ) )
		{
			return EMPTY;
		}
			
		if( leftSide.getState( ).equals( watchedState ) && rightSide.getState( ).equals( watchedState ) )
		{	
			return watchedState;
		}
		
		return EMPTY;
	}
	
	public GameTileState solve()
	{
		return TileTrinity.solve( leftSide, center, rightSide );
	}
}
