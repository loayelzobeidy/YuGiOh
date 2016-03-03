package eg.edu.guc.yugioh.gui;

import eg.edu.guc.yugioh.board.player.Player;

public class RemoveSpellAfterSecond implements Runnable {

	
	private SpellButton x;
	private GUI gui;
	private Player p;
	public RemoveSpellAfterSecond(SpellButton x,GUI gui,Player p){
		this.x=x;
		this.gui = gui;
		this.p=p;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
			x.setVisible(false);
			gui.getAc().getSpellsAndMonstersPanel().getSpellsPanel().remove(x);
			gui.getAc().getSpellsAndMonstersPanel().remove(x);
			if(gui.getP1Name()==p.getName()){
				gui.getGraveyardActive().setIcon(x.getIcon());
			}else{
				gui.getGraveyardOpponent().setIcon(x.getIcon());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
