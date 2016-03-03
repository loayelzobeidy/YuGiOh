	package eg.edu.guc.yugioh.board.player;

import java.io.IOException;
import java.util.ArrayList;

import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.cards.*;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;

public class Player implements Duelist{

	private String name;
	private int lifePoints;
	private Field field;
	boolean summoningMonster;
	boolean directlyAttacked = false;

	public int getLifePoints() {
		return lifePoints;
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


	public Player(String name) throws CloneNotSupportedException, IOException, NumberFormatException, MissingFieldException, EmptyFieldException, UnknownSpellCardException, UnknownCardTypeException{
		this.name = name;
		this.lifePoints = 8000;
		field = new Field();
	}


	@Override
	//How to check it is the first monster.
	public boolean summonMonster(MonsterCard monster) {
		if(Card.getBoard().getActivePlayer()==this&&field.getHand().contains(monster)
				&&Card.getBoard().getWinner()==null)
			if(summoningMonster==false){
			if(field.getPhase()==Phase.MAIN1||field.getPhase()==Phase.MAIN2){
				if(field.getMonstersArea().size()<5){
				field.addMonsterToField(monster, Mode.ATTACK,false);
				summoningMonster=true;
				return true;
				}else{
					throw new NoMonsterSpaceException();
				}
			}else{
				throw new WrongPhaseException();
		}
			}else{
				throw new MultipleMonsterAdditionException();
			}
		else
			return false;
		
	}


	@Override
	public boolean summonMonster(MonsterCard monster,
			ArrayList<MonsterCard> sacrifices) {
		if(Card.getBoard().getActivePlayer()==this&&field.getHand().contains(monster)
				&&Card.getBoard().getWinner()==null){
			
			if(field.getMonstersArea().size()>=5){
				throw new NoMonsterSpaceException();
			}else
				if(((monster.getLevel()<=4&&sacrifices==null)|| (monster.getLevel()<=6&&
				monster.getLevel()>4&&sacrifices.size()==1) || (monster.getLevel()<=8&&
				monster.getLevel()>6&&sacrifices.size()==2))
				){
					if((field.getPhase()==Phase.MAIN1||field.getPhase()==Phase.MAIN2)){
						if(summoningMonster==false){
					field.addMonsterToField(monster,Mode.ATTACK,sacrifices);
					summoningMonster=true;
					return true;
						
						}else{
							throw new MultipleMonsterAdditionException();
						}
					}else{
						throw new WrongPhaseException();
					}
				}else
					return false;
		}else
		return false;
		
	}


	public boolean isSummoningMonster() {
		return summoningMonster;
	}


	public void setSummoningMonster(boolean summoningMonster) {
		this.summoningMonster = summoningMonster;
	}


	@Override
	public boolean setMonster(MonsterCard monster) {
		if(Card.getBoard().getActivePlayer()==this&&field.getHand().contains(monster)
				&&Card.getBoard().getWinner()==null)
			if((field.getPhase()==Phase.MAIN1||field.getPhase()==Phase.MAIN2)){
				if(field.getMonstersArea().size()<5){
					if(summoningMonster==false){
				field.addMonsterToField(monster, Mode.DEFENSE,true);
				summoningMonster=true;
				return true;
					}else{
						throw new MultipleMonsterAdditionException();
					}
				}else{
					throw new NoMonsterSpaceException();
				}
			}else{
				throw new WrongPhaseException();
		}
		else
			return false;
	}


	@Override
	public boolean setMonster(MonsterCard monster,
			ArrayList<MonsterCard> sacrifices) {
		if(Card.getBoard().getActivePlayer()==this&&field.getHand().contains(monster)
				&&Card.getBoard().getWinner()==null)
			if(field.getMonstersArea().size()>=5) throw new NoMonsterSpaceException();
			else
				if(((monster.getLevel()<=4&&sacrifices==null)|| (monster.getLevel()<=6&&
						monster.getLevel()>4&&sacrifices.size()==1) || (monster.getLevel()<=8&&
						monster.getLevel()>6&&sacrifices.size()==2))){
					if((field.getPhase()==Phase.MAIN1||field.getPhase()==Phase.MAIN2)){
						if(summoningMonster==false){
					field.addMonsterToField(monster,Mode.DEFENSE,sacrifices);
					summoningMonster = true;
					return true;
						}else{
							throw new MultipleMonsterAdditionException();
						}
					}else{
						throw new WrongPhaseException();
					}
				}else
					return false;
		else
			return false;
	
	}


	@Override
	public boolean setSpell(SpellCard spell) {
		if(Card.getBoard().getActivePlayer()==this&&field.getHand().contains(spell)
				&&Card.getBoard().getWinner()==null)
			if(field.getSpellArea().size()<5){
			if((field.getPhase()==Phase.MAIN1||field.getPhase()==Phase.MAIN2)){
				field.addSpellToField(spell ,null , true);
			//	summoningMonster = true;
				return true;
			}else{
				throw new WrongPhaseException();
			}
			}else{
				throw new NoSpellSpaceException();
			}
		else
			return false;
	}


	@Override
	public boolean activateSpell(SpellCard spell, MonsterCard monster) {
		if(Card.getBoard().getActivePlayer()==this
				&&Card.getBoard().getWinner()==null){
			if(field.getPhase()==Phase.BATTLE){
				if(spell.getName().equals("Mega Power")||spell.getName().equals("Graceful Dice")){
					if(spell.getLocation()==Location.HAND){
						if(field.getSpellArea().size()<5){
						field.addSpellToField(spell, monster, false);
						return true;
						}else{
							throw new NoSpellSpaceException();
						}
					}else{
						if(spell.getLocation()==Location.FIELD){
							field.activateSetSpell(spell, monster);
							return true;
						}else
							throw new WrongPhaseException();
					}
				}else{
					throw new WrongPhaseException();
				}
			}else{
				if(spell.getLocation()==Location.HAND&&field.getSpellArea().size()<5){
					field.addSpellToField(spell, monster, false);
					return true;
				}else{
					if(spell.getLocation()==Location.FIELD){
						field.activateSetSpell(spell, monster);
						return true;
					}else
						throw new NoSpellSpaceException();
				}
		}
		}else
		return false;
	}


	@Override
	public boolean declareAttack(MonsterCard activeMonster,
			MonsterCard opponentMonster) {
		
	
		
		if(Card.getBoard().getActivePlayer()==this
				&&Card.getBoard().getWinner()==null)
			if(field.getPhase()==Phase.BATTLE){
				if(activeMonster.getMode()==Mode.ATTACK){
				if(activeMonster.isAttacked()==false){
				activeMonster.action(opponentMonster);
				activeMonster.setAttacked(true);
				}else{
					throw new MonsterMultipleAttackException();
				}
				return true;
				}else{
					throw new DefenseMonsterAttackException();
				}
			}else
				throw new WrongPhaseException();
		else
			return false;
	}


	@Override
	public boolean declareAttack(MonsterCard activeMonster) {
		if(Card.getBoard().getActivePlayer()==this
				&&Card.getBoard().getWinner()==null)
			if(field.getPhase()==Phase.BATTLE){
				
				if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size()==0){
			//	activeMonster.action(null);
				if(activeMonster.isAttacked()==false) {
					if(activeMonster.getMode()==Mode.ATTACK){
				activeMonster.action();
				 activeMonster.setAttacked(true);
				 directlyAttacked = true;
				return true;
					}else{
						throw new DefenseMonsterAttackException();
					}
				}else{
					throw new MonsterMultipleAttackException();
				}
				}else{
					return false;
				}
				
			}else{
				throw new WrongPhaseException();
			}
		else
			return false;
	}


