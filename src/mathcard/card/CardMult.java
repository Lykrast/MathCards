package mathcard.card;

public class CardMult extends Card {
	private int value;
	
	public CardMult(int value)
	{
		this.value = value;
	}

	@Override
	protected double calculate(double d)
	{
		return d * value;
	}

	@Override
	public String toString()
	{
		if (value < 0) return "x * (" + value + ")";
		else return "x * " + value;
	}

}
