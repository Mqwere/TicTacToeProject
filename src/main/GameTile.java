package main;

public class GameTile
{
	
	private GameTileState state;

	public GameTile()
	{
		this(GameTileState.EMPTY);
	}
	
	public GameTile(GameTileState state)
	{
		this.state = state;
	}
	
	public void setState(GameTileState state)
	{
		this.state = state;
	}
	
	public GameTileState getState() 
	{ 
		return this.state;
	} 
	
}
