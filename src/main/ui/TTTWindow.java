package main.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TTTWindow extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane = new JPanel();
	
	public TTTWindow() { this(360, 360); }
	public TTTWindow(int width, int height)
	{
		
		this.setSize( width, height );
		this.setTitle( "Tic-Tac-Toe" );
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setResizable(false);
		this.setLocationRelativeTo(null);

		contentPane.setLayout(null);
		
		

		this.setContentPane(contentPane);
		this.setVisible( true );
	}
}
