package eg.edu.guc.yugioh.listeners;


import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.gui.GUI;
import eg.edu.guc.yugioh.gui.HandButton;

public class DrwaingCardThread implements Runnable {

	
	GUI gui;
	Card hand;
	Controller one;
	int sleep;
	public DrwaingCardThread(GUI gui,Card hand,Controller one,int sleep){
		this.gui = gui;
		this.hand = hand;
		this.one=one;
		this.sleep = sleep;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			HandButton handButton;
			//System.out.println("done");
		
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
		if(hand instanceof MonsterCard){
			handButton = gui.getAc().getHandPanel().addTheButton(hand);
			handButton.setName("Monster");
			//handButton.setVisible(true);
		}else{
			handButton = gui.getAc().getHandPanel().addTheButton(hand);
			handButton.setName("Spell");
			//handButton.setVisible(true);
			}
		handButton.validate();
		handButton.addActionListener(one);
		handButton.addMouseListener(one);
		handButton.addMouseListener(gui.getAc().getHandPanel());
		gui.getAc().getHandPanel().getHandPanel().validate();
	//	gui.getAc().setLocation(92,423);
	//	gui.getAc().setSize(468,300);
		gui.getAc().getHandPanel().getHandPanel().setVisible(true);
		gui.getAc().getHandPanel().setVisible(true);
		handButton.setVisible(true);

		
	}
	
}
