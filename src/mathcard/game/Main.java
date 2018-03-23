package mathcard.game;

import java.util.Random;

import mathcard.card.CardAdd;
import mathcard.card.CardExponent;
import mathcard.card.CardInvert;
import mathcard.card.CardMult;
import mathcard.card.CardSinh;
import mathcard.card.CardSoftplus;
import mathcard.card.CardSoftsign;
import mathcard.card.CardTanh;
import mathcard.player.Player;
import mathcard.player.PlayerConsole;
import mathcard.ui.ConsoleFrame;
import mathcard.ui.VisualFrame;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		ConsoleFrame frame = new ConsoleFrame();
		
		Player blanc = new PlayerConsole("Blanc", frame.getInputStream(), frame.getPrintStream());
		//Player blanc = new PlayerBotSimple("Richard");
		
		Player noir = new PlayerConsole("Noir", frame.getInputStream(), frame.getPrintStream());
		//Player noir = new PlayerBotSimple("Mortimer");
		
		CardPicking picking = new CardPicking(noir, blanc);
		
		picking.add(new CardAdd(5));
		picking.add(new CardAdd(-5));
		picking.add(new CardMult(2));
		picking.add(new CardMult(-2));
		picking.add(new CardInvert());
		picking.add(new CardExponent(2));
		picking.add(new CardSoftsign());
		picking.add(new CardSoftplus());
		picking.add(new CardSinh());
		picking.add(new CardTanh());
		
		picking.pickAll();
		
		Game game = new Game(blanc, noir);
		VisualFrame visual = new VisualFrame(game);
		
		game.setScoreBoth(rand.nextInt(21) - 10);
		
		frame.flush();
		frame.getPrintStream().println("Game start!");
		frame.getPrintStream().println(game.play());
		frame.getPrintStream().println(game);
	}

}
