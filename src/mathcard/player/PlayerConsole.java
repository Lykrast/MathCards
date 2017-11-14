package mathcard.player;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import mathcard.Play;
import mathcard.Play.Target;
import mathcard.card.Card;

public class PlayerConsole extends PlayerOpponentAware {
	private Scanner in;
	private PrintStream out;

	public PlayerConsole(String name, InputStream in, PrintStream out) {
		super(name);
		this.in = new Scanner(in);
		this.out = out;
	}

	@Override
	public Play play() {
		Card c = null;
		Target t = null;
		
		while (c == null)
		{
			out.println(displayScores());
			c = askCardFromList(getHand());
			t = askTarget(c);
			
			if (t == null) c = null;
		}
		
		return play(c, t);
	}
	
	private String displayScores()
	{
		return getName() + " - Scores : " + getScore() + " (you) to " + opponent.getScore();
	}
	
	private Card askCardFromList(List<Card> list)
	{
		out.println(displayCardList(list));
		
		int index = -1;
		int max = list.size() - 1;
		while (index < 0 || index > max)
		{
			try {
				index = Integer.parseInt(in.nextLine());
			}
			catch (NumberFormatException e) {
			}
		}
		
		return list.get(index);
	}
	
	private String displayCardList(List<Card> list)
	{
		if (list.isEmpty()) return "";
		
		String display = "";
		for (Card c : list)
		{
			String tmp = list.indexOf(c) + " : " + c;
			if (display.isEmpty()) display = tmp;
			else display += "\n" + tmp;
		}
		
		return display;
	}
	
	private Target askTarget(Card c)
	{
		out.println("0 : on yourself => " + getScore() + " -> " + c.apply(getScore()));
		out.println("1 : on opponent => " + opponent.getScore() + " -> " + c.apply(opponent.getScore()));
		out.println("-1 : cancel");
		
		int choice = -2;
		while (choice < -1 || choice > 1)
		{
			try {
				choice = Integer.parseInt(in.nextLine());
			}
			catch (NumberFormatException e) {
			}
		}
		
		if (choice == 0) return Target.SELF;
		else if (choice == 1) return Target.OPPONENT;
		else return null;
	}

	@Override
	public void pickCard(List<Card> list)
	{
		out.println(getName() + " - Pick a card from the list");
		Card c = askCardFromList(list);
		pick(list, list.indexOf(c));
	}

}
