package main.ui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import main.GameTileState;

public class GameBoardTile extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	public final MouseAdapter currentMouseListener;
	
	private BufferedImage displayedImage;

	public GameBoardTile( GameBoard master, int y, int x )
	{
		this.setImageState(GameTileState.EMPTY);
		this.addMouseListener( 
			currentMouseListener = new MouseAdapter()
			{
				@Override
				public void mouseClicked( MouseEvent e )
				{
					master.playerClickedTile( y, x );
				}
			}
		);
	}
	
	public void setImageState(GameTileState state)
	{
		this.displayedImage = GameImageHandler.getHandler( ).getImageByTileState( state );
		this.repaint( );
	}
	
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        if(displayedImage != null) 
        {
        	g.drawImage(displayedImage, 0, 0, this);
        }
    }
	
}
