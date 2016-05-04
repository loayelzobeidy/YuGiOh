package eg.edu.guc.yugioh.cards.spells;
import eg.edu.guc.yugioh.cards.*;
public class ChangeOfHeart extends SpellCard  {
	public ChangeOfHeart (String name ,String description ){
		super(name ,description)	;
		}
public void action (MonsterCard monster ){	
	super.getBoard().getOpponentPlayer().getField().getMonstersArea().remove(monster);
	super.getBoard().getActivePlayer().getField().getMonstersArea().add(monster);
}

}
