package mathcard.card;

public class CardExponential extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.exp(d);
	}

	@Override
	public String toString()
	{
		return "e^x";
	}

}
