package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SpellButton extends JButton {
	public SpellButton(ImageIcon i){
		super(i);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setPreferredSize(new Dimension(93,93));
	}

	
	
}
