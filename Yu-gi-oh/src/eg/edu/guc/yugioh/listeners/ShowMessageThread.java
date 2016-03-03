package eg.edu.guc.yugioh.listeners;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.gui.GUI;

public class ShowMessageThread implements Runnable {
	String message;
	GUI gui;
	Player active;
	public ShowMessageThread(GUI gui,String message,Player active){
		this.gui=gui;
		this.message = message;
		this.active=active;
	}
	
	@Override
	public void run() {
		gui.getCurrentPhase().setLocation(20, 340);
		gui.getCurrentPhase().setText(message);

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				gui.getCurrentPhase().setLocation(20, 340);
				gui.getCurrentPhase().setText(message);

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String phase = active.getField().getPhase()+"";
			gui.getCurrentPhase().setLocation(243, 340);
			gui.getCurrentPhase().setText(phase);
		
		gui.getCurrentPhase().setSize(999,39);
		gui.getCurrentPhase().setSize(1000,40);

		
		
	}
	
}
