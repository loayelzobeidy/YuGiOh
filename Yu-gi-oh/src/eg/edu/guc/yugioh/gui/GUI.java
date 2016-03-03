package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Window;


import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;


import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class GUI extends JFrame{
		private PlayerPanel ac;
		private PlayerPanel op;
		private EndPhaseButton endPhase;
		private EndTurnButton endTurn;
		private JLabel currentPhase;
		private DeckButton DeckActive;
		private DeckButton DeckOpponent;
		private GraveyardButton graveyardActive;
		private GraveyardButton graveyardOpponent;
		private JLabel activeLifePoints;
		private JLabel opponentLifePoints;
		private JLabel activeNumber;
		private String p1Name;
		private String p2Name;
		
		//AudioClip GameplayAudio =JApplet.newAudioClip(getClass().getResource("videoplayback_2_.wav"));

		static ImageIcon water = new ImageIcon("Back card.png");		
		ImageIcon BabyDragon = new ImageIcon(getClass().getResource("Baby DragonBig.png"));
		ImageIcon AlexandriteDragon = new ImageIcon(getClass().getResource("Alexandrite DragonBig.png"));
		ImageIcon AlligatorSword = new ImageIcon(getClass().getResource("Alligator SwordBig.png"));
		ImageIcon AlphaTheMagnetWarrior = new ImageIcon(getClass().getResource("Alpha the magnit warriorBig.png"));
		ImageIcon BetaTheMagnetWarrior  = new ImageIcon(getClass().getResource("Beta The Magnet WarriorBig.png"));
		ImageIcon BigShieldGardna = new ImageIcon(getClass().getResource("BigShieldGardnaBig.jpg"));
		ImageIcon BlueEyesWhiteDragon = new ImageIcon(getClass().getResource("Blue-Eyes White DragonBig.jpg"));
		ImageIcon CelticGuardian = new ImageIcon(getClass().getResource("Celtic GuardianBig.png"));
		ImageIcon ClownZombie = new ImageIcon(getClass().getResource("Clown ZombieBig.jpg"));
		ImageIcon CosmoQueen = new ImageIcon(getClass().getResource("Cosmo QueenBig.jpg"));
		ImageIcon CurseOfDragon = new ImageIcon(getClass().getResource("Curse Of DragomBig.png"));
		ImageIcon CyberJar = new ImageIcon(getClass().getResource("Cyber JarkBig.png"));
		ImageIcon DarkMagicianGirl = new ImageIcon(getClass().getResource("Dark Magician GirlBig.jpg"));
		ImageIcon DarkMagician = new ImageIcon(getClass().getResource("Dark MagicianBig.jpg"));
		ImageIcon GiaTheFierceKnight = new ImageIcon(getClass().getResource("Gaia The Fierce KnightBig.jpg"));
		ImageIcon GammaTheMagnetWarrior = new ImageIcon(getClass().getResource("Gamma The Magnet WarriorBig.png"));
		ImageIcon GeminiElf = new ImageIcon(getClass().getResource("Gemini ElfBig.jpg"));
		ImageIcon HarpieLady = new ImageIcon(getClass().getResource("HarpieLadyBig.png"));
		ImageIcon Kuriboh = new ImageIcon(getClass().getResource("KuribohBig.png"));
		ImageIcon ManEaterBug = new ImageIcon(getClass().getResource("Man-Eater BugBig.jpg"));
		ImageIcon MokeyMokey = new ImageIcon(getClass().getResource("MokeyMokeyBig.jpg"));
		ImageIcon VorseRaider = new ImageIcon(getClass().getResource("Vorse RaiderBig.png"));
		ImageIcon RedEyesBlackDragon = new ImageIcon(getClass().getResource("Red-Eyes Black DragonBig.jpg"));
		ImageIcon SummonedSkull = new ImageIcon(getClass().getResource("Summoned SkullBig.png"));
		ImageIcon WittyPhantom = new ImageIcon(getClass().getResource("Witty PhantomBig.jpg"));
		ImageIcon FenceGuard = new ImageIcon(getClass().getResource("Fence GuardBig.jpeg"));
		ImageIcon FenceGuardMagician = new ImageIcon(getClass().getResource("fenceguardMagicianBig.jpeg"));
		ImageIcon FenceGuardDragon = new ImageIcon(getClass().getResource("Fence Guard DragonBig.png"));
		ImageIcon FenceGuardApprentice = new ImageIcon(getClass().getResource("Fence Guard ApprenticeBig.png"));
		ImageIcon TimeWizard = new ImageIcon(getClass().getResource("Time WizardBig.png"));

		
		ImageIcon CardDestruction = new ImageIcon(getClass().getResource("Card DestructionBig.jpg"));
		ImageIcon ChangeofHeart = new ImageIcon(getClass().getResource("Change Of HeartBig.png"));
		ImageIcon DarkHole = new ImageIcon(getClass().getResource("Dark HoleBig.jpg"));
		ImageIcon GracefulDice = new ImageIcon(getClass().getResource("Graceful DiceBig.png"));
		ImageIcon HarpieFeather = new ImageIcon(getClass().getResource("Harpie's Feather DusterBig.png"));
		ImageIcon HeavyStorm = new ImageIcon(getClass().getResource("Heavy StormBig.jpg"));
		ImageIcon MagePower = new ImageIcon(getClass().getResource("Mage PowerBig.png"));
		ImageIcon MonsterReborn = new ImageIcon(getClass().getResource("Monster RebornBig.png"));
		ImageIcon PotOfGreed = new ImageIcon(getClass().getResource("Pot of GreedBig.png"));
		ImageIcon Raigeki = new ImageIcon(getClass().getResource("RaigekiBig.png"));
		
		
		
		ImageIcon CardDestructionS = new ImageIcon(getClass().getResource("Card Destruction.jpg"));
		ImageIcon ChangeofHeartS = new ImageIcon(getClass().getResource("Change Of Heart.jpg"));
		ImageIcon DarkHoleS = new ImageIcon(getClass().getResource("Dark Hole.jpg"));
		ImageIcon GracefulDiceS = new ImageIcon(getClass().getResource("Graceful Dice.png"));
		ImageIcon HarpieFeatherS = new ImageIcon(getClass().getResource("Harpie's Feather Duster.png"));
		ImageIcon HeavyStormS = new ImageIcon(getClass().getResource("Heavy Storm.png"));
		ImageIcon MegaPowerS = new ImageIcon(getClass().getResource("Mage Power.png"));
		ImageIcon MonsterRebornS = new ImageIcon(getClass().getResource("Monster Reborn.jpg"));
		ImageIcon PotOfGreedS = new ImageIcon(getClass().getResource("Pot of Greed.jpg"));
		ImageIcon RaigekiS = new ImageIcon(getClass().getResource("Raigeki.jpg"));
		ImageIcon BackBig = new ImageIcon(getClass().getResource("BackBig.jpg"));
		JLabel background;
		private JLabel TheInfoBig;

		public String getP1Name() {
			return p1Name;
		}

		public void setP1Name(String p1Name) {
			this.p1Name = p1Name;
		}

		public String getP2Name() {
			return p2Name;
		}

		public void setP2Name(String p2Name) {
			this.p2Name = p2Name;
		}

		public JLabel getActiveNumber() {
			return activeNumber;
		}

		public void setActiveNumber(String lifePoints) {
			this.activeNumber.setText(lifePoints);;
		}

		public JLabel getOpponentNumber() {
			return opponentNumber;
		}

		public void setOpponentNumber(String lifePoints) {
			this.opponentNumber.setText(lifePoints);
		}
		private JLabel opponentNumber;
	public GraveyardButton getGraveyardActive() {
			return graveyardActive;
		}

		public void setGraveyardActive(GraveyardButton graveyardActive) {
			this.graveyardActive = graveyardActive;
		}

		public JLabel getActiveLifePoints() {
			return activeLifePoints;
		}

		public void setActiveLifePoints(JLabel activeLifePoints) {
			this.activeLifePoints = activeLifePoints;
		}

		public JLabel getOpponentLifePoints() {
			return opponentLifePoints;
		}

		public void setOpponentLifePoints(JLabel opponentLifePoints) {
			this.opponentLifePoints = opponentLifePoints;
		}

		public DeckButton getDeckActive() {
			return DeckActive;
		}

		public void setDeckActive(DeckButton deckActive) {
			DeckActive = deckActive;
		}

		public DeckButton getDeckOpponent() {
			return DeckOpponent;
		}

		public void setDeckOpponent(DeckButton deckOpponent) {
			DeckOpponent = deckOpponent;
		}

		public GraveyardButton getGrraveyardActive() {
			return graveyardActive;
		}

		public void setGrraveyardActive(ImageIcon i) {
			this.graveyardActive.setIcon(i);
		}

		public GraveyardButton getGraveyardOpponent() {
			return graveyardOpponent;
		}

		public void setGraveyardOpponent(ImageIcon i) {
			this.graveyardOpponent.setIcon(i);
		}

		public void setCurrentPhase(JLabel currentPhase) {
			this.currentPhase = currentPhase;
		}
		ActivateClick activateSpell;
		AttackDirectlyClick attackDirect;
		AttackMonsterClick attackMonster;
		SetClick setMonster;
		SetSpellClick setSpell;
		SummonClick summon;
		SwitchModeClick switchMode;
		ActivateFromField activateFromField;
	public GUI(String first,String second){
		//("videoplayback.wma");
		super();
		
		activateSpell = new ActivateClick();
		attackDirect = new AttackDirectlyClick();
		attackMonster = new AttackMonsterClick();
		setMonster = new SetClick();
		setSpell = new SetSpellClick();
		summon = new SummonClick();
		activateFromField = new ActivateFromField();
		switchMode = new SwitchModeClick();
		activateFromField.setLocation(245,340);
		activateFromField.setSize(194, 40);
		activateSpell.setLocation(100, 340);
		setSpell.setLocation(420,340);
		attackDirect.setLocation(245, 340);
		attackMonster.setLocation(245, 340);
		switchMode.setLocation(245,340);
		summon.setLocation(90, 340);
		setMonster.setLocation(420,340);
		summon.setSize(194,40);
		setSpell.setSize(194,40);
		activateSpell.setSize(194,40);
		switchMode.setSize(194,40);
		attackDirect.setSize(194,40);
		attackMonster.setSize(194,40);
		setMonster.setSize(194,40);
		
		
		
		

		
		//Audio = JApplet.newAudioClip(getClass().getResource("videoplayback.wav"));
		setTitle("YU GI OH");	
		background = new JLabel(new ImageIcon((getClass().getResource("TheField.jpg"))));
		p1Name = first;
		p2Name = second;
		setSize(1000,750);

		
		//setCursor (Cursor.getPredefinedCursor(Cursor.getSystemCustomCursor(name)));
		p1Name=first;
		p2Name=second;
		//this.setAudio(Audio);
		//Audio.loop();
		//Audio.play
		//GameplayAudio.play();
		//GameplayAudio.loop();
	//	GameplayAudio.loop();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		//JLabel background2=new JLabel(new ImageIcon(getClass().getResource("FIELD Active.jpg")));
		add(background);
		//setContentPane(new JLabel(new ImageIcon("yu_gi_oh_wallpaper_by_corki_gfx-d60vjn0.png")));

		JLabel player1 = new JLabel("Player 1 : "+first);
		player1.setFont(new Font("Papyrus",Font.BOLD,20));
		player1.setForeground(Color.LIGHT_GRAY);
		JLabel player2 = new JLabel("Player 2 : "+second);
		player2.setFont(new Font("Papyrus",Font.BOLD,20));
		player2.setForeground(Color.LIGHT_GRAY);
		player1.setSize(200,30);
		player2.setSize(200,30);
		activeLifePoints = new JLabel("Life Points");
		activeLifePoints.setFont(new Font("Papyrus", Font.BOLD, 30));
		activeLifePoints.setForeground(Color.LIGHT_GRAY);
		opponentLifePoints = new JLabel("Life Points");
		opponentLifePoints.setFont(new Font("Papyrus", Font.BOLD, 30));
		opponentLifePoints.setForeground(Color.LIGHT_GRAY);
		activeNumber = new JLabel("8000");
		activeNumber.setFont(new Font("Papyrus", Font.BOLD, 40));
		activeNumber.setForeground(Color.LIGHT_GRAY);
		opponentNumber = new JLabel("8000");
		opponentNumber.setFont(new Font("Papyrus", Font.BOLD, 40));
		opponentNumber.setForeground(Color.LIGHT_GRAY);
		background.setLayout(null);		
		currentPhase = new JLabel("Main 1");
		currentPhase.setFont(new Font("Papyrus", Font.BOLD, 40));
		currentPhase.setForeground(Color.LIGHT_GRAY);
		endPhase = new EndPhaseButton();
		endTurn = new EndTurnButton();
		graveyardActive = new GraveyardButton();
		graveyardOpponent = new GraveyardButton();
		ac = new PlayerPanel(first);
		op = new PlayerPanel(second);
		graveyardActive.setSize(66, 90);
		graveyardOpponent.setSize(66, 90);
		op.getSpellsAndMonstersPanel().setName(p2Name);
		ac.getSpellsAndMonstersPanel().setName(p1Name);
		op.remove(op.getSpellsAndMonstersPanel());
		op.remove(op.getHandPanel());
		op.add(op.getSpellsAndMonstersPanel(),BorderLayout.SOUTH);
		op.add(op.getHandPanel(),BorderLayout.NORTH);
		op.getSpellsAndMonstersPanel().remove(op.getSpellsAndMonstersPanel().getMonstersPanel());
		op.getSpellsAndMonstersPanel().remove(op.getSpellsAndMonstersPanel().getSpellsPanel());
		op.getSpellsAndMonstersPanel().add(op.getSpellsAndMonstersPanel().getSpellsPanel());
		op.getSpellsAndMonstersPanel().add(op.getSpellsAndMonstersPanel().getMonstersPanel());
		background.add(ac);
		background.add(op);
		background.add(activeLifePoints);
		background.add(opponentLifePoints);
		background.add(activeNumber);
		background.add(opponentNumber);
		ac.setSize(468,300);
		op.setSize(468,300);
		activeLifePoints.setSize(160, 40);
		activeLifePoints.setLocation(810, 670);
		activeNumber.setSize(160, 40);
		activeNumber.setLocation(830, 630);
		opponentLifePoints.setSize(160, 40);
		opponentLifePoints.setLocation(800, 0);
		opponentNumber.setSize(160, 40);
		opponentNumber.setLocation(820, 40);
		op.setLocation(92, -18);
		ac.setLocation(92,423);
		currentPhase.setLocation(243, 340);
		currentPhase.setSize(1000,40);
		
		player1.setLocation(230, 390);
		player2.setLocation(230, 290);

		endPhase.setSize(66,92);
		endPhase.setLocation(20,53);
		endTurn.setSize(66,92);
		endTurn.setLocation(20,148);
		background.add(endTurn);    
		background.add(endPhase); 
		graveyardActive.setLocation(548,372);
		graveyardOpponent.setLocation(20, 244);
		background.add(currentPhase); 
		background.add(graveyardActive);
		background.add(graveyardOpponent);
		background.add(activateFromField);
		background.add(setSpell);
		background.add(setMonster);
		background.add(activateSpell);
		background.add(summon);
		background.add(switchMode);
		background.add(attackDirect);
		background.add(attackMonster);
		background.add(player1);
		background.add(player2);
		setSpell.setVisible(false);
		activateSpell.setVisible(false);
		summon.setVisible(false);
		switchMode.setVisible(false);
		setMonster.setVisible(false);
		attackDirect.setVisible(false);
		attackMonster.setVisible(false);
		activateFromField.setVisible(false);
		TheInfoBig = new JLabel(BackBig);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);
		JLabel activeDeck = ac.getDeckLabel();
		JLabel opponentDeck = op.getDeckLabel();
		activeDeck.setSize(33, 33);
		opponentDeck.setSize(33, 33);
		activeDeck.setLocation(45, 595);
		opponentDeck.setLocation(571,84);
		background.add(activeDeck);
		background.add(opponentDeck);
		setSize(999,749);
		setSize(1000,750);
		background.validate();
		this.setResizable(false);
	}
	public AttackDirectlyClick getAttackDirect() {
		return attackDirect;
	}

	public ActivateFromField getActivateFromField() {
		return activateFromField;
	}

	public void setActivateFromField(ActivateFromField activateFromField) {
		this.activateFromField = activateFromField;
	}

	public void setAttackDirect(AttackDirectlyClick attackDirect) {
		this.attackDirect = attackDirect;
	}

	public AttackMonsterClick getAttackMonster() {
		return attackMonster;
	}

	public void setAttackMonster(AttackMonsterClick attackMonster) {
		this.attackMonster = attackMonster;
	}

	public ActivateClick getActivateSpell() {
		return activateSpell;
	}

	public void setActivateSpell(ActivateClick activateSpell) {
		this.activateSpell = activateSpell;
	}

	public SetClick getSetMonster() {
		return setMonster;
	}

	public void setSetMonster(SetClick setMonster) {
		this.setMonster = setMonster;
	}

	public SetSpellClick getSetSpell() {
		return setSpell;
	}

	public void setSetSpell(SetSpellClick setSpell) {
		this.setSpell = setSpell;
	}

	public SummonClick getSummon() {
		return summon;
	}

	public void setSummon(SummonClick summon) {
		this.summon = summon;
	}

	public SwitchModeClick getSwitchMode() {
		return switchMode;
	}

	public void setSwitchMode(SwitchModeClick switchMode) {
		this.switchMode = switchMode;
	}

	public JLabel getbackground() {
		return background;
	}

	public void setBackground(JLabel background) {
		this.background = background;
	}

	public JLabel getTheInfoBig() {
		return TheInfoBig;
	}

	public void activateTheSpellFromHand(HandButton a1,SpellCard c,Player active){
		ImageIcon iTraversing = (ImageIcon)a1.getIcon();
		SpellButton spell = new SpellButton(iTraversing);
		this.getAc().getSpellsAndMonstersPanel().getSpellsPanel().add(spell);
		RemoveSpellAfterSecond s = new RemoveSpellAfterSecond(spell,this,active);
		Thread t = new Thread(s);
		t.start();
		
		//Point p2 = new Point();
		//p2.x = 548;
		//p2.y = 372;
		//System.out.println(p.getX()+"   "+p.getY()+"   graveyard");
		//System.out.println(p2.getX()+"   "+p2.getY()+"   graveyard");

		//TraverseToLocation traverse = new TraverseToLocation(this,iTraversing,p,p2);
		///Thread t1 = new Thread(traverse);
		//t1.start();
		a1.setVisible(false);
		this.getAc().getHandPanel().getHandPanel().remove(a1);
		this.getAc().getHandPanel().getBackCards().remove(0);
		this.getAc().getHandPanel().getHandButtons().remove(a1);
	}
	public void activateTheSpellFromField(SpellButton a1,SpellCard c,Player active){
		ImageIcon iTraversing = DarkHole;
		switch(c.getName()){
		case "Dark Hole" :iTraversing=DarkHoleS;break;
		case "Graceful Dice" :iTraversing=GracefulDiceS;break;
		case "Heavy Storm" :iTraversing=(HeavyStormS);break;
		case "Mage Power" :iTraversing=(MegaPowerS);break;
		case "Monster Reborn" :iTraversing=(MonsterRebornS);break;
		case "Pot of Greed" :iTraversing=(PotOfGreedS);break;
		case "Harpie's Feather Duster" :iTraversing=(HarpieFeatherS);break;
		case "Raigeki" :iTraversing=(RaigekiS);break;
		case "Card Destruction" : iTraversing=(CardDestructionS);break;
		case "Change Of Heart" : iTraversing=(ChangeofHeartS);break;
		}
		SpellButton spell = new SpellButton(iTraversing);
		this.getAc().getSpellsAndMonstersPanel().getSpellsPanel().add(spell);
		RemoveSpellAfterSecond s = new RemoveSpellAfterSecond(spell,this,active);
		Thread t = new Thread(s);
		t.start();
		
		//Point p2 = new Point();
		//p2.x = 548;
		//p2.y = 372;
		//System.out.println(p.getX()+"   "+p.getY()+"   graveyard");
		//System.out.println(p2.getX()+"   "+p2.getY()+"   graveyard");

		//TraverseToLocation traverse = new TraverseToLocation(this,iTraversing,p,p2);
		///Thread t1 = new Thread(traverse);
		//t1.start();
		a1.setVisible(false);
		this.getAc().getSpellsAndMonstersPanel().getSpellsPanel().remove(a1);
		this.getAc().getSpellsAndMonstersPanel().getSpellButtons().remove(a1);
	}
	
	public void run(DisplayMode dm){
		Screen s = new Screen();
		try{
		s.setFullScreen(dm,this);
		
		try{
			Thread.sleep(5000);
		}catch(Exception e){	
		}
		}
		catch(Exception e){		
		}
		finally{
			s.restoreScreen();
		}
		
	}
	
	public void setTheInfoBig(Card c) {
		background.remove(TheInfoBig);

		switch (c.getName()){
		case "Blue-Eyes White Dragon" : TheInfoBig = new JLabel((BlueEyesWhiteDragon));
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Cosmo Queen" :TheInfoBig = new JLabel((CosmoQueen));
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Dark Magician" :
		TheInfoBig = new JLabel((DarkMagician));
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Red-Eyes Black Dragon" : TheInfoBig = new JLabel(RedEyesBlackDragon);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		//case "Gaia The Fierce Knight" : m=new MonsterButton(GaiaTheFierceKnight);
		case "Summoned Skull" :TheInfoBig = new JLabel(SummonedSkull);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		//case "Fence Guard Magician" : m=new MonsterButton(FenceGuardMagician);
		case "Dark Magician Girl" :TheInfoBig = new JLabel(DarkMagicianGirl);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Curse Of Dragon" : TheInfoBig = new JLabel(CurseOfDragon);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		//case "Fence Guard Dragon" : m=new MonsterButton(FenceGuardDragon);
		case "Alexandrite Dragon" :  TheInfoBig = new JLabel(AlexandriteDragon);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Vorse Raider" :TheInfoBig = new JLabel((VorseRaider));
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Gemini Elf" :TheInfoBig = new JLabel(GeminiElf);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		//case "Fence Guard Apprentice" : m=new MonsterButton(FenceGuardApprentice);
		case "Beta The Magnet Warrior" :TheInfoBig = new JLabel(BetaTheMagnetWarrior);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Alligator Sword" :TheInfoBig = new JLabel((AlligatorSword));
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Gaia The Fierce Knight" :TheInfoBig = new JLabel((GiaTheFierceKnight));
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Gamma The Magnet Warrior" : TheInfoBig = new JLabel(GammaTheMagnetWarrior);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Celtic Guardian" :TheInfoBig = new JLabel(CelticGuardian);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Alpha The Magnet Warrior" : TheInfoBig = new JLabel(AlphaTheMagnetWarrior);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Harpie Lady" :TheInfoBig = new JLabel(HarpieLady);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Big Shield Gardna" :TheInfoBig = new JLabel(BigShieldGardna);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Witty Phantom" :TheInfoBig = new JLabel(WittyPhantom);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Baby Dragon" : TheInfoBig = new JLabel(BabyDragon);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Cyber Jar" :TheInfoBig = new JLabel(CyberJar);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Clown Zombie" :TheInfoBig = new JLabel(ClownZombie);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Time Wizard" :TheInfoBig = new JLabel(TimeWizard);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Man-Eater Bug" :TheInfoBig = new JLabel(ManEaterBug);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Kuriboh" :TheInfoBig = new JLabel(Kuriboh);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Mokey Mokey" :TheInfoBig = new JLabel(MokeyMokey);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Dark Hole" :TheInfoBig = new JLabel(DarkHole);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Graceful Dice" :TheInfoBig = new JLabel(GracefulDice);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Heavy Storm" :TheInfoBig = new JLabel(HeavyStorm);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Mage Power" :TheInfoBig = new JLabel(MagePower);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Monster Reborn" :TheInfoBig = new JLabel(MonsterReborn);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Pot of Greed" :TheInfoBig = new JLabel(PotOfGreed);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Harpie's Feather Duster" :TheInfoBig = new JLabel(HarpieFeather);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Raigeki" :TheInfoBig = new JLabel((Raigeki));
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Card Destruction" :TheInfoBig = new JLabel(CardDestruction);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Fence Guard" :TheInfoBig = new JLabel(FenceGuard);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Fence Guard Magician" :TheInfoBig = new JLabel(FenceGuardMagician);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Fence Guard Dragon" :TheInfoBig = new JLabel(FenceGuardDragon);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Fence Guard Apprentice" :TheInfoBig = new JLabel(FenceGuardApprentice);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		case "Change Of Heart" :TheInfoBig = new JLabel(ChangeofHeart);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);break;
		
		}
		TheInfoBig.repaint();
		TheInfoBig.validate();
	
	}
	public void resetTheInfoBig(){
		background.remove(TheInfoBig);
		TheInfoBig = new JLabel(BackBig);
		TheInfoBig.setSize(350, 510);
		TheInfoBig.setLocation(650,100);
		background.add(TheInfoBig);
		TheInfoBig.setSize(349, 507);
		TheInfoBig.setSize(350, 508);;
	}
	

	
	public JLabel getCurrentPhase() {
		return currentPhase;
	}
	public void setCurrentPhase(String x) {
		this.currentPhase.setText(x);
	}
	
	public EndPhaseButton getEndPhase() {
		return endPhase;
	}
	public void setEndPhase(EndPhaseButton endPhase) {
		this.endPhase = endPhase;
	}
	public EndTurnButton getEndTurn() {
		return endTurn;
	}
	public void setEndTurn(EndTurnButton endTurn) {
		this.endTurn = endTurn;
	}
	public PlayerPanel getAc() {
		return ac;
	}
	public void setAc(PlayerPanel ac) {
		this.ac = ac;
	}
	public PlayerPanel getOp() {
		return op;
	}
	public void setOp(PlayerPanel op) {
		this.op = op;
	}
}
