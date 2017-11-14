package mathcard.card;

public class CardInvert extends Card {
	@Override
	protected double calculate(double d)
	{
		return 1.0 / d;
	}

	@Override
	public String toString()
	{
		return "1 / x";
	}

}
