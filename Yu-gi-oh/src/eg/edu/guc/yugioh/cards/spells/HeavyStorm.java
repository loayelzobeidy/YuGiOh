package eg.edu.guc.yugioh.cards.spells;
import eg.edu.guc.yugioh.cards.*;
public class HeavyStorm extends HarpieFeatherDuster {
	public HeavyStorm (String name ,String description ){
		super(name ,description)	;
		}
public void action (MonsterCard monster){
	super.action(monster);
	super.getBoard().getActivePlayer().getField().removeSpellToGraveyard(super.getBoard().getActivePlayer().getField().getSpellArea());
}
}
