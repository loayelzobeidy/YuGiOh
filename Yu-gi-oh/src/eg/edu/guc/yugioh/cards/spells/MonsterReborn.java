package eg.edu.guc.yugioh.cards.spells;
import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.*;
public class MonsterReborn extends SpellCard {
	public MonsterReborn (String name ,String description ){
		super(name ,description)	;
		}
	public void action (MonsterCard monster){
		ArrayList<Card> activeGraveyard = getBoard().getActivePlayer().getField().getGraveyard();
		ArrayList<Card> opponentGraveyard = getBoard().getOpponentPlayer().getField().getGraveyard();
		if(activeGraveyard.size()>0){
		Card strongest1 = activeGraveyard.get(0);
		for(int i =0;!(strongest1 instanceof MonsterCard);i++){
			if(i>=activeGraveyard.size()){
				break;
			}
			strongest1 = getBoard().getActivePlayer().getField().getGraveyard().get(i);
		}
		if(!(strongest1 instanceof MonsterCard)){
			for(int i =0;!(strongest1 instanceof MonsterCard);i++){
				if(i>=opponentGraveyard.size()){
					break;
				}
				strongest1 = opponentGraveyard.get(i);
			}
		}
		
		MonsterCard strongest = (MonsterCard) strongest1;
		for(int i=0;i<opponentGraveyard.size();i++){
			if(opponentGraveyard.get(i) instanceof MonsterCard)
				if(((MonsterCard)opponentGraveyard.get(i)).getAttackPoints()>strongest.getAttackPoints())
				{
				//	strongest1 =  opponentGraveyard.get(i);
					strongest = (MonsterCard)opponentGraveyard.get(i);
				}
		}
		for(int i = 0 ;  i<activeGraveyard.size();i++){
			if(activeGraveyard.get(i) instanceof MonsterCard)
				if(((MonsterCard)activeGraveyard.get(i)).getAttackPoints()>strongest.getAttackPoints())
				{
				//	strongest1 = activeGraveyard.get(i);
					strongest = (MonsterCard)activeGraveyard.get(i);
				}
		}
		activeGraveyard.remove(strongest);
		opponentGraveyard.remove(strongest);
		getBoard().getActivePlayer().getField().getMonstersArea().add(strongest);

		strongest.setLocation(Location.FIELD);
		}else{
			Card strongest1 = opponentGraveyard.get(0);
			for(int i =0;!(strongest1 instanceof MonsterCard);i++){
				if(i>=activeGraveyard.size()){
					break;
				}
				strongest1 = getBoard().getActivePlayer().getField().getGraveyard().get(i);
			}
			if(!(strongest1 instanceof MonsterCard)){
				for(int i =0;!(strongest1 instanceof MonsterCard);i++){
					if(i>=opponentGraveyard.size()){
						break;
					}
					strongest1 = opponentGraveyard.get(i);
				}
			}
			
			MonsterCard strongest = (MonsterCard) strongest1;
			for(int i=0;i<opponentGraveyard.size();i++){
				if(opponentGraveyard.get(i) instanceof MonsterCard)
					if(((MonsterCard)opponentGraveyard.get(i)).getAttackPoints()>strongest.getAttackPoints())
					{
					//	strongest1 =  opponentGraveyard.get(i);
						strongest = (MonsterCard)opponentGraveyard.get(i);
					}
			}
			for(int i = 0 ;  i<activeGraveyard.size();i++){
				if(activeGraveyard.get(i) instanceof MonsterCard)
					if(((MonsterCard)activeGraveyard.get(i)).getAttackPoints()>strongest.getAttackPoints())
					{
					//	strongest1 = activeGraveyard.get(i);
						strongest = (MonsterCard)activeGraveyard.get(i);
					}
			}
			activeGraveyard.remove(strongest);
			opponentGraveyard.remove(strongest);
			getBoard().getActivePlayer().getField().getMonstersArea().add(strongest);

			strongest.setLocation(Location.FIELD);
		}
	
}
	
	public static void main(String args[]) throws CloneNotSupportedException, IOException{
		
	}
}