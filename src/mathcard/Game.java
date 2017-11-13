package mathcard;

import mathcard.Play.Target;
import mathcard.card.Card;
import mathcard.player.Player;
import mathcard.player.PlayerOpponentAware;

public class Game implements IDebugPrinter {
	private Player p1, p2;
	private boolean printing = false;
	
	public Game(Player p1, Player p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		
		if (p1 instanceof PlayerOpponentAware) ((PlayerOpponentAware) p1).setOpponent(p2);
		if (p2 instanceof PlayerOpponentAware) ((PlayerOpponentAware) p2).setOpponent(p1);
	}
	
	public void reset()
	{
		if (printing) System.out.println("Clearing hand for both players");
		p1.handClear();
		p2.handClear();
	}
	
	public void addCardBoth(Card c)
	{
		if (printing) System.out.println("Giving card " + c + " to both players");
		p1.handAdd(c);
		p2.handAdd(c);
	}
	
	public void setScoreBoth(double d)
	{
		if (printing) System.out.println("Setting score to " + d + " for both players");
		p1.setScore(d);
		p2.setScore(d);
	}
	
	public Victory play()
	{
		while (!p1.handEmpty() && !p2.handEmpty())
		{
			Play play = p1.play();
			Player target = evaluatePlay(play);
			play.process(target);
			if (printing) 
			{
				System.out.println(formatPlayer(p1) + " plays card " + play.getCard() + " on " + formatPlayer(target));
				System.out.println("Scores : " + p1.getScore() + " - " + p2.getScore());
			}
			
			play = p2.play();
			target = evaluatePlay(play);
			play.process(target);
			if (printing) 
			{
				System.out.println(formatPlayer(p2) + " plays card " + play.getCard() + " on " + formatPlayer(target));
				System.out.println("Scores : " + p1.getScore() + " - " + p2.getScore());
			}
		}
		
		if (p1.getScore() > p2.getScore()) return Victory.P1_VICTORY;
		else if (p1.getScore() < p2.getScore()) return Victory.P2_VICTORY;
		else return Victory.DRAW;
	}
	
	private Player evaluatePlay(Play play)
	{
		Target target = play.getTarget();
		
		if (target == Target.SELF) return play.getSource();
		else if (target == Target.OPPONENT)
		{
			Player source = play.getSource();
			if (source == p1) return p2;
			else if (source == p2) return p1;
			else return null;
		}
		
		return null;
	}
	
	protected String formatPlayer(Player p)
	{
		String res = "";
		if (p == p1) res += "P1 ";
		else if (p == p2) res += "P2 ";
		
		return res + p.getName();
	}
	
	@Override
	public String toString()
	{
		return "P1 " + p1 + "\nP2 " + p2;
	}
	
	public static enum Victory
	{
		DRAW, P1_VICTORY, P2_VICTORY;
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
