package mathcard.card;

public class CardSigmoid extends Card {
	@Override
	protected double calculate(double d)
	{
		return 1 / (Math.exp(d) + 1);
	}

	@Override
	public String toString()
	{
		return "1 / (e^x + 1)";
	}

}
