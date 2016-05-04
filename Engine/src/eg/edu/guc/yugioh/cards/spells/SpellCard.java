package eg.edu.guc.yugioh.cards.spells;


import eg.edu.guc.yugioh.cards.*;
abstract public class SpellCard extends Card{
	
	public SpellCard(String name, String description){
		super(name,description) ; 
	}
	
	abstract public void action (MonsterCard monster);

	public Object cloneIt() throws CloneNotSupportedException{
		return this.clone();
	}
}
