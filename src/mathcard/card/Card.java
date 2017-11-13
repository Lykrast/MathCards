package mathcard.card;

public abstract class Card {
	
	public boolean canApply(double d)
	{
		return true;
	}
	
	public double apply(double d) throws IllegalArgumentException
	{
		if (!canApply(d)) throw new IllegalArgumentException("Cannot apply to " + d);
		
		return calculate(d);
	}
	
	protected abstract double calculate(double d);
	
	@Override
	public abstract String toString();
}
