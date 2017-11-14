package mathcard;

import java.util.Random;

import mathcard.card.*;
import mathcard.player.*;
import mathcard.ui.GameFrame;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		
		GameFrame frame = new GameFrame();
		
		Game game = new Game(new PlayerConsole("Blanc", frame.getInputStream(), frame.getPrintStream()), new PlayerConsole("Noir", frame.getInputStream(), frame.getPrintStream()));
		//Game game = new Game(new PlayerConsole("Blanc", frame.getInputStream(), frame.getPrintStream()), new PlayerBotSimple("Albert"));
		//Game game = new Game(new PlayerBotSimple("Richard"), new PlayerBotSimple("Mortimer"));
		
		game.reset();
		game.setScoreBoth(rand.nextInt(21) - 10);
		game.addCardBoth(new CardAdd(5));
		game.addCardBoth(new CardAdd(-5));
		game.addCardBoth(new CardMult(2));
		game.addCardBoth(new CardInvert());
		game.addCardBoth(new CardGaussianScaled(5,0.1));
		
		//frame.getPrintStream().println(game);
		frame.getPrintStream().println(game.play());
		frame.getPrintStream().println(game);
	}

}
