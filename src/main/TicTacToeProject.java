package main;


public class TicTacToeProject
{

	public static void main(String[] args) 
	{
				
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
