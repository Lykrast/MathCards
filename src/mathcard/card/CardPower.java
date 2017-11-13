package mathcard.card;

public class CardPower extends Card {
	private int value;
	
	public CardPower(int value)
	{
		this.value = value;
	}

	@Override
	protected double calculate(double d)
	{
		return Math.pow(value, d);
	}

	@Override
	public String toString()
	{
		return value + "^x";
	}

}
