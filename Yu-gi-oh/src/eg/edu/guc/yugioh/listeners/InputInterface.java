package eg.edu.guc.yugioh.listeners;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;

public class InputInterface extends JFrame implements ActionListener, MouseListener {
	JLabel background=new JLabel(new ImageIcon(getClass().getResource("yu_gi_oh_wallpaper_by_corki_gfx-d60vjn0.png")));
	TextField name1;
	TextField name2;
	JLabel startGameLabel;
	public InputInterface(){
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		add(background);
		background.setLayout(null);
		name1 = new TextField();
		name2 = new TextField();
		JLabel PlayerLabel1 = new JLabel("Player 1");
		JLabel PlayerLabel2 = new JLabel("Player 2");
		PlayerLabel1.setFont(new Font("Papyrus",Font.ITALIC,40));
		PlayerLabel2.setFont(new Font("Papyrus",Font.ITALIC,40));
		PlayerLabel1.setForeground(java.awt.Color.YELLOW);
		PlayerLabel2.setForeground(java.awt.Color.YELLOW);

		
		JButton StartGame = new JButton();
		StartGame.setSize(460,150);
		StartGame.setLocation(110, 300);
		startGameLabel = new JLabel("START GAME");
		startGameLabel.setFont(new Font("Papyrus",Font.ITALIC,60));
		startGameLabel.setForeground(java.awt.Color.red);
		StartGame.add(startGameLabel);
		background.add(StartGame);
		StartGame.setOpaque(false);
		StartGame.setContentAreaFilled(false);
		StartGame.setBorderPainted(false);
		StartGame.addActionListener(this);
		StartGame.addMouseListener(this);
		PlayerLabel1.setSize(200,40);
		PlayerLabel2.setSize(200,40);
		PlayerLabel1.setLocation(100,210);
		PlayerLabel2.setLocation(100,260);
		background.add(PlayerLabel1);
		background.add(PlayerLabel2);
		//JOptionPane.showInternalInputDialog(background, "Enter the first player name");
		name1.setSize(200,40);
		name2.setSize(200,40);
		name1.setLocation(340, 200);
		name2.setLocation(340, 250);
		name1.setBackground(java.awt.Color.YELLOW);
		name2.setBackground(java.awt.Color.YELLOW);
		background.add(name1);
		background.add(name2);
		setSize(799,599);
		setSize(800,600);
		background.validate();
	}
	
	public JLabel getStartGameLabel() {
		return startGameLabel;
	}

	public void setStartGameLabel(JLabel startGameLabel) {
		this.startGameLabel = startGameLabel;
	}

	public static void main(String[] args) {
	InputInterface x =	new InputInterface();
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {
		this.getStartGameLabel().setForeground(java.awt.Color.YELLOW);
	}

	public void mouseExited(MouseEvent e) {
		this.getStartGameLabel().setForeground(java.awt.Color.red);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			Main x = new Main(this.getName1().getText(),this.getName2().getText());
			dispose();
		} catch (NumberFormatException | MissingFieldException
				| EmptyFieldException | UnknownSpellCardException
				| UnknownCardTypeException | CloneNotSupportedException
				| IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public TextField getName1() {
		return name1;
	}

	public void setName1(TextField name1) {
		this.name1 = name1;
	}

	public TextField getName2() {
		return name2;
	}

	public void setName2(TextField name2) {
		this.name2 = name2;
	}
	
}
