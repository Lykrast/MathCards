package mathcard.card;

public class CardCosh extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.cosh(d);
	}

	@Override
	public String toString()
	{
		return "cosh(x)";
	}

}
