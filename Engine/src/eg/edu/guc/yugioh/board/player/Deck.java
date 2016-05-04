package eg.edu.guc.yugioh.board.player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.DarkHole;
import eg.edu.guc.yugioh.cards.spells.GracefulDice;
import eg.edu.guc.yugioh.cards.spells.HarpieFeatherDuster;
import eg.edu.guc.yugioh.cards.spells.HeavyStorm;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.MonsterReborn;
import eg.edu.guc.yugioh.cards.spells.PotOfGreed;
import eg.edu.guc.yugioh.cards.spells.Raigeki;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Deck {

	private static ArrayList<Card> monsters;
	private static ArrayList<Card> spells;
	private ArrayList<Card> deck;
	
	public Deck() throws CloneNotSupportedException, IOException{
		String csvMonsters = "Database-Monsters.csv";
		String csvSpells = "Database-Spells.csv";
		if(monsters==null||spells==null){
		monsters = loadCardsFromFile(csvMonsters);
		spells = loadCardsFromFile(csvSpells);
		}
		buildDeck(monsters,spells);
		this.shuffleDeck();
	}
	
	public ArrayList<Card> loadCardsFromFile(String path) throws IOException{
		String cvsSplitBy = ",";
		ArrayList<Card> result = new ArrayList<Card>();
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		while ((currentLine = br.readLine()) != null) {
			if(currentLine.charAt(0)=='M'){
	 
				String[] Monsters = currentLine.split(cvsSplitBy);
				result.add(new MonsterCard(Monsters[1],Monsters[2],Integer.parseInt(Monsters[5]),Integer.parseInt(Monsters[3]),Integer.parseInt(Monsters[4])));
			
			}else{
					 
			  	String[] Spells = currentLine.split(cvsSplitBy);
			  	switch(Spells[1]){
				case("Card Destruction") : result.add(new CardDestruction(Spells[1],Spells[2]));break;
				case("Change Of Heart")   : result.add(new ChangeOfHeart(Spells[1],Spells[2]));break ;
				case ("Dark Hole") : result.add(new DarkHole(Spells[1],Spells[2]));break;
				case ("Harpie's Feather Duster") : result.add(new HarpieFeatherDuster(Spells[1],Spells[1]));break;
				case ("Heavy Storm") : result.add(new HeavyStorm(Spells[1],Spells[1]));break;
				case ("Mage Power") : result.add(new MagePower(Spells[1],Spells[1]));break;
				case ("Monster Reborn") : result.add(new MonsterReborn(Spells[1],Spells[1]));break;
				case ("Pot of Greed") : result.add(new PotOfGreed(Spells[1],Spells[1]));break;
				case ("Raigeki") : result.add(new Raigeki(Spells[1],Spells[1]));break;
				case ("Graceful Dice") : result.add(new GracefulDice(Spells[1],Spells[1]));break;
				
			  	}
				}
		}
			//System.out.println(result.size());
		return result;
		
	}
	private void buildDeck(ArrayList<Card> monsters, ArrayList<Card> spells) throws CloneNotSupportedException{
		deck = new ArrayList<Card>(20);
		for(int i=0;i<15;i++){
			int j = (int)(30*Math.random());
			deck.add((MonsterCard)monsters.get(j).cloneIt());
		}
		for(int i=0;i<5;i++){
			int j = (int)(10*Math.random());
			deck.add((SpellCard)spells.get(j).cloneIt());
		}
	}
	private void shuffleDeck (){
		ArrayList<Card> newDeck = new ArrayList<Card>();
		while(!this.deck.isEmpty()){
			int i = (int)(Math.random()*deck.size());
			newDeck.add(this.deck.remove(i));
		}
		this.deck = newDeck;
	}
	public ArrayList<Card> drawNCards(int n){
		ArrayList<Card> result = new ArrayList<Card>();
		for(int i=0; i<n; i++){
			result.add(drawOneCard());
		}
		return result;
	}
	public Card drawOneCard(){
	
			return  this.deck.remove(0);
	}
	



	public static ArrayList<Card> getMonsters() {
		return monsters;
	}
	public static ArrayList<Card> getSpells() {
		return spells;
	}
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
}
