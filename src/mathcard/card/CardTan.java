package mathcard.card;

public class CardTan extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.tan(d);
	}

	@Override
	public String toString()
	{
		return "tan(x)";
	}

}
