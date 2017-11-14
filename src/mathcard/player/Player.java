package mathcard.player;

import java.util.ArrayList;
import java.util.List;

import mathcard.Play;
import mathcard.Play.Target;
import mathcard.card.Card;

public abstract class Player {
	private double score;
	private String name;
	private List<Card> hand;

	public Player(String name)
	{
		this.name = name;
		score = 0;
		hand = new ArrayList<>();
	}
	
	public double getScore()
	{
		return score;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setScore(double d)
	{
		score = d;
	}
	
	protected List<Card> getHand()
	{
		return hand;
	}
	
	public void handClear()
	{
		hand.clear();
	}
	
	public void handAdd(Card c)
	{
		hand.add(c);
	}
	
	public void handAddAll(List<Card> list)
	{
		hand.addAll(list);
	}
	
	public boolean handEmpty()
	{
		return hand.isEmpty();
	}
	
	public abstract Play play();
	
	protected Play play(Card c, Target t)
	{
		hand.remove(c);
		return new Play(c, this, t);
	}
	
	public abstract void pickCard(List<Card> list);
	
	protected void pick(List<Card> list, int index)
	{
		hand.add(list.remove(index));
	}
	
	@Override
	public String toString()
	{
		return name + " : " + score;
	}

}
