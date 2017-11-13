package mathcard;

import java.util.Random;

import mathcard.card.Card;
import mathcard.player.Player;

public class Play {
	private Card card;
	private Player source;
	private Target target;
	
	public Play(Card card, Player source, Target target)
	{
		this.card = card;
		this.source = source;
		this.target = target;
	}
	
	public Card getCard()
	{
		return card;
	}
	
	public Player getSource()
	{
		return source;
	}
	
	public Target getTarget()
	{
		return target;
	}
	
	public void process(Player target)
	{
		target.setScore(card.apply(target.getScore()));
	}
	
	@Override
	public String toString()
	{
		return source.getName() + " : " + card + " on " + target;
	}
	
	public static enum Target
	{
		SELF, OPPONENT;
		
		public static Target random()
		{
			return random(new Random());
		}
		
		public static Target random(Random rand)
		{
			if (rand.nextInt(2) == 0) return SELF;
			else return OPPONENT;
		}
	}
}
