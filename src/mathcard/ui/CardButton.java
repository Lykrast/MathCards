package mathcard.ui;

import javax.swing.JButton;

import mathcard.card.Card;

public class CardButton extends JButton {
	private static final long serialVersionUID = 608396171449248099L;
	private Card card;
	
	public CardButton(Card c)
	{
		super(c.toString());
		card = c;
	}
	
	public Card getCard()
	{
		return card;
	}
}
