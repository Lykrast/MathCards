package mathcard.player;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

import mathcard.card.Card;
import mathcard.game.IDebugPrinter;
import mathcard.game.Play;
import mathcard.game.Play.Target;

public class PlayerBotSimple extends PlayerOpponentAware implements IDebugPrinter {
	private boolean printing = false;

	public PlayerBotSimple(String name) {
		super("BOT " + name);
	}

	@Override
	public void pickCard(List<Card> list)
	{
		//TODO actual picking
		pick(list, 0);
	}

	@Override
	public Play play() {
		List<Play> list = constructPlays();
		
		Card playing = null;
		Target t = null;
		double max = Double.NaN;
		for (Play p : list)
		{
			double eval = evaluate(p);
			if (printing) System.out.println("Evaluated " + eval + " for " + p);
			if (playing == null || eval > max)
			{
				playing = p.getCard();
				t = p.getTarget();
				max = eval;
			}
		}
		
		if (printing) System.out.println("Highest : " + new Play(playing, this, t));
		return play(playing, t);
	}
	
	protected List<Play> constructPlays()
	{
		List<Play> list = new ArrayList<>();
		
		for (Card c : getHand())
		{
			list.add(new Play(c, this, Target.SELF));
			list.add(new Play(c, this, Target.OPPONENT));
		}
		
		return list;
	}
	
	protected double evaluate(Play p)
	{
		Card c = p.getCard();
		
		if (p.getTarget() == Target.SELF) 
			return estimate(c.apply(getScore()), opponent.getScore());
		else return estimate(getScore(), c.apply(opponent.getScore()));
	}
	
	protected double estimate(double own, double opponent)
	{
		return own - opponent;
	}

	@Override
	public void setPrintStatus(boolean status){
		printing = status;
	}

	@Override
	public boolean isPrinting() {
		return printing;
	}

}
