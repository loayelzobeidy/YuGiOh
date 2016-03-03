package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;

public class HandPanel extends JPanel implements MouseListener {
	private ArrayList<HandButton> handButtons;
	private ArrayList<Card> theHand;
	private JPanel backCards;
	OverlapLayout layout;
	ImageIcon BabyDragon = new ImageIcon(getClass().getResource("Baby Dragon.png"));
	ImageIcon AlexandriteDragon = new ImageIcon(getClass().getResource("Alexandrite Dragon.jpg"));
	ImageIcon AlligatorSword = new ImageIcon(getClass().getResource("Alligator Sword.png"));
	ImageIcon AlphaTheMagnetWarrior = new ImageIcon(getClass().getResource("Alpha The Magnet Warrior.png"));
	ImageIcon BetaTheMagnetWarrior  = new ImageIcon(getClass().getResource("Beta The Magnet Warrior.png"));
	ImageIcon BigShieldGardna = new ImageIcon(getClass().getResource("Big Shield Gardna.jpg"));
	ImageIcon BlueEyesWhiteDragon = new ImageIcon(getClass().getResource("Blue-Eyes White Dragon.jpg"));
	ImageIcon CelticGuardian = new ImageIcon(getClass().getResource("Celtic Guardian.png"));
	ImageIcon ClownZombie = new ImageIcon(getClass().getResource("Clown Zombie.jpg"));
	ImageIcon CosmoQueen = new ImageIcon(getClass().getResource("Cosmo Queen.jpg"));
	ImageIcon CurseOfDragon = new ImageIcon(getClass().getResource("Curse Of Dragon.png"));
	ImageIcon CyberJar = new ImageIcon(getClass().getResource("Cyber Jar.png"));
	ImageIcon DarkMagicianGirl = new ImageIcon(getClass().getResource("Dark Magician Girl.jpg"));
	ImageIcon DarkMagician = new ImageIcon(getClass().getResource("Dark Magician.jpg"));
	ImageIcon GiaTheFierceKnight = new ImageIcon(getClass().getResource("Gaia The Fierce Knight.jpg"));
	ImageIcon GammaTheMagnetWarrior = new ImageIcon(getClass().getResource("Gamma The Magnet Warrior.png"));
	ImageIcon GeminiElf = new ImageIcon(getClass().getResource("Gemini Elf.png"));
	ImageIcon HarpieLady = new ImageIcon(getClass().getResource("Harpie Lady.png"));
	ImageIcon Kuriboh = new ImageIcon(getClass().getResource("Kuriboh.jpg"));
	ImageIcon ManEaterBug = new ImageIcon(getClass().getResource("Man-Eater Bug.jpg"));
	ImageIcon MokeyMokey = new ImageIcon(getClass().getResource("Mokey Mokey.jpg"));
	ImageIcon VorseRaider = new ImageIcon(getClass().getResource("Vorse Raider.png"));
	ImageIcon RedEyesBlackDragon = new ImageIcon(getClass().getResource("Red-Eyes Black Dragon.jpg"));
	ImageIcon SummonedSkull = new ImageIcon(getClass().getResource("Summoned Skull.png"));
	ImageIcon WittyPhantom = new ImageIcon(getClass().getResource("Witty Phantom.jpg"));
	ImageIcon TimeWizard = new ImageIcon(getClass().getResource("Time Wizard.jpg"));
	ImageIcon FenceGuard = new ImageIcon(getClass().getResource("Fence Guard.jpeg"));
	ImageIcon FenceGuardMagician = new ImageIcon(getClass().getResource("fenceguardMagician.jpeg"));
	ImageIcon FenceGuardDragon = new ImageIcon(getClass().getResource("Fence Guard Dragon.png"));
	ImageIcon FenceGuardApprentice = new ImageIcon(getClass().getResource("Fence Guard Apprentice.png"));
	
