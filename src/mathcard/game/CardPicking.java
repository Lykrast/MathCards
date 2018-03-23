package mathcard.game;

import java.util.ArrayList;
import java.util.List;

import mathcard.card.Card;
import mathcard.player.Player;

public class CardPicking {
	private List<Card> cards;
	private Player p1, p2;
	
	public CardPicking(Player p1, Player p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		cards = new ArrayList<>();
	}
	
	public void add(Card c)
	{
		cards.add(c);
	}
	
	public boolean isEmpty()
	{
		return cards.isEmpty();
	}
	
	public void pickAll()
	{
		Player current = p1;
		while (!isEmpty())
		{
			current.pickCard(cards);
			current = otherPlayer(current);
		}
	}
	
	private Player otherPlayer(Player p)
	{
		if (p == p1) return p2;
		else if (p == p2) return p1;
		else return null;
	}

}
