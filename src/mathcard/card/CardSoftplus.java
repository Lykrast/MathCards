package mathcard.card;

public class CardSoftplus extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.log(Math.exp(d) + 1);
	}

	@Override
	public String toString()
	{
		return "ln(e^x + 1)";
	}

}
