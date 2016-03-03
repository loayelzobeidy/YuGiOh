package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public abstract class Joker extends SpellCard {
	
	public Joker(String name,String description){
		super(name,description);
	}
	
	public abstract SpellCard chooseSpell();
	public abstract void action(MonsterCard monster);
	
	
}
