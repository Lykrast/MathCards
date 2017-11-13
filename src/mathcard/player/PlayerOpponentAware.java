package mathcard.player;

public abstract class PlayerOpponentAware extends Player {
	protected Player opponent;
	
	public PlayerOpponentAware(String name)
	{
		super(name);
	}
	
	public void setOpponent(Player p)
	{
		opponent = p;
	}

}
