package mathcard.card;

public class CardArcTan extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.atan(d);
	}

	@Override
	public String toString()
	{
		return "arctan(x)";
	}

}
