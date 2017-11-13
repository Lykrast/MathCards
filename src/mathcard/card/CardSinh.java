package mathcard.card;

public class CardSinh extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.sinh(d);
	}

	@Override
	public String toString()
	{
		return "sinh(x)";
	}

}
