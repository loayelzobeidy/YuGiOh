	package eg.edu.guc.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class Player  implements Duelist{
  private boolean Added1;
  private boolean Added2;
	private String name;
	private int lifePoints;
	private Field field;
	

	public int getLifePoints() {
		return lifePoints;
	}

public boolean getAdded1(){
	return Added1 ;
}
public boolean getAdded2(){
	return Added2 ;
}
public void setAdded1 (boolean Added1){
	  this.Added1=Added1;
}
public void setAdded2 (boolean Added2){
	  this.Added2=Added2;
}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}


	public String getName() {
		return name;
	}


	public Field getField() {
		return field;
	}


	public Player(String name) throws CloneNotSupportedException, IOException{
		this.name = name;
		this.lifePoints = 8000;
		field = new Field();
	}
	public boolean summonMonster(MonsterCard monster){
		if(monster.getLocation()!=Location.HAND)
			return false ;
		if(Card.getBoard().getWinner()!=null)
			return false ;
		if(!Card.getBoard().getActivePlayer().equals(this))
			return false ;
		if(this.getField().getMonstersArea().size()>=5)
			return false ;
		if(this.getField().getPhase()==Phase.BATTLE)
			return false;
		if(Added1&&this.getField().getPhase()==Phase.MAIN1)
			return false;
		if(Added2&&this.getField().getPhase()==Phase.MAIN2)
			return false;
		if(this.getField().getPhase()==Phase.MAIN1)
			Added1 = true;
		if(this.getField().getPhase()==Phase.MAIN2)
			Added2 = true; 
		this.getField().addMonsterToField(monster, Mode.ATTACK, false);
		return true; 
	}
	public boolean summonMonster(MonsterCard monster,ArrayList<MonsterCard>sacrifices){
		if(monster.getLocation()!=Location.HAND)
			return false ;
		if(Card.getBoard().getWinner()!=null)
			return false ;
		if(!Card.getBoard().getActivePlayer().equals(this))
			return false ;
		if(this.getField().getMonstersArea().size()-sacrifices.size()>=5)
			return false ;
		if(this.getField().getPhase()==Phase.BATTLE)
			return false;
	
		if(Added1&&this.getField().getPhase()==Phase.MAIN1)
			return false;
		if(Added2&&this.getField().getPhase()==Phase.MAIN2)
			return false;
		if(monster.getLevel()<=4&&sacrifices.size()!=0)
			return false ;
		if(monster.getLevel()>4&&monster.getLevel()<=6&&sacrifices.size()!=1)
			return false ;
		if(monster.getLevel()>6&&monster.getLevel()<=8&&sacrifices.size()!=2)
			return false ;
		
		if(this.getField().getPhase()==Phase.MAIN1)
		Added1 = true; 
		if(this.getField().getPhase()==Phase.MAIN2)
		Added2 = true; 
		this.getField().addMonsterToField(monster, Mode.ATTACK, sacrifices);
		return true ;
	}
	public boolean setMonster(MonsterCard monster){
		if(monster.getLocation()!=Location.HAND)
			return false ;
		if(Card.getBoard().getWinner()!=null)
			return false ;
		if(!Card.getBoard().getActivePlayer().equals(this))
			return false ;
		if(this.getField().getMonstersArea().size()>=5)
			return false ;
		if(this.getField().getPhase()==Phase.BATTLE)
			return false;
		if(Added1&&this.getField().getPhase()==Phase.MAIN1)
			return false;
		if(Added2&&this.getField().getPhase()==Phase.MAIN2)
			return false;
		if(this.getField().getPhase()==Phase.MAIN1)
			Added1 = true;
		if(this.getField().getPhase()==Phase.MAIN2)
			Added2 = true; 
		this.getField().addMonsterToField(monster,Mode.DEFENSE,true);
		return true; 

	}
	public boolean setMonster(MonsterCard monster,ArrayList<MonsterCard>sacrifices){
		if(monster.getLocation()!=Location.HAND)
			return false ;
		if(Card.getBoard().getWinner()!=null)
			return false ;
		if(!Card.getBoard().getActivePlayer().equals(this))
			return false ;
		
		if(this.getField().getPhase()==Phase.BATTLE)
			return false;
		if(Added1&&this.getField().getPhase()==Phase.MAIN1)
			return false;
		if(Added2&&this.getField().getPhase()==Phase.MAIN2)
			return false;
		if(monster.getLevel()<=4&&sacrifices.size()!=0)
			return false ;
		if(monster.getLevel()>4&&monster.getLevel()<=6&&sacrifices.size()!=1)
			return false ;
		if(monster.getLevel()>6&&monster.getLevel()<=8&&sacrifices.size()!=2)
			return false ;
		if(this.getField().getMonstersArea().size()-sacrifices.size()>=5)
			return false ;
		if(this.getField().getPhase()==Phase.MAIN1)
		Added1 = true; 
		if(this.getField().getPhase()==Phase.MAIN2)
			Added2 = true; 
		this.getField().addMonsterToField(monster, Mode.DEFENSE, sacrifices);
		return true ;
	}
	public boolean setSpell(SpellCard spell){
		
		if(spell.getLocation()!=Location.HAND)
			return false ;
		if(Card.getBoard().getWinner()!=null)
			return false ;
		if(!Card.getBoard().getActivePlayer().equals(this))
			return false ;
		if(spell.getLocation()!=Location.FIELD&&spell.getLocation()!=Location.HAND)
			return false; 
		if(this.getField().getSpellArea().size()>=5)
			return false ;
		if(this.getField().getPhase()==Phase.BATTLE)
			return false;

		this.getField().addSpellToField(spell,null,true);
	return true ; 
		
	}
	public boolean activateSpell(SpellCard spell , MonsterCard monster){
	if(Card.getBoard().getWinner()!=null)
			return false ;
		if(!Card.getBoard().getActivePlayer().equals(this))
			return false ;
		if(spell.getLocation()!=Location.FIELD&&spell.getLocation()!=Location.HAND)
			return false; 
		if(this.getField().getSpellArea().size()>=5)
			return false ;
		if(this.getField().getPhase()==Phase.BATTLE)
			return false;
		 if(spell.getLocation()==Location.HAND)
				this.getField().addSpellToField(spell, monster,false);
         if(spell.getLocation()==Location.FIELD)
		this.getField().activateSetSpell( spell, monster);
		return true ; 
	}
	public boolean declareAttack(MonsterCard activeMonster,MonsterCard opponentMonster){
		if(activeMonster.getAttack())
			return false ;
		if(Card.getBoard().getWinner()!=null)
			 return false ;
			if(activeMonster.getMode()!=Mode.ATTACK)
				return false; 
			if(activeMonster.getLocation()!=Location.FIELD)
				return false;
			if(opponentMonster.getLocation()!=Location.FIELD)
				return false;
			if(Card.getBoard().getActivePlayer().getField().getPhase()!=Phase.BATTLE)
				return false; 
			if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().isEmpty())
			 activeMonster.action();
		if(Card.getBoard().getWinner()!=null)
			return false ;
		if(!Card.getBoard().getActivePlayer().equals(this))
			return false ;
		if(this.getField().getPhase()!=Phase.BATTLE)
			return false ; 
		activeMonster.action(opponentMonster);
		activeMonster.setAttack(true);
		return true ; 
		
	}
	public boolean declareAttack(MonsterCard activeMonster){
		if(activeMonster.getAttack())
		return false ;
			if(Card.getBoard().getWinner()!=null)
			return false ;
		if(!Card.getBoard().getActivePlayer().equals(this))
			return false ;
		if(this.getField().getPhase()!=Phase.BATTLE)
			return false ; 
		if(activeMonster.getMode()!=Mode.ATTACK)
			return false ;
		if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size()!=0)
			return false ;
		activeMonster.setAttack(true);
		activeMonster.action();
		return true ; 
		
	}
	public void addCardToHand(){
		Player  APl = Card.getBoard().getActivePlayer();
		Player  OPl = Card.getBoard().getOpponentPlayer();
		if(this.getField().getDeck().getDeck().size()==0)
		{
		if(APl==this){
			Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
			return ;
		}
		if(OPl==this){
			Card.getBoard().setWinner(Card.getBoard().getActivePlayer());
			return ;
		}
		}
	
		if(Card.getBoard().getWinner()==null){
		
			
		 this.getField().addCardToHand();
		}
	}
	public void addNCardsToHand(int n){
		if(Card.getBoard().getWinner()!=null)
			return ;
		Player  APl = Card.getBoard().getActivePlayer();
		Player  OPl = Card.getBoard().getOpponentPlayer();
		if(this.getField().getDeck().getDeck().size()<n)
		{
		if(APl==this){
			Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
			return ;
		}
		if(OPl==this){
			Card.getBoard().setWinner(Card.getBoard().getActivePlayer());
			return ;
		}
		}
		
		this.getField().addNCardsToHand(n);
		}
	
	public void endPhase(){
		if(Card.getBoard().getWinner()!=null)
			return ;
		if(!Card.getBoard().getActivePlayer().equals(this))
		return ;
			if(Card.getBoard().getActivePlayer().getField().getPhase()==Phase.MAIN1)
			{	Card.getBoard().getActivePlayer().getField().setPhase(Phase.BATTLE);
			for(int i = 0 ;i<this.getField().getMonstersArea().size();i++){	
			((MonsterCard)this.getField().getMonstersArea().get(i)).setChanged1(false);
			((MonsterCard)this.getField().getMonstersArea().get(i)).setChanged2(false);
			((MonsterCard)this.getField().getMonstersArea().get(i)).setAttack(false);
				
			}				
			}
			else
			if(Card.getBoard().getActivePlayer().getField().getPhase()==Phase.BATTLE)
				Card.getBoard().getActivePlayer().getField().setPhase(Phase.MAIN2);
			else
			if(Card.getBoard().getActivePlayer().getField().getPhase()==Phase.MAIN2){
				
				Card.getBoard().getActivePlayer().endTurn();
				for(int i = 0 ;i<this.getField().getMonstersArea().size();i++){	
					((MonsterCard)this.getField().getMonstersArea().get(i)).setChanged1(false);
					((MonsterCard)this.getField().getMonstersArea().get(i)).setChanged2(false);
					((MonsterCard)this.getField().getMonstersArea().get(i)).setAttack(false);
						
					}
			}
		
		}	
	
	public boolean endTurn(){
		if(!Card.getBoard().getActivePlayer().equals(this))
			return false;
		if(Card.getBoard().getWinner()!=null)
			return false ;
		Card.getBoard().nextPlayer();
		for(int i = 0 ;i<this.getField().getMonstersArea().size();i++){	
			((MonsterCard)this.getField().getMonstersArea().get(i)).setChanged1(false);
			((MonsterCard)this.getField().getMonstersArea().get(i)).setChanged2(false);
			((MonsterCard)this.getField().getMonstersArea().get(i)).setAttack(false);
				
			}
		return true ;
	}
	public boolean switchMonsterMode(MonsterCard monster){
		if(monster.getLocation()!=Location.FIELD)
			return false ;
		if(monster.getChanged1()&&this.getField().getPhase()==Phase.MAIN1)
			return false;
		if(monster.getChanged2()&&this.getField().getPhase()==Phase.MAIN2)
			return false;
		if(Card.getBoard().getWinner()!=null)
			return false ;
	if(this.getField().getPhase()==Phase.BATTLE)
		return false ; 
	if(Card.getBoard().getActivePlayer()!=this)
		return false ;
	if(monster.getMode()==Mode.ATTACK)
		monster.setMode(Mode.DEFENSE);
	else
		monster.setMode(Mode.ATTACK);
	if(this.getField().getPhase()==Phase.MAIN1)
	monster.setChanged1(true);
	if(this.getField().getPhase()==Phase.MAIN2)
		monster.setChanged2(true);
	return true ; 
	}
	
}
	