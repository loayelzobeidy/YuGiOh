package eg.edu.guc.yugioh.cards;


public class MonsterCard extends Card {

	public int getDefensePoints() {
		return defensePoints;
	}
	public void setDefensePoints(int defensePoints) {
		this.defensePoints = defensePoints;
	}
	public int getAttackPoints() {
		return attackPoints;
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
	
	boolean changedMode;
	boolean attacked;
	public boolean isAttacked() {
		return attacked;
	}
	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}
	public MonsterCard(String name, String description, int level, int attack, int defense){
		super(name,description);
		this.level = level;
		this.attackPoints = attack;
		this.defensePoints = defense;
		mode = Mode.DEFENSE;
		changedMode = false;
		attacked = false;
	}


	public boolean isChangedMode() {
		return changedMode;
	}
	public void setChangedMode(boolean changedMode) {
		this.changedMode = changedMode;
	}
	public void action(MonsterCard monster) {
		
		if(monster.mode==Mode.ATTACK){
			if(this.getAttackPoints()>monster.getAttackPoints()){
				int differencePoints = this.getAttackPoints()-monster.getAttackPoints();
				getBoard().getOpponentPlayer().setLifePoints(getBoard().getOpponentPlayer().getLifePoints()-differencePoints);
						if(getBoard().getOpponentPlayer().getLifePoints()<=0){
							getBoard().setWinner(getBoard().getActivePlayer());
						}
			getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
			}else{
				if(monster.getAttackPoints()>this.getAttackPoints()){
					int differencePoints = monster.getAttackPoints()-this.getAttackPoints();
					getBoard().getActivePlayer().setLifePoints(getBoard().getActivePlayer().getLifePoints()-differencePoints);
							if(getBoard().getActivePlayer().getLifePoints()<=0){
								getBoard().setWinner(getBoard().getOpponentPlayer());
							}
							getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
							
				}else{
					getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
					getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
				}
			}
		}else{
			if(this.getAttackPoints()>monster.getDefensePoints()){
				getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
			}
			else
			{
				if(this.getAttackPoints()==monster.getDefensePoints()){
				//	getBoard().getOpponentPlayer().getField().removeMonsterToGraveyard(monster);
				//	getBoard().getActivePlayer().getField().removeMonsterToGraveyard(this);
				}
				else{
					int differencePoints = this.getAttackPoints()-monster.getDefensePoints();
					getBoard().getActivePlayer().setLifePoints(getBoard().getActivePlayer().getLifePoints()+differencePoints);
					if(getBoard().getActivePlayer().getLifePoints()<=0){
						getBoard().setWinner(getBoard().getOpponentPlayer());
					}
				}
			}
		}	
	}
	public void action(){
		getBoard().getOpponentPlayer().setLifePoints(getBoard().getOpponentPlayer().getLifePoints()-this.getAttackPoints());
		if(getBoard().getOpponentPlayer().getLifePoints()<=0){
			getBoard().setWinner(getBoard().getActivePlayer());
		}
	}
}
