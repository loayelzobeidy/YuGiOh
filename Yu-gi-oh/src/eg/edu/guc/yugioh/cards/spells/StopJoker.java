package eg.edu.guc.yugioh.cards.spells;

import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.MonsterCard;

public class StopJoker extends SpellCard {
	public StopJoker(String name,String descr){
		super(name,descr);
	}
	public void action(MonsterCard monster){
		ArrayList <SpellCard>spellArea = getBoard().getOpponentPlayer().getField().getSpellArea();
		for(int i=0;i<spellArea.size();i++){
			if(spellArea.get(i) instanceof Joker){
				getBoard().getOpponentPlayer().getField().removeSpellToGraveyard(spellArea.get(i));
				i--;
			}
		}
	}
}