	@Override
	public void addCardToHand() {
		if(Card.getBoard().getActivePlayer()==this
				&&Card.getBoard().getWinner()==null){
			if((field.getPhase()==Phase.MAIN1||field.getPhase()==Phase.MAIN2)){
			if(field.getDeck().getDeck().size()<=0){
				Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
			}else{
				field.addCardToHand();
			}
		}else{
			throw new WrongPhaseException();
		}
		}
	}


	@Override
	public void addNCardsToHand(int n) {
		if(Card.getBoard().getActivePlayer()==this
				&&Card.getBoard().getWinner()==null){
			if(field.getPhase()==Phase.MAIN1||field.getPhase()==Phase.MAIN2){
			for(int i=0;i<n;i++){
				this.addCardToHand();
			}
			}else{
				throw new WrongPhaseException();
			}
		}
	}


	@Override
	public void endPhase() {
		if(Card.getBoard().getActivePlayer()==this
				&&Card.getBoard().getWinner()==null)
			if(field.getPhase()==Phase.MAIN1)
				field.setPhase(Phase.BATTLE);
			else
				if(field.getPhase()==Phase.BATTLE)
					field.setPhase(Phase.MAIN2);
				else
					if(field.getPhase()==Phase.MAIN2){
						endTurn();
					}
	}


	@Override
	public boolean endTurn() {
		if(Card.getBoard().getActivePlayer()==this&&Card.getBoard().getWinner()==null
				&&Card.getBoard().getWinner()==null){
			for(int i=0;i<field.getMonstersArea().size();i++){
				field.getMonstersArea().get(i).setAttacked(false);
				field.getMonstersArea().get(i).setChangedMode(false);
			}
			summoningMonster = false;
			field.setPhase(Phase.MAIN1);
			Card.getBoard().nextPlayer();
			directlyAttacked=false;
			return true;
		}else
			return false;
	}


	@Override
	public boolean switchMonsterMode(MonsterCard monster) {
		if(Card.getBoard().getActivePlayer()==this&&monster.getLocation()==Location.FIELD
			&&Card.getBoard().getWinner()==null&&!monster.isChangedMode()){
			
			if((field.getPhase()==Phase.MAIN1||field.getPhase()==Phase.MAIN2)){
	
				if(monster.getMode()==Mode.ATTACK)
			monster.setMode(Mode.DEFENSE);
		else{
			monster.setHidden(false);
			monster.setMode(Mode.ATTACK);
		}
		monster.setChangedMode(true);
		return true;
			}else{
				throw new WrongPhaseException();
			}
			
	}else
		return false;
	}
	
}
	