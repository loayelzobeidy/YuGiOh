package eg.edu.guc.yugioh.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class HandButton extends JButton {
	public HandButton(ImageIcon i){
		super(i);
		this.setPreferredSize(new Dimension(64, 93));
	}
	
	
}
