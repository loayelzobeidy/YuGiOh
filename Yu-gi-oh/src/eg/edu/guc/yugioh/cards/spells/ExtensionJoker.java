package eg.edu.guc.yugioh.cards.spells;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class ExtensionJoker extends Joker {
	
	public ExtensionJoker(String name,String descr){
		super(name,descr);
	}
	
	public SpellCard chooseSpell(){
		return getBoard().getActivePlayer().getField().getSpellArea().get(0);
	}
	public void action(MonsterCard monster){
		SpellCard x = chooseSpell();
		x.action(monster);
	}
	
}
