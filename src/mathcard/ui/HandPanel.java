package mathcard.ui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import mathcard.card.Card;
import mathcard.player.Player;

public class HandPanel extends JPanel implements Observer {
	private static final long serialVersionUID = -6729001860142370285L;
	
	private Player owner;
	
	public HandPanel(Player p)
	{
		owner = p;
		setLayout(new FlowLayout());
		resetHand();
	}
	
	private void resetHand()
	{
		removeAll();
		
		for (Card c : owner.getHand())
		{
			addCard(c);
		}
		
		revalidate();
	}
	
	private void updateHand()
	{
		List<Card> hand = owner.getHand();
		for (Card c : hand)
		{
			if (getButton(c) == null) addCard(c);
		}
		
		for (Component comp : getComponents())
		{
			if (comp instanceof CardButton)
			{
				CardButton b = (CardButton)comp;
				if (!hand.contains(b.getCard())) removeButton(b);
			}
		}
		
		revalidate();
	}
	
	private void addCard(Card c)
	{
		CardButton button = new CardButton(c);
		add(button);
	}
	
	private void removeButton(CardButton b)
	{
		remove(b);
	}
	
	private CardButton getButton(Card c)
	{
		for (Component comp : getComponents())
		{
			if (comp instanceof CardButton)
			{
				CardButton b = (CardButton)comp;
				if (b.getCard() == c) return b;
			}
		}
		
		return null;
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		EventQueue.invokeLater(new HandUpdater());
	}
	
	private class HandUpdater implements Runnable {
		@Override
		public void run() {
			updateHand();
		}
	}

}
