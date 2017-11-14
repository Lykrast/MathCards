package mathcard.card;

public class CardGaussian extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.exp(-(d*d));
	}

	@Override
	public String toString()
	{
		return "e^(-x^2)";
	}

}
