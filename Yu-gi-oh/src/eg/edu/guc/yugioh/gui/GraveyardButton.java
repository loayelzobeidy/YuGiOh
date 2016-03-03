package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GraveyardButton extends JButton {
	//static ImageIcon water = new ImageIcon("Back card.png");
	public GraveyardButton(){
		super();
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setPreferredSize(new Dimension(66, 190));
		//this.setOpaque(false);
	}
}
