package main;

import main.ui.GameWindow;
import main.util.Converter;

public class TicTacToeProject
{
	
	public static void main(String[] args) 
	{
		//GameWindow window =
					new GameWindow(600, 600);
	}
		
	public static void print(Object input, Object... args) 
	{
		System.out.println(
			Converter.format(
				Converter.stringify(input), 
				args
			)
		);
	}
	
}
