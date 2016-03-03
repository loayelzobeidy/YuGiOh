package eg.edu.guc.yugioh.cards;

import eg.edu.guc.yugioh.board.Board;

//A class representing a single card

abstract public class Card implements Cloneable {

	private final String name;
	private final String description;
	private boolean isHidden ;
	private Location location;
	private static Board board ;
	
	public Card(String name,String description){
		this.name = name;
		this.description = description;
		this.location = Location.DECK;
		isHidden = true;
	}
	public Object cloneIt() throws CloneNotSupportedException{
		return this.clone();
	}
	public Location getLocation() {
		return location;
	}
	public boolean isHidden() {
		return isHidden;
	}
	
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public static Board getBoard() {
		return board;
	}

	public static void setBoard(Board boardX) {
		board = boardX;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	abstract public void action(MonsterCard monster);
	
}
