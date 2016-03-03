package eg.edu.guc.yugioh.listeners;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import eg.edu.guc.yugioh.gui.GUI;

public class GracefulDiceThread implements Runnable {
	private int Extra;
	private GUI gui;
//	ImageIcon Download = new ImageIcon(getClass().getResource("download.png"));

	public GracefulDiceThread(GUI gui,int extra){
		Extra = extra;
		this.gui=gui;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		JLabel extra = new JLabel(Extra+"Attack and Defense points");
		String phase = gui.getCurrentPhase().getText();
		gui.getCurrentPhase().setText("All monsters gained "+Extra+" points");
		gui.getCurrentPhase().setLocation(40, 340);


		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gui.getCurrentPhase().setLocation(270, 340);
		gui.getCurrentPhase().setText(phase);


	}

}
