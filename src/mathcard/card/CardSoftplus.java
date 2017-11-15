package mathcard.card;

public class CardSoftplus extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.log1p(Math.exp(d));
	}

	@Override
	public String toString()
	{
		return "ln(e^x + 1)";
	}

}
