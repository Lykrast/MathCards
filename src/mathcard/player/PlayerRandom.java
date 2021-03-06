package mathcard.player;

import java.util.List;
import java.util.Random;

import mathcard.card.Card;
import mathcard.game.Play;
import mathcard.game.Play.Target;

public class PlayerRandom extends Player {
	private Random rand;
	
	public PlayerRandom(Random random)
	{
		super("Random" + random.hashCode());
		rand = random;
	}

	@Override
	public Play play()
	{
		Card c = getHand().get(rand.nextInt(getHand().size()));
		return play(c, Target.random(rand));
	}

	@Override
	public void pickCard(List<Card> list)
	{
		pick(list, rand.nextInt(list.size()));
	}
}
