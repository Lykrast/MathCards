package mathcard.card;

public class CardGaussianScaled extends Card {
	private double a, b;
	
	public CardGaussianScaled(double height, double tightness)
	{
		a = height;
		b = -tightness;
	}

	@Override
	protected double calculate(double d)
	{
		return a * Math.exp(b*d*d);
	}

	@Override
	public String toString()
	{
		return a + " * e^(" + b + " * x^2)";
	}

}
