package mathcard.card;

public class CardSoftsign extends Card {
	@Override
	protected double calculate(double d)
	{
		return 1 / (Math.abs(d) + 1);
	}

	@Override
	public String toString()
	{
		return "1 / (|x| + 1)";
	}

}
