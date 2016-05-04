package eg.edu.guc.yugioh.board.player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

import java.io.IOException;
import java.util.ArrayList;

public class Field {
	private Phase phase;
	private ArrayList<MonsterCard> monstersArea;
	private ArrayList<SpellCard> spellArea;
	private Deck deck;
	private ArrayList<Card> hand;
	private ArrayList<Card> graveyard;
	
	
	public Field() throws CloneNotSupportedException, IOException{
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
		if(this.monstersArea.size()<=5){
			monster.setMode(m);
			monster.setHidden(isHidden);
			hand.remove(monster);
			this.getMonstersArea().add(monster);
			monster.setLocation(Location.FIELD);
		}
	}
public void addMonsterToField(MonsterCard monster, Mode mode, ArrayList<MonsterCard> sacrifices){
		if(sacrifices == null){
			addMonsterToField(monster,mode,false);
		}else{
		
			
				removeMonsterToGraveyard(sacrifices);
				addMonsterToField(monster,mode,false);
			
		}
		}
public void removeMonsterToGraveyard(MonsterCard monster){
	if(!monstersArea.contains(monster))
		return ;
	monstersArea.remove(monster);
	graveyard.add(monster);
	monster.setLocation(Location.GRAVEYARD);
	
	
}
public void removeMonsterToGraveyard(ArrayList<MonsterCard> monsters){
	int monsters_size = monsters.size();
	for(int i = 0 ; i<monsters_size;i++){
		monstersArea.remove(monsters.get(i));
		graveyard.add(monsters.get(i));
		monsters.get(i).setLocation(Location.GRAVEYARD);
		
	}
}
	public void addSpellToField(SpellCard action,MonsterCard monster, boolean hidden){
		if(this.spellArea.size()<5){
			action.setHidden(hidden);
			hand.remove(action);
			action.setLocation(Location.FIELD);
			this.spellArea.add(action);
			if(!hidden)
			activateSetSpell(action,monster);
			
		}
	}
	public void activateSetSpell(SpellCard action, MonsterCard monster){
		if(action.getLocation() == Location.FIELD||action.getLocation()==Location.HAND){
		action.setHidden(false);
		action.action(monster);
		this.spellArea.remove(action);
		action.setLocation(Location.GRAVEYARD);
		graveyard.add(action);
		}
		
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
		Card temp = deck.drawOneCard();
		temp.setLocation(Location.HAND);
		hand.add(temp);
		
	}

	public void addNCardsToHand(int n){
			
		for(int i=0;i<n;i++){
			addCardToHand();
		}
		
	}
	

	
}
