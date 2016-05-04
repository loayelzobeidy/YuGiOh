package eg.edu.guc.yugioh.cards.spells;
import eg.edu.guc.yugioh.cards.*;
public class DarkHole extends Raigeki{
	public DarkHole(String name ,String description ){
		super(name ,description)	;
		}
	public void action(MonsterCard monster){
		if(Card.getBoard().getActivePlayer().getField().getSpellArea().contains(this)){
		super.action(monster);
		super.getBoard().getActivePlayer().getField().removeMonsterToGraveyard(super.getBoard().getActivePlayer().getField().getMonstersArea());
	}
	}
}
