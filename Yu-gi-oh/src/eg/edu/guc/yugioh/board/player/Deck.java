package eg.edu.guc.yugioh.board.player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Location;
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
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Deck {

	private static ArrayList<Card> monsters;
	private static ArrayList<Card> spells;
	private ArrayList<Card> deck;
	private static String monstersPath="Database-Monsters.csv";
	private static String spellsPath="Database-Spells.csv";

	private static int player= 1;

	private void buildYugiDeck()
	{
	/** Cards in Deck
		Big Shield Gardna
		Baby Dragon
		Dark Magician Girl
		Pot of Greed
		Dark Hole
		Alexandrite Dragon
		Change Of Heart
		Kuriboh
		Mage Power
		Card Destruction
		Dark Magician
		Gaia The Fierce Knight
		Curse Of Dragon
		Kuriboh
		Dark Magician
		Alpha The Magnet Warrior
		Beta The Magnet Warrior
		Gamma The Magnet Warrior
		Kuriboh
		Baby Dragon
		**/
		
		addMonsterToDeck("Big Shield Gardna");
		addMonsterToDeck("Baby Dragon");
		addMonsterToDeck("Dark Magician Girl");
		addSpellToDeck("Pot of Greed");
		addSpellToDeck("Dark Hole");
		addMonsterToDeck("Alexandrite Dragon");
		addSpellToDeck("Change Of Heart");
		addMonsterToDeck("Kuriboh");
		addSpellToDeck("Mage Power");
		addSpellToDeck("Card Destruction");
		addMonsterToDeck("Dark Magician");
		addMonsterToDeck("Gaia The Fierce Knight");
		addMonsterToDeck("Curse Of Dragon");
		addMonsterToDeck("Kuriboh");
		addMonsterToDeck("Dark Magician");
		addMonsterToDeck("Alpha The Magnet Warrior");
		addMonsterToDeck("Beta The Magnet Warrior");
		addMonsterToDeck("Gamma The Magnet Warrior");
		addMonsterToDeck("Kuriboh");
		addMonsterToDeck("Baby Dragon");
	}
	
	private void buildKaibaDeck()
	{
	/** Cards in Deck
		Pot of Greed
		Vorse Raider
		Witty Phantom
		Vorse Raider
		Mokey Mokey
		Vorse Raider
		Mokey Mokey
		Witty Phantom
		Blue-Eyes White Dragon
		Cyber Jar
		Witty Phantom
		Pot of Greed
		Pot of Greed
		Pot of Greed
		Cyber Jar
		Blue-Eyes White Dragon
		Cyber Jar
		Blue-Eyes White Dragon
		Baby Dragon
		Pot of Greed
		**/
		
		addSpellToDeck("Pot of Greed");
		addMonsterToDeck("Vorse Raider");
		addMonsterToDeck("Witty Phantom");
		addMonsterToDeck("Vorse Raider");
		addMonsterToDeck("Mokey Mokey");
		addMonsterToDeck("Vorse Raider");
		addMonsterToDeck("Mokey Mokey");
		addMonsterToDeck("Witty Phantom");
		addMonsterToDeck("Blue-Eyes White Dragon");
		addMonsterToDeck("Cyber Jar");
		addMonsterToDeck("Witty Phantom");
		addSpellToDeck("Pot of Greed");
		addSpellToDeck("Pot of Greed");
		addSpellToDeck("Pot of Greed");
		addMonsterToDeck("Cyber Jar");
		addMonsterToDeck("Blue-Eyes White Dragon");
		addMonsterToDeck("Cyber Jar");
		addMonsterToDeck("Blue-Eyes White Dragon");
		addMonsterToDeck("Baby Dragon");
		addSpellToDeck("Pot of Greed");
	}
	
	private void addMonsterToDeck(String s)
	{
		Card c = getMonsterByName(s);
		MonsterCard m = (MonsterCard) c;
		MonsterCard n = new MonsterCard(m.getName(), m.getDescription(),
				m.getLevel(), m.getAttackPoints(), m.getDefensePoints());
		n.setMode(m.getMode());
		n.setHidden(m.isHidden());
		n.setLocation(Location.DECK);
		deck.add(n);
	}
	
	private void addSpellToDeck(String s)
	{
		Card temp = getSpellByName(s);
		SpellCard clone;
		switch (temp.getName()) {

		case "Card Destruction":
			clone = new CardDestruction(temp.getName(),
					temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Change Of Heart":
			clone = new ChangeOfHeart(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Dark Hole":
			clone = new DarkHole(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Graceful Dice":
			clone = new GracefulDice(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Harpie's Feather Duster":
			clone = new HarpieFeatherDuster(temp.getName(),
					temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Heavy Storm":
			clone = new HeavyStorm(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Mage Power":
			clone = new MagePower(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Monster Reborn":
			clone = new MonsterReborn(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Pot of Greed":
			clone = new PotOfGreed(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;
		case "Raigeki":
			clone = new Raigeki(temp.getName(), temp.getDescription());
			clone.setLocation(Location.DECK);
			deck.add(clone);
			break;

		}
	}
	
	
	private Card getMonsterByName(String s)
	{
		for(Card c : monsters)
		{
			if (c.getName().equals(s))
			{
				return c;
			}
		}
		
		throw new NullPointerException("No Such Monster " + s);
	}
	
	private Card getSpellByName(String s)
	{
		for(Card c : spells)
		{
			if (c.getName().equals(s))
			{
				return c;
			}
		}
		
		throw new NullPointerException("No Such Spell " + s);
	}
	public static String getMonstersPath() {
		return monstersPath;
	}

	public static void setMonstersPath(String monstersPath1) {
		monstersPath = monstersPath1;
	}

	public static String getSpellsPath() {
		return spellsPath;
	}

	public static void setSpellsPath(String spellsPath1) {
		spellsPath = spellsPath1;
	}

	public Deck() throws CloneNotSupportedException, IOException, NumberFormatException, MissingFieldException, EmptyFieldException, UnknownSpellCardException, UnknownCardTypeException{
		Scanner sc = new Scanner(System.in);
		deck = new ArrayList<Card>();
			for(int i=0;i<4;i++){
			
				try{
					monsters = loadCardsFromFile(monstersPath);
					break;
				}catch(FileNotFoundException e){
					System.out.println("File not found");
					if(i==3){
						throw e;
					}
					System.out.println("Please enter a correct path");
					monstersPath = sc.nextLine();
				}
				catch(MissingFieldException e1){
					System.out.println("File not found");
					if(i==3){
						throw e1;
					}
					System.out.println("Please enter a correct path");
					monstersPath = sc.nextLine();
				}
				catch(EmptyFieldException e2){
					System.out.println("File not found");
					if(i==3){
						throw e2;
					}
					System.out.println("Please enter a correct path");
					monstersPath = sc.nextLine();
				}
				catch(UnknownCardTypeException e3){
					System.out.println("File not found");
					if(i==3){
						throw e3;
					}
					System.out.println("Please enter a correct path");
					monstersPath = sc.nextLine();
				}
				
			}
			for(int i=0;i<4;i++){
				
				try{
					spells = loadCardsFromFile(spellsPath);
					break;
					
				}catch(FileNotFoundException e){
					System.out.println("File not found");
					if(i==3){
						throw e;
					}
					System.out.println("Please enter a correct path");
					spellsPath = sc.nextLine();
				}
				catch(MissingFieldException e1){
					System.out.println("File not found");
					if(i==3){
						throw e1;
					}
					System.out.println("Please enter a correct path");
					spellsPath = sc.nextLine();
				}
				catch(EmptyFieldException e2){
					System.out.println("File not found");
					if(i==3){
						throw e2;
					}
					System.out.println("Please enter a correct path");
					spellsPath = sc.nextLine();
				}
				catch(UnknownCardTypeException e3){
					System.out.println("File not found");
					if(i==3){
						throw e3;
					}
					System.out.println("Please enter a correct path");
					spellsPath = sc.nextLine();
				}
				catch(UnknownSpellCardException e4){
					System.out.println("File not found");
					if(i==3){
						throw e4;
					}
					System.out.println("Please enter a correct path");
					spellsPath = sc.nextLine();
				}
				
		}
//		buildDeck(monsters,spells);
//		this.shuffleDeck();
			if(player == 1)
			{
				buildYugiDeck();
				player++;
			}
			else
			{
				buildKaibaDeck();
			}
	}
	
	public ArrayList<Card> loadCardsFromFile(String path) throws NumberFormatException, IOException, MissingFieldException, EmptyFieldException, UnknownSpellCardException, UnknownCardTypeException{
		String cvsSplitBy = ",";
		ArrayList<Card> result = new ArrayList<Card>();
		String currentLine = "";
			FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		int i =1;
		while ((currentLine = br.readLine()) != null) {
			String test = currentLine.split(cvsSplitBy)[0];
			if(test.equals("Monster")){
	 
				String[] Monsters = currentLine.split(cvsSplitBy);
				if(Monsters.length!=6){
					throw new MissingFieldException(path,i);
				}
				for(int j=0;j<6;j++){
				  	if(Monsters[j].equals("")||Monsters[j].equals(" ")){
				  		throw new EmptyFieldException(path,i,j+1);
				  	}
				  	}
				try{
				result.add(new MonsterCard(Monsters[1],Monsters[2],Integer.parseInt(Monsters[5]),Integer.parseInt(Monsters[3]),Integer.parseInt(Monsters[4])));
				}catch(NumberFormatException e){
					throw new FileNotFoundException();
				}
			}else{
					if(test.equals("Spell")) {
			  	String[] Spells = currentLine.split(cvsSplitBy);
			  	if(Spells.length!=3){
					throw new MissingFieldException(path,i);
			  	}
			  	for(int j=0;j<3;j++){
			  	if(Spells[j].equals("")||Spells[j].equals(" ")){
			  		throw new EmptyFieldException(path,i,j+1);
			  	}
			  	}
			  	switch(Spells[1]){
				case("Card Destruction") : result.add(new CardDestruction(Spells[1],Spells[2]));break;
				case("Change Of Heart")   : result.add(new ChangeOfHeart(Spells[1],Spells[2]));break ;
				case ("Dark Hole") : result.add(new DarkHole(Spells[1],Spells[2]));break;
				case ("Harpie's Feather Duster") : result.add(new HarpieFeatherDuster(Spells[1],Spells[2]));break;
				case ("Heavy Storm") : result.add(new HeavyStorm(Spells[1],Spells[2]));break;
				case ("Mage Power") : result.add(new MagePower(Spells[1],Spells[2]));break;
				case ("Monster Reborn") : result.add(new MonsterReborn(Spells[1],Spells[2]));break;
				case ("Pot of Greed") : result.add(new PotOfGreed(Spells[1],Spells[2]));break;
				case ("Raigeki") : result.add(new Raigeki(Spells[1],Spells[2]));break;
				case ("Graceful Dice") : result.add(new GracefulDice(Spells[1],Spells[2]));break;
				default : throw new UnknownSpellCardException(path,i,Spells[1]);
			  	}
				}else{
					throw new UnknownCardTypeException(path,i,test);
				}
			}
			i++;
			
		}
	
			//System.out.println(result.size());
		return result;
		
	}
	private void buildDeck(ArrayList<Card> monsters, ArrayList<Card> spells) throws CloneNotSupportedException{
		deck = new ArrayList<Card>(20);
		for(int i=0;i<15;i++){
			int j = (int)((monsters.size())*Math.random());
			deck.add((MonsterCard)monsters.get(j).cloneIt());
		}
		for(int i=0;i<5;i++){
			int j = (int)(spells.size()*Math.random());
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
		return deck.remove(0);
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
