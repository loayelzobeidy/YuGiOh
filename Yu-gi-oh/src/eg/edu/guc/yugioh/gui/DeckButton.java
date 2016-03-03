package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DeckButton extends JButton {
	static ImageIcon water = new ImageIcon("Back card.png");

	public DeckButton(){
		super(water);
		this.setPreferredSize(new Dimension(80, 128));
	}
}
