package eg.edu.guc.yugioh.cards.spells;
import eg.edu.guc.yugioh.cards.*;
public class MagePower extends SpellCard{
	public MagePower (String name ,String description ){
		super(name ,description)	;
		}
	public void action (MonsterCard monster){
	
 int gain = super.getBoard().getActivePlayer().getField().getSpellArea().size()*500;
 int indx = super.getBoard().getActivePlayer().getField().getMonstersArea().indexOf(monster);
 int attck = super.getBoard().getActivePlayer().getField().getMonstersArea().get(indx).getAttackPoints();
 getBoard().getActivePlayer().getField().getMonstersArea().get(indx).setAttackPoints(attck+gain);
 
  gain = super.getBoard().getActivePlayer().getField().getSpellArea().size()*500;
  indx = super.getBoard().getActivePlayer().getField().getMonstersArea().indexOf(monster);
  int dfnse = super.getBoard().getActivePlayer().getField().getMonstersArea().get(indx).getDefensePoints();
  getBoard().getActivePlayer().getField().getMonstersArea().get(indx).setDefensePoints(dfnse+gain);
	}
}
