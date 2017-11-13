package mathcard.card;

public class CardExponent extends Card {
	private int value;
	
	public CardExponent(int value)
	{
		this.value = value;
	}

	@Override
	protected double calculate(double d)
	{
		return Math.pow(d, value);
	}

	@Override
	public String toString()
	{
		return "x^" + value;
	}

}
