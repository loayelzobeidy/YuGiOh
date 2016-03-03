package eg.edu.guc.yugioh.listeners;

import eg.edu.guc.yugioh.gui.GUI;

public class firstThread implements Runnable {
	GUI gui;
	int oldActivePoints;
	int oldOpponentPoints;
	int sleep;
	public firstThread(int oldActivePoints,int oldOpponentPoints,GUI gui,int sleep){
		this.gui = gui;
		this.oldActivePoints = oldActivePoints;
	//	this.currentActivePoints = currentActivePoints;
		this.oldOpponentPoints = oldOpponentPoints;
	//	this.currentOpponentPoints = currentOpponentPoints;
		this.sleep = sleep;
		
	}
	@Override
	public void run() {
		try {
			Thread.sleep(sleep);
			gui.setActiveNumber(oldActivePoints+"");
			gui.setOpponentNumber(oldOpponentPoints+"");
			

			//System.out.println("working");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

}
