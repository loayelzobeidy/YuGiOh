package eg.edu.guc.yugioh.cards.spells;
import eg.edu.guc.yugioh.cards.*;
public class CardDestruction extends SpellCard {
public CardDestruction (String name ,String description ){
super(name ,description)	;
}
public void action (MonsterCard monster){
	 int k = super.getBoard().getActivePlayer().getField().getHand().size();
	 int j = super.getBoard().getOpponentPlayer().getField().getHand().size();
	 for(int i = 0 ;i<k;i++){
    	Card C1 = super.getBoard().getActivePlayer().getField().getHand().remove(0);
    	super.getBoard().getActivePlayer().getField().getGraveyard().add(C1);
    	C1.setLocation(Location.GRAVEYARD);
	 }
	 for(int i = 0 ;i<j;i++){
		Card C1 = super.getBoard().getOpponentPlayer().getField().getHand().remove(0);
		super.getBoard().getOpponentPlayer().getField().getGraveyard().add(C1);
    	C1.setLocation(Location.GRAVEYARD);
	 }
	 super.getBoard().getActivePlayer().addNCardsToHand(k);
	 super.getBoard().getOpponentPlayer().addNCardsToHand(j);
}
}
