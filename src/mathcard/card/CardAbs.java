package mathcard.card;

public class CardAbs extends Card {

	@Override
	protected double calculate(double d) {
		return Math.abs(d);
	}

	@Override
	public String toString() {
		return "|x|";
	}

}
