package mathcard.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import mathcard.game.Game;

public class VisualFrame extends JFrame {
	private static final long serialVersionUID = -7946354707650461813L;
	
	private Game game;
	private HandPanel handP1, handP2;
	
	public VisualFrame(Game g)
	{
		game = g;
		handP1 = new HandPanel(game.getPlayer(1));
		handP2 = new HandPanel(game.getPlayer(2));
		game.addObserver(handP1);
		game.addObserver(handP2);
		
		setLayout(new BorderLayout());
		add(handP1, BorderLayout.SOUTH);
		add(handP2, BorderLayout.NORTH);
		pack();
		
		setVisible(true);
	}

}
