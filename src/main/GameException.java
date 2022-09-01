package main;

import main.util.Converter;

public class GameException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public GameException(Object message, Object... args)
	{
		super( Converter.format( Converter.stringify( message ), args ) );
	}
}
