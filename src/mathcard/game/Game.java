package mathcard.game;

import java.util.List;
import java.util.Observable;

import mathcard.card.Card;
import mathcard.game.Play.Target;
import mathcard.player.Player;
import mathcard.player.PlayerOpponentAware;

public class Game extends Observable implements IDebugPrinter {
	private Player p1, p2;
	private boolean printing = false;
	
	public Game(Player p1, Player p2)
	{
		this.p1 = p1;
		this.p2 = p2;
		
		if (p1 instanceof PlayerOpponentAware) ((PlayerOpponentAware) p1).setOpponent(p2);
		if (p2 instanceof PlayerOpponentAware) ((PlayerOpponentAware) p2).setOpponent(p1);
	}
	
	public Player getPlayer(int index)
	{
		if (index == 1) return p1;
		if (index == 2) return p2;
		return null;
	}
	
	public void reset()
	{
		if (printing) System.out.println("Clearing hand for both players");
		p1.handClear();
		p2.handClear();
		
		setChanged();
		notifyObservers(null);
	}
	
	public void addCardBoth(Card c)
	{
		if (printing) System.out.println("Giving card " + c + " to both players");
		p1.handAdd(c);
		p2.handAdd(c);
		
		setChanged();
		notifyObservers(null);
	}
	
	public void addCardListBoth(List<Card> list)
	{
		if (printing) System.out.println("Giving card list " + list + " to both players");
		p1.handAddAll(list);
		p2.handAddAll(list);
		
		setChanged();
		notifyObservers(null);
	}
	
	public void setScoreBoth(double d)
	{
		if (printing) System.out.println("Setting score to " + d + " for both players");
		p1.setScore(d);
		p2.setScore(d);
		
		setChanged();
		notifyObservers(null);
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
			setChanged();
			notifyObservers(null);
			
			play = p2.play();
			target = evaluatePlay(play);
			play.process(target);
			if (printing) 
			{
				System.out.println(formatPlayer(p2) + " plays card " + play.getCard() + " on " + formatPlayer(target));
				System.out.println("Scores : " + p1.getScore() + " - " + p2.getScore());
			}
			setChanged();
			notifyObservers(null);
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
