package eg.edu.guc.yugioh.board.player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

import java.io.IOException;
import java.util.ArrayList;

public class Field {
	private Phase phase;
	private ArrayList<MonsterCard> monstersArea;
	private ArrayList<SpellCard> spellArea;
	private Deck deck;
	private ArrayList<Card> hand;
	private ArrayList<Card> graveyard;
	private int extraPoints;
	
	public int getExtraPoints() {
		return extraPoints;
	}


	public void setExtraPoints(int extraPoints) {
		this.extraPoints = extraPoints;
	}


	public Field() throws CloneNotSupportedException, IOException, NumberFormatException, MissingFieldException, EmptyFieldException, UnknownSpellCardException, UnknownCardTypeException{
		this.setPhase(Phase.MAIN1);
		monstersArea = new ArrayList<MonsterCard>();
		spellArea = new ArrayList<SpellCard>();
		hand = new ArrayList<Card>();
		graveyard = new ArrayList<Card>();
		deck = new Deck();
	}
	
	
	public Deck getDeck() {
		return deck;
	}
	public ArrayList<Card> getGraveyard() {
		return graveyard;
	}
	public Phase getPhase() {
		return phase;
	}
	public void setPhase(Phase phase) {
		this.phase = phase;
	}
	public ArrayList<MonsterCard> getMonstersArea() {
		return monstersArea;
	}
	public ArrayList<SpellCard> getSpellArea() {
		return spellArea;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public void addMonsterToField(MonsterCard monster, Mode m, boolean isHidden){
		if(this.monstersArea.size()<5){
			monster.setMode(m);
			monster.setHidden(isHidden);
			hand.remove(monster);
			monstersArea.add(monster);
			monster.setLocation(Location.FIELD);
		}
	}
	public void addMonsterToField(MonsterCard monster, Mode mode, ArrayList<MonsterCard> sacrifices){
		if(sacrifices == null&&monster.getLevel()<=4){
			addMonsterToField(monster,mode,false);
		}else{
		if(this.monstersArea.size()>=5)return;
			if( (monster.getLevel()<=6&&monster.getLevel()>4&&sacrifices.size()==1) || (monster.getLevel()<=8&&monster.getLevel()>6&&sacrifices.size()>=2)){
				removeMonsterToGraveyard(sacrifices);
				if(mode == Mode.DEFENSE)
					addMonsterToField(monster,mode,true);
				else
					addMonsterToField(monster,mode,false);

			}
		}
		}
	
	public void removeMonsterToGraveyard(MonsterCard monster){
		if(monster.getLocation()==Location.FIELD){
		monstersArea.remove(monster);
		graveyard.add(monster);
		monster.setLocation(Location.GRAVEYARD);
		}
		
	}
	public void removeMonsterToGraveyard(ArrayList<MonsterCard> monsters){
		while(monsters.size()>0){
			removeMonsterToGraveyard(monsters.remove(0));
		}
	}
	public void addSpellToField(SpellCard action,MonsterCard monster, boolean hidden){
		if(this.spellArea.size()<5){
			action.setHidden(hidden);
			hand.remove(action);
			action.setLocation(Location.FIELD);
			this.spellArea.add(action);
			if(!hidden){
				activateSetSpell(action,monster);
			}
		}
	}
	public void activateSetSpell(SpellCard action, MonsterCard monster){
		action.setHidden(false);
		action.action(monster);
		this.spellArea.remove(action);
		action.setLocation(Location.GRAVEYARD);
		graveyard.add(action);
		
		
	}
	public void removeSpellToGraveyard(SpellCard spell){
		if(spell.getLocation() == Location.FIELD){
		spellArea.remove(spell);
		graveyard.add(spell);
		spell.setLocation(Location.GRAVEYARD);
		}
	}
	public void removeSpellToGraveyard(ArrayList<SpellCard> spells){
		while(spells.size()>0){
			SpellCard c =spells.remove(0);
			c.setLocation(Location.GRAVEYARD);
			this.spellArea.remove(c);
			graveyard.add(c);
		}
	}
	public void addCardToHand(){
		if(deck.getDeck().size()>0){
		Card temp = deck.drawOneCard();
		temp.setLocation(Location.HAND);
		hand.add(temp);
		}else{
			if(Card.getBoard().getActivePlayer().getField()==this){
				Card.getBoard().setWinner(Card.getBoard().getOpponentPlayer());
			}else{
				Card.getBoard().setWinner(Card.getBoard().getActivePlayer());
			}
		}
		
	}

	public void addNCardsToHand(int n){
		for(int i=0;i<n;i++){
			addCardToHand();
		}
	}



	
}
