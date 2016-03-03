import javax.swing.*;

import eg.edu.guc.yugioh.gui.PlayerPanel;

import java.awt.*;
import java.awt.event.*;
class BackgroundImageJFrame extends JFrame
{
JButton b1;
JLabel l1;
	public BackgroundImageJFrame()
	{
	setTitle("Background Color for JFrame");
	setSize(1200,750);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);


	setLayout(new BorderLayout());
	JLabel background=new JLabel(new ImageIcon("yu_gi_oh_wallpaper_by_corki_gfx-d60vjn0.png"));
	add(background);
	background.setLayout(new BorderLayout());
	l1=new JLabel("Here is a button");
	b1=new JButton("I am a button");
	background.add(l1,BorderLayout.NORTH);
	//background.add(b1,BorderLayout.EAST);
	//PlayerPanel ac = new PlayerPanel("ahmed");
//background.add(ac,BorderLayout.SOUTH);
// Another way
//	setLayout(new BorderLayout());
//	setContentPane(new JLabel(new ImageIcon("yu_gi_oh_wallpaper_by_corki_gfx-d60vjn0.png")));
//	setLayout(new FlowLayout());
//	l1=new JLabel("Here is a button");
//	b1=new JButton("I am a button");
//	add(l1);
//	add(b1);
	// Just for refresh :) Not optional!
	setSize(1199,749);
	setSize(1200,750);
	}
	public static void main(String args[])
	{
	new BackgroundImageJFrame();
	}
}