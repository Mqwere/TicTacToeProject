package main.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane = new JPanel();
	
	public GameWindow() { this(360, 360); }
	public GameWindow(int width, int height)
	{
		
		this.setSize( width, height );
		this.setTitle( "Tic-Tac-Toe" );
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.contentPane.setLayout(null);
		
		GameBoard board = new GameBoard();
		
		this.contentPane.add( board );
		
		int tenthOfBoardRes = (width >= height? width : height)/12;
		
		board.setBounds( tenthOfBoardRes, tenthOfBoardRes, 10 * tenthOfBoardRes, 10 * tenthOfBoardRes );

		this.setContentPane(contentPane);
		this.setVisible( true );
	}
}
