package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class EndTurnButton extends JButton implements MouseListener {
	JLabel decky;
	public EndTurnButton(){
		super();
		decky = new JLabel("TURN");
		decky.setFont(new Font("Papyrus", Font.ITALIC, 15));
		decky.setForeground(Color.LIGHT_GRAY);
		this.add(decky);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		this.setPreferredSize(new Dimension(66, 92));
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
		decky.setForeground(Color.green);
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		decky.setForeground(Color.LIGHT_GRAY);
		
	}
}
