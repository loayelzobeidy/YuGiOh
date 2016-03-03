package eg.edu.guc.yugioh.cards.spells;
import eg.edu.guc.yugioh.cards.*;
public class GracefulDice extends SpellCard  {
	public GracefulDice (String name ,String description ){
		super(name ,description)	;
		}

public void action (MonsterCard monster){
		int extra = (100*(int)(10*Math.random()+1));
		int size = super.getBoard().getActivePlayer().getField().getMonstersArea().size();

		for(int i=0 ;i<size;i++)
		{
			super.getBoard().getActivePlayer().getField().getMonstersArea().get(i).setAttackPoints(super.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getAttackPoints()+extra);
			super.getBoard().getActivePlayer().getField().getMonstersArea().get(i).setDefensePoints(super.getBoard().getActivePlayer().getField().getMonstersArea().get(i).getDefensePoints()+extra);
		}
		super.getBoard().getActivePlayer().getField().setExtraPoints(extra);

	}
	}
