package mathcard.card;

public class CardTanh extends Card {
	@Override
	protected double calculate(double d)
	{
		return Math.tanh(d);
	}

	@Override
	public String toString()
	{
		return "tanh(x)";
	}

}
