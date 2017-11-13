package mathcard.card;

public class CardSin extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.sin(d);
	}

	@Override
	public String toString()
	{
		return "sin(x)";
	}

}
