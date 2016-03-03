package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;





import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class SpellsAndMonstersPanel extends JPanel {
	
	private ArrayList<MonsterCard> monsters;
	private ArrayList<SpellCard> spells;
	private ArrayList<SpellButton> spellButtons;
	private ArrayList<MonsterButton> monsterButtons;
	private JPanel monstersPanel;
	private JPanel spellsPanel;
	private OverlapLayout layout2;
	private OverlapLayout layout;
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

	ImageIcon DefenseMode = new ImageIcon(getClass().getResource("DefenseMode.png"));

	ImageIcon setSpell = new ImageIcon(getClass().getResource("setSpell.jpeg"));

	public ArrayList<MonsterButton> getMonsterButtons() {
		return monsterButtons;
	}

	public void setMonsterButtons(ArrayList<MonsterButton> monsterButtons) {
		this.monsterButtons = monsterButtons;
	}

	public SpellsAndMonstersPanel(){
		super();
		this.setOpaque(false);
		monstersPanel = new JPanel();
		monstersPanel.setOpaque(false);
		spellsPanel = new JPanel();
		spellsPanel.setOpaque(false);
		//monstersPanel.setPreferredSize(new Dimension(1000,120));
		//spellsPanel.setPreferredSize(new Dimension(1000,120));
		layout = new OverlapLayout(new Point(90, 0));
		layout2 = new OverlapLayout(new Point(90, 0));
	//	layout2.setPopupInsets(new Insets(30,0,0,0));
	//	layout.setPopupInsets(new Insets(20, 0, 0, 0));
		
		
		monstersPanel.setLayout(layout);
		spellsPanel.setLayout(layout2);
		//monstersPanel.setPreferredSize(new Dimension(450, 93));
		monsters = new ArrayList<MonsterCard>();
		spells = new ArrayList<SpellCard>();
		this.setLayout(new GridLayout(2,1));
	//	setSize(900,300);
		//monstersPanel.setBounds(0, 110, 1280, 110);
		this.add(monstersPanel);
		this.add(spellsPanel);
		monsterButtons = new ArrayList<MonsterButton>();
		spellButtons = new ArrayList<SpellButton>();
		
	}

	public OverlapLayout getLayout2() {
		return layout2;
	}

	public void setLayout2(OverlapLayout layout2) {
		this.layout2 = layout2;
	}

	public OverlapLayout getLayout() {
		return layout;
	}

	public void setLayout(OverlapLayout layout) {
		this.layout = layout;
	}

	public ArrayList<MonsterCard> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<MonsterCard> monsters) {
		this.monsters = monsters;
	}

	public ArrayList<SpellCard> getSpells() {
		return spells;
	}

	public void setSpells(ArrayList<SpellCard> spells) {
		this.spells = spells;
	}

	public JPanel getMonstersPanel() {
		return monstersPanel;
	}

	public void setMonstersPanel(JPanel monstersPanel) {
		this.monstersPanel = monstersPanel;
	}

	public JPanel getSpellsPanel() {
		return spellsPanel;
	}

	public void setSpellsPanel(JPanel spellsPanel) {
		this.spellsPanel = spellsPanel;
	}

	public MonsterButton summon(MonsterCard c){
		//int index = monsters.size();
		monsters.add(c);
		String name = c.getName();
		MonsterButton m =new MonsterButton(MokeyMokey);
		switch (name){
		case "Blue-Eyes White Dragon" : m=new MonsterButton(BlueEyesWhiteDragon);break;
		case "Cosmo Queen" : m=new MonsterButton(CosmoQueen);break;
		case "Dark Magician" : m=new MonsterButton(DarkMagician);break;
		case "Red-Eyes Black Dragon" : m=new MonsterButton(RedEyesBlackDragon);break;
		case "Gaia The Fierce Knight" : m=new MonsterButton(GiaTheFierceKnight);break;
		case "Summoned Skull" : m=new MonsterButton(SummonedSkull);break;
		case "Dark Magician Girl" : m=new MonsterButton(DarkMagicianGirl);break;
		case "Curse Of Dragon" : m= new MonsterButton(CurseOfDragon);break;
		case "Alexandrite Dragon" : m=new MonsterButton(AlexandriteDragon);break;
		case "Vorse Raider" : m=new MonsterButton(VorseRaider);break;
		case "Gemini Elf" : m = new MonsterButton(GeminiElf);break;
		case "Beta The Magnet Warrior" : m = new MonsterButton(BetaTheMagnetWarrior);break;
		case "Alligator Sword" : m=new MonsterButton(AlligatorSword);break;
		case "Gamma The Magnet Warrior" : m=new MonsterButton(GammaTheMagnetWarrior);break;
		case "Celtic Guardian" : m = new MonsterButton(CelticGuardian);break;
		case "Alpha The Magnet Warrior" : m = new MonsterButton(AlphaTheMagnetWarrior);break;
		case "Harpie Lady" : m= new MonsterButton(HarpieLady);break;
		case "Big Shield Gardna" : m= new MonsterButton(BigShieldGardna);break;
		case "Witty Phantom" : m=new MonsterButton(WittyPhantom);break;
		case "Baby Dragon" : m=new MonsterButton(BabyDragon);break;
		case "Cyber Jar" : m=new MonsterButton(CyberJar);break;
		case "Clown Zombie" : m=new MonsterButton(ClownZombie);break;
		case "Time Wizard" : m=new MonsterButton(TimeWizard);break;
		case "Man-Eater Bug" : m=new MonsterButton(ManEaterBug);break;
		case "Kuriboh" : m=new MonsterButton(Kuriboh);break;
		case "Mokey Mokey" : m= new MonsterButton(MokeyMokey);break;
		case "Fence Guard" : m= new MonsterButton(FenceGuard);break;
		case "Fence Guard Magician" : m= new MonsterButton(FenceGuardMagician);break;
		case "Fence Guard Dragon" : m= new MonsterButton(FenceGuardDragon);break;
		case "Fence Guard Apprentice" : m= new MonsterButton(FenceGuardApprentice);break;
		}

		monstersPanel.add(m);
		monsterButtons.add(m);
		
		return m;
	}
	public void changeMode(MonsterButton m,MonsterCard c,GUI gui){
		if(c.getMode()==Mode.DEFENSE){
			m.setIcon(DefenseMode);
			if(!this.getName().equals(gui.getP2Name())){
			m.setVerticalAlignment(SwingConstants.BOTTOM);
			}else{
			System.out.println("dbf");
			m.setVerticalAlignment(SwingConstants.TOP);
			}
		}else{
			switch(c.getName()){
			case "Blue-Eyes White Dragon" : m.setIcon(BlueEyesWhiteDragon);break;
			case "Cosmo Queen" : m.setIcon(CosmoQueen);break;
			case "Dark Magician" : m.setIcon(DarkMagician);break;
			case "Red-Eyes Black Dragon" : m.setIcon(RedEyesBlackDragon);break;
			case "Gaia The Fierce Knight" : m.setIcon(GiaTheFierceKnight);break;
			case "Summoned Skull" : m.setIcon(SummonedSkull);break;
			case "Dark Magician Girl" : m.setIcon(DarkMagicianGirl);break;
			case "Curse Of Dragon" : m.setIcon(CurseOfDragon);break;
			case "Alexandrite Dragon" : m.setIcon(AlexandriteDragon);break;
			case "Vorse Raider" : m.setIcon(VorseRaider);break;
			case "Gemini Elf" : m.setIcon(GeminiElf);break;
			case "Beta The Magnet Warrior" : m.setIcon(BetaTheMagnetWarrior);break;
			case "Alligator Sword" : m.setIcon(AlligatorSword);break;
			case "Gamma The Magnet Warrior" : m.setIcon(GammaTheMagnetWarrior);break;
			case "Celtic Guardian" : m.setIcon(CelticGuardian);break;
			case "Alpha The Magnet Warrior" : m.setIcon(AlphaTheMagnetWarrior);break;
			case "Harpie Lady" : m.setIcon(HarpieLady);break;
			case "Big Shield Gardna" : m.setIcon(BigShieldGardna);break;
			case "Witty Phantom" : m.setIcon(WittyPhantom);break;
			case "Baby Dragon" : m.setIcon(BabyDragon);break;
			case "Cyber Jar" : m.setIcon(CyberJar);break;
			case "Clown Zombie" : m.setIcon(ClownZombie);break;
			case "Time Wizard" : m.setIcon(TimeWizard);break;
			case "Man-Eater Bug" : m.setIcon(ManEaterBug);break;
			case "Kuriboh" : m.setIcon(Kuriboh);break;
			case "Mokey Mokey" : m.setIcon(MokeyMokey);break;
			case "Fence Guard" : m.setIcon(FenceGuard);break;
			case "Fence Guard Magician" : m.setIcon(FenceGuardMagician);break;
			case "Fence Guard Dragon" : m.setIcon(FenceGuardDragon);break;
			case "Fence Guard Apprentice" : m.setIcon(FenceGuardApprentice);break;

			}
		}
	}
	
	public MonsterButton set(MonsterCard c,GUI gui){
		MonsterButton m=new MonsterButton(DefenseMode);
		if(!this.getName().equals(gui.getP2Name())){
			m.setVerticalAlignment(SwingConstants.BOTTOM);
			}else{
			m.setVerticalAlignment(SwingConstants.TOP);
			}
		monsters.add(c);
		monstersPanel.add(m);
		monsterButtons.add(m);
		return m;
	}
	public SpellButton setSpell(SpellCard c){
		SpellButton m = new SpellButton(setSpell);
		spells.add(c);
		spellsPanel.add(m);
		spellButtons.add(m);
		return m;
	}
	public ArrayList<SpellButton> getSpellButtons() {
		return spellButtons;
	}

	public void setSpellButtons(ArrayList<SpellButton> spellButtons) {
		this.spellButtons = spellButtons;
	}
	
}
