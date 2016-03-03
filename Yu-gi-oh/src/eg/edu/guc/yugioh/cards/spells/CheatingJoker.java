package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class CheatingJoker extends Joker {
	
	public CheatingJoker(String name,String descr){
		super(name,descr);
	}
	
	public SpellCard chooseSpell(){
		ArrayList <SpellCard>spellArea = getBoard().getOpponentPlayer().getField().getSpellArea();
		int size = spellArea.size();
		int random = (int) ((Math.random()*size));
		return spellArea.get(random);
	}
	public void action(MonsterCard monster){
		SpellCard x = chooseSpell();
		x.action(monster);
	}


}
