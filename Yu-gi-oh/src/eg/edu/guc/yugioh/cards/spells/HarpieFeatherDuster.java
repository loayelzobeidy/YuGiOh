package eg.edu.guc.yugioh.cards.spells;
import eg.edu.guc.yugioh.cards.*;
	public class HarpieFeatherDuster extends SpellCard {
		public HarpieFeatherDuster (String name ,String description ){
			super(name ,description)	;
		}
		public void action (MonsterCard monster){
			super.getBoard().getOpponentPlayer().getField().removeSpellToGraveyard(super.getBoard().getOpponentPlayer().getField().getSpellArea());
		}
	}