	ImageIcon CardDestruction = new ImageIcon(getClass().getResource("Card Destruction.jpg"));
	ImageIcon ChangeofHeart = new ImageIcon(getClass().getResource("Change Of Heart.jpg"));
	ImageIcon DarkHole = new ImageIcon(getClass().getResource("Dark Hole.jpg"));
	ImageIcon GracefulDice = new ImageIcon(getClass().getResource("Graceful Dice.png"));
	ImageIcon HarpieFeather = new ImageIcon(getClass().getResource("Harpie's Feather Duster.png"));
	ImageIcon HeavyStorm = new ImageIcon(getClass().getResource("Heavy Storm.png"));
	ImageIcon MegaPower = new ImageIcon(getClass().getResource("Mage Power.png"));
	ImageIcon MonsterReborn = new ImageIcon(getClass().getResource("Monster Reborn.jpg"));
	ImageIcon PotOfGreed = new ImageIcon(getClass().getResource("Pot of Greed.jpg"));
	ImageIcon Raigeki = new ImageIcon(getClass().getResource("Raigeki.jpg"));


	
	public ImageIcon resizeImage(ImageIcon imageIcon,int w,int h){
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg); 
		return imageIcon;
	}
	
	public ArrayList<Card> getTheHand() {
		return theHand;
	}

	public void setTheHand(ArrayList<Card> theHand) {
		this.theHand = theHand;
	}

	//private JLabel lifePoints;
	private JPanel handPanel;
	public HandPanel(){
		super();
		this.setOpaque(false);
		backCards = new JPanel();
		backCards.setVisible(false);
		backCards.setOpaque(false);
		handPanel = new JPanel();
		handPanel.setOpaque(false);
		layout = new OverlapLayout(new Point(25, 0));
		OverlapLayout layout2 = new OverlapLayout(new Point(25, 0));
		layout.setPopupInsets(new Insets(17,4,0,0));
		handPanel.setLayout(layout);
		backCards.setLayout(layout2);
		handButtons = new ArrayList<HandButton>();
		this.setLayout(new FlowLayout());
		this.add(backCards);
		this.add(handPanel);
	}

	public HandButton addTheButton(Card c){

		String name = c.getName();
		HandButton m =new HandButton(new ImageIcon(""));
		switch (name){
		case "Blue-Eyes White Dragon" : m=new HandButton(BlueEyesWhiteDragon);break;
		case "Cosmo Queen" : m=new HandButton(CosmoQueen);break;
		case "Dark Magician" : m=new HandButton(DarkMagician);break;
		case "Red-Eyes Black Dragon" : m=new HandButton(RedEyesBlackDragon);break;
		case "Gaia The Fierce Knight" : m=new HandButton(GiaTheFierceKnight);break;
		case "Summoned Skull" : m=new HandButton(SummonedSkull);break;
		//case "Fence Guard Magician" : m=new MonsterButton(FenceGuardMagician);
		case "Dark Magician Girl" : m=new HandButton(DarkMagicianGirl);break;
		case "Curse Of Dragon" : m= new HandButton(CurseOfDragon);break;
		//case "Fence Guard Dragon" : m=new MonsterButton(FenceGuardDragon);
		case "Alexandrite Dragon" : m=new HandButton(AlexandriteDragon);break;
		case "Vorse Raider" : m=new HandButton(VorseRaider);break;
		case "Gemini Elf" : m = new HandButton(GeminiElf);break;
		//case "Fence Guard Apprentice" : m=new MonsterButton(FenceGuardApprentice);
		case "Beta The Magnet Warrior" : m = new HandButton(BetaTheMagnetWarrior);break;
		case "Alligator Sword" : m=new HandButton(AlligatorSword);break;
		case "Gamma The Magnet Warrior" : m=new HandButton(GammaTheMagnetWarrior);break;
		case "Celtic Guardian" : m = new HandButton(CelticGuardian);break;
		case "Alpha The Magnet Warrior" : m = new HandButton(AlphaTheMagnetWarrior);break;
		case "Harpie Lady" : m= new HandButton(HarpieLady);break;
		case "Big Shield Gardna" : m= new HandButton(BigShieldGardna);break;
		case "Witty Phantom" : m=new HandButton(WittyPhantom);break;
		case "Baby Dragon" : m=new HandButton (BabyDragon);break;
		case "Cyber Jar" : m=new HandButton(CyberJar);break;
		case "Clown Zombie" : m=new HandButton(ClownZombie);break;
		case "Time Wizard" : m=new HandButton(TimeWizard);break;
		case "Man-Eater Bug" : m=new HandButton(ManEaterBug);break;
		case "Kuriboh" : m=new HandButton(Kuriboh);break;
		case "Mokey Mokey" : m= new HandButton(MokeyMokey);break;
		case "Fence Guard" : m= new HandButton(FenceGuard);break;
		case "Fence Guard Magician" : m= new HandButton(FenceGuardMagician);break;
		case "Fence Guard Dragon" : m= new HandButton(FenceGuardDragon);break;
		case "Fence Guard Apprentice" : m= new HandButton(FenceGuardApprentice);break;		
		case "Dark Hole" : m=new HandButton(DarkHole);break;
		case "Graceful Dice" : m = new HandButton(GracefulDice);break;
		case "Heavy Storm" : m= new HandButton(HeavyStorm);break;
		case "Mage Power" : m= new HandButton(MegaPower);break;
		case "Monster Reborn" : m = new HandButton(MonsterReborn);break;
		case "Pot of Greed" : m=new HandButton(PotOfGreed);break;
		case "Harpie's Feather Duster" : m= new HandButton(HarpieFeather);break;
		case "Raigeki" : m= new HandButton(Raigeki);break;
		case "Card Destruction" : m= new HandButton(CardDestruction);break;
		case "Change Of Heart" : m= new HandButton(ChangeofHeart);break;
		}
		
		handPanel.add(m);
		handButtons.add(m);
		BackHandButton b = new BackHandButton();
		backCards.add(b);
		m.setVisible(true);
		b.setVisible(true);
		m.validate();
		return m;
	}
	
	
	public JPanel getBackCards() {
		return backCards;
	}

	public void setBackCards(JPanel backCards) {
		this.backCards = backCards;
	}

//	public JLabel getLifePoints() {
//		return lifePoints;
//	}
//
//	public void setLifePoints(JLabel lifePoints) {
//		this.lifePoints = lifePoints;
//	}

	public JPanel getHandPanel() {
		return handPanel;
	}

	public void setHandPanel(JPanel handPanel) {
		this.handPanel = handPanel;
	}

	public ArrayList<HandButton> getHandButtons() {
		return handButtons;
	}

	public void addToHand(HandButton h,Card c){
		
	}

	public void setHandButtons(ArrayList<HandButton> handButtons) {
		this.handButtons = handButtons;
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	    Component c = e.getComponent();

	   // Boolean constraint = layout.getConstraints(c);

	  //  if (constraint == null || constraint == OverlapLayout.POP_DOWN)
	        layout.addLayoutComponent(c, OverlapLayout.POP_UP);
	  //  else
	    //    layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);

	    c.getParent().invalidate();
	    c.getParent().validate();
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Component c = e.getComponent();
	   // Boolean constraint = layout.getConstraints(c);

	  //  if (constraint == null || constraint == OverlapLayout.POP_DOWN)
	        layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);
	  //  else
	    //    layout.addLayoutComponent(c, OverlapLayout.POP_DOWN);

	    c.getParent().invalidate();
	    c.getParent().validate();
		
	}
	
}