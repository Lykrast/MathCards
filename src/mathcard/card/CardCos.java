package mathcard.card;

public class CardCos extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.cos(d);
	}

	@Override
	public String toString()
	{
		return "cos(x)";
	}

}
