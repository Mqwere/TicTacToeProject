package main;

import main.util.Coords2D;

public enum GameTileNickname
{
	NW(0,0),
	NC(0,1),
	NE(0,2),
	CW(1,0),
	CC(1,1),
	CE(1,2),
	SW(2,0),
	SC(2,1),
	SE(2,2);
	
	public Coords2D coords;
	
//	private GameTileNickname(Coords2D coords)
//	{
//		this.coords = coords;
//	}
	
	private GameTileNickname(int Y, int X)
	{
		this.coords = new Coords2D(Y,X);
	}
	
}
