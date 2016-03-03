package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ActivateClick extends JButton implements MouseListener {
	JLabel currentPhase;
	public ActivateClick(){
		super();
		currentPhase = new JLabel("Activate");
		currentPhase.setFont(new Font("Papyrus", Font.BOLD, 25));
		currentPhase.setForeground(Color.LIGHT_GRAY);
		this.add(currentPhase);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setPreferredSize(new Dimension(160,40));
		this.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		currentPhase.setForeground(Color.GREEN);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		currentPhase.setForeground(Color.LIGHT_GRAY);
	}
}
