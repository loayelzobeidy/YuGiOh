package eg.edu.guc.yugioh.cards;
import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.*;
import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.cards.spells.*;;
public class MonsterCard extends Card {

	 
	public int getDefensePoints() {
		return defensePoints;
	}
	public boolean getAttack(){
		return Attack;
	}
	public void setAttack(boolean Attack){
		this.Attack=Attack;
	}
	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}
	public int getAttackPoints() {
		return attackPoints;
	}
	public boolean getChanged1(){
		return changed1 ;
	}
	public void setChanged1(boolean changed){
		this.changed1=changed;
	}
	public boolean getChanged2(){
		return changed2 ;
	}
	public void setChanged2(boolean changed){
		this.changed2=changed;
	}
	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}
	public Mode getMode() {
		return mode;
	}
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public int getLevel() {
		return level;
	}
	private int level;
	private int defensePoints;
	private int attackPoints;
	private Mode mode;
    private boolean Attack ;
    private boolean changed1 ;
    private boolean changed2 ;
	public MonsterCard(String name, String description, int level, int attack, int defense){
		super(name,description);
		this.level = level;
		this.attackPoints = attack;
		this.defensePoints = defense;
		mode = Mode.DEFENSE;
		Attack = false ;
		changed1 = false ;
		changed2 = false ;
	}
	public void action  (){
		int difference = getBoard().getOpponentPlayer().getLifePoints()-this.getAttackPoints();
		getBoard().getOpponentPlayer().setLifePoints(difference);
		if(Card.getBoard().getOpponentPlayer().getLifePoints()<=0)
			Card.getBoard().setWinner(Card.getBoard().getActivePlayer());
	}
	public void action(MonsterCard monster){
		if(this.getMode()!=Mode.ATTACK)
			return ; 
		if(this.getLocation()!=Location.FIELD)
			return ;
		if(monster.getLocation()!=Location.FIELD)
			return ;
		if(getBoard().getOpponentPlayer().getField().getMonstersArea().isEmpty())
		 this.action();
		
		if(monster.getMode()==Mode.ATTACK){
			if(this.attackPoints>monster.attackPoints)
			
			{
				int difference = getBoard().getOpponentPlayer().getLifePoints()-(this.attackPoints-monster.attackPoints) ; 
				getBoard().getOpponentPlayer().setLifePoints(difference);
				getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
				
			}
			if(this.attackPoints==monster.attackPoints)
				
			{
				getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
				getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
			}
			if(this.attackPoints<monster.attackPoints)
				
			{
				int difference = getBoard().getActivePlayer().getLifePoints()-(monster.attackPoints-this.attackPoints) ; 
				getBoard().getActivePlayer().setLifePoints(difference);
				getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
				
			}
		}
		else{
				if(this.attackPoints>monster.defensePoints)
				{
					getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
		
				}
				if(this.attackPoints<monster.defensePoints)
				{
					int difference = getBoard().getActivePlayer().getLifePoints()-(monster.defensePoints-this.attackPoints);
				getBoard().getActivePlayer().setLifePoints(difference);
							System.out.println(4);
	}
				
		
	}
		if(getBoard().getOpponentPlayer().getLifePoints()<=0)
			getBoard().setWinner(getBoard().getActivePlayer());
		if(getBoard().getActivePlayer().getLifePoints()<=0)
			getBoard().setWinner(getBoard().getOpponentPlayer());
		Attack=true;	
		}
	
	/*public static void main(String[] args)throws Exception {
     Board b1 = new Board();
     Player P1 = new Player ("Yugi");
     Player P2 = new Player ("Kaiba");
     b1.startGame(P1, P2);
   SpellCard c1 = new CardDestruction("SADF","FASDFSA");
    System.out.println(b1.getActivePlayer().getField().getGraveyard());
     MonsterCard monster1 = new MonsterCard("blb","asfds",4,3000,320);
     MonsterCard monster2 = new MonsterCard("blb","asfds",4,3000,4000);
     b1.getActivePlayer().getField().addMonsterToField(monster2, Mode.DEFENSE, true);
     b1.getActivePlayer().getField().addMonsterToField(monster1, Mode.DEFENSE, true);
     System.out.println(b1.getActivePlayer().getField().getMonstersArea());
    b1.getActivePlayer().getField().removeMonsterToGraveyard(b1.getActivePlayer().getField().getMonstersArea());
    // System.out.println( monster1.
    System.out.println(b1.getActivePlayer().getField().getMonstersArea());
    System.out.println(b1.getActivePlayer().getField().getGraveyard());
  
	}*/
}
