package eg.edu.guc.yugioh.listeners;

//import java.awt.BorderLayout;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.GridLayout;
//import java.awt.Color;
//import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.UIManager;













import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
//import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.DefenseMonsterAttackException;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
//import eg.edu.guc.yugioh.exceptions.MonsterMultipleAttackException;
import eg.edu.guc.yugioh.exceptions.MultipleMonsterAdditionException;
import eg.edu.guc.yugioh.exceptions.NoMonsterSpaceException;
import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
//import eg.edu.guc.yugioh.exceptions.NoSpaceException;
//import eg.edu.guc.yugioh.exceptions.NoSpellSpaceException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;
import eg.edu.guc.yugioh.exceptions.WrongPhaseException;
import eg.edu.guc.yugioh.gui.ActivateClick;
import eg.edu.guc.yugioh.gui.ActivateFromField;
import eg.edu.guc.yugioh.gui.AttackDirectlyClick;
import eg.edu.guc.yugioh.gui.AttackMonsterClick;
//import eg.edu.guc.yugioh.gui.DeckButton;
import eg.edu.guc.yugioh.gui.EndPhaseButton;
import eg.edu.guc.yugioh.gui.EndTurnButton;
import eg.edu.guc.yugioh.gui.GUI;
import eg.edu.guc.yugioh.gui.GraveyardButton;
import eg.edu.guc.yugioh.gui.HandButton;
import eg.edu.guc.yugioh.gui.HandPanel;
import eg.edu.guc.yugioh.gui.MonsterButton;
//import eg.edu.guc.yugioh.gui.OverlapLayout;
import eg.edu.guc.yugioh.gui.PlayerPanel;
import eg.edu.guc.yugioh.gui.SetClick;
import eg.edu.guc.yugioh.gui.SetSpellClick;
import eg.edu.guc.yugioh.gui.SpellButton;
import eg.edu.guc.yugioh.gui.SpellsAndMonstersPanel;
import eg.edu.guc.yugioh.gui.SummonClick;
import eg.edu.guc.yugioh.gui.SwitchModeClick;

public class Controller implements ActionListener,MouseListener  {
	GUI gui;
	Board board;
	Player active;
	Player opponent;
	getNames names;
	boolean sacrificing = false;
	private MonsterCard sacrifices1;
	private MonsterButton sacrifices1But;
	private MonsterCard sacrifices2;
	private MonsterButton sacrifices2But;
	private MonsterCard toBeSummonedSacr;
	private Boolean MagePower=false;
	private HandButton MagePowerButton;
	private SpellButton MagePowerButtonField;
	private SpellCard MagePowerCard;
	//private MonsterButton toBeSummonedBut;
	
	private MonsterButton tempMonster;
	private SpellButton tempSpell;
	private HandButton tempHand;

	
	
	
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
	//ImageIcon test = new ImageIcon(getClass().getResource("test.jpg"));
//	ImageIcon Download = new ImageIcon(getClass().getResource("download.png"));

	
//	AudioClip lifePointsAudio =JApplet.newAudioClip(getClass().getResource("videoplayback_1_.wav"));
//	AudioClip GameplayAudio =JApplet.newAudioClip(getClass().getResource("videoplayback_2_.wav"));
//	AudioClip summonAudio =JApplet.newAudioClip(getClass().getResource("videoplayback_3_.wav"));


	private MonsterCard attackingMonster;
	private MonsterButton attackingMonsterButton;
	private boolean attacking;
	private int summoningORsetting;
	private boolean changingTheHeart = false;
	private SpellCard changingHeart;
	private HandButton TheHandButtonForChangingOfHeart;
	private SpellButton TheFieldButtonForChangingOfHeart;
	public Controller(String p1n,String p2n) throws NumberFormatException, MissingFieldException, EmptyFieldException, UnknownSpellCardException, UnknownCardTypeException, CloneNotSupportedException, IOException{
	//	names = new getNames();
		
		
		//DisplayMode dm = new DisplayMode(800,600,32,DisplayMode.REFRESH_RATE_UNKNOWN);
		
		
		
		
		attacking = false;
		board = new Board();
		Player p1 = new Player(p1n);
		Player p2 = new Player(p2n);
		board.startGame(p1, p2);
		active = board.getActivePlayer();
		opponent = board.getOpponentPlayer();
		gui = new GUI(active.getName(),opponent.getName());
		setActionListeners();
		fillHands();
//		UIManager UI=new UIManager();
//		 UI.put("OptionPane.background", Color.red);
//		 UI.put("Panel.background", Color.red);
		//gui.run(dm);
		gui.getGraveyardActive().addMouseListener(this);
		gui.getGraveyardOpponent().addMouseListener(this);
		gui.getGraveyardOpponent().addActionListener(this);
		gui.getGraveyardActive().addActionListener(this);
		gui.getOp().getHandPanel().getBackCards().setVisible(true);
		gui.getOp().getHandPanel().getHandPanel().setVisible(false);

		gui.getAc().getDeckLabel().setText(active.getField().getDeck().getDeck().size()+"");
		gui.getOp().getDeckLabel().setText(opponent.getField().getDeck().getDeck().size()+"");
	}

	public void fillHands(){
		PlayerPanel activeG = gui.getAc();
		PlayerPanel opponentG = gui.getOp();

		gui.getActivateSpell().addActionListener(this);
		gui.getSetSpell().addActionListener(this);
		gui.getSetMonster().addActionListener(this);
		gui.getSummon().addActionListener(this);
		gui.getSwitchMode().addActionListener(this);
		gui.getAttackDirect().addActionListener(this);
		gui.getAttackMonster().addActionListener(this);
		HandPanel activeHand = activeG.getHandPanel();
		HandPanel opponentHand = opponentG.getHandPanel();

		ArrayList<Card> hand1 = active.getField().getHand();
		activeHand.setTheHand(hand1);
		ArrayList<Card> hand2 = opponent.getField().getHand();
		opponentHand.setTheHand(hand2);

		for (int i=0;i<6;i++) {
			HandButton handButton;
			if(hand1.get(i)instanceof MonsterCard){
				handButton = gui.getAc().getHandPanel().addTheButton(hand1.get(i));
				handButton.setName("Monster");
				handButton.setVisible(true);
			}else{
				handButton = gui.getAc().getHandPanel().addTheButton(hand1.get(i));
				handButton.setName("Spell");
				handButton.setVisible(true);
				}
			//acHand.add(handButton);
			//activeHand.addTheButton( hand1.get(i));
			handButton.addActionListener(this);
			handButton.addMouseListener(this);
			handButton.addMouseListener(gui.getAc().getHandPanel());
		}
		//gui.getAc().getHandPanel().setTheHand(hand1);
		for (int i=0;i<5;i++) {
			HandButton handButton;
			if(hand2.get(i)instanceof MonsterCard){
				handButton =gui.getOp().getHandPanel().addTheButton(hand2.get(i));

				handButton.setName("Monster");
				handButton.setVisible(true);

			}else{
				handButton = gui.getOp().getHandPanel().addTheButton(hand2.get(i));
				
				handButton.setName("Spell");
				handButton.setVisible(true);

			}
			//opHand.add(handButton);
			//	opponentHand.addDescription(handButton, hand2.get(i));
			handButton.addActionListener(this);
			handButton.addMouseListener(gui.getOp().getHandPanel());
			handButton.addMouseListener(this);
		}
		gui.getActivateFromField().addActionListener(this);
	}
	public void actionPerformed (ActionEvent a){
		try{
		
		gui.getAttackDirect().setVisible(false);
		gui.getAttackMonster().setVisible(false);
		gui.getActivateSpell().setVisible(false);
		gui.getSetSpell().setVisible(false);
		gui.getSetMonster().setVisible(false);
		gui.getSummon().setVisible(false);
		gui.getSwitchMode().setVisible(false);
		gui.getActivateFromField().setVisible(false);
		gui.getCurrentPhase().setVisible(true);

		if(a.getSource() instanceof ActivateFromField){
			SpellButton a1 = tempSpell;
			gui.getCurrentPhase().setVisible(true);
			int index = gui.getAc().getSpellsAndMonstersPanel().getSpellButtons().indexOf(a1);
			SpellCard c =(SpellCard) active.getField().getSpellArea().get(index);
			try{
				
				switch(c.getName()){
				case "Card Destruction" :
					active.activateSpell(c, null);
					
					ArrayList<HandButton> hand =gui.getAc().getHandPanel().getHandButtons();
					ArrayList<HandButton> hand2 =gui.getOp().getHandPanel().getHandButtons();
					
					int size = hand.size();
					int size2 = hand2.size();

					//System.out.println(size+" "+size2);
					for(int j=0;j<size;j++){
						gui.getAc().getHandPanel().getHandPanel().remove(hand.get(0));
						hand.remove(0).setVisible(false);
					}
					for(int j=0;j<size2;j++){
						gui.getOp().getHandPanel().getHandPanel().remove(hand2.get(0));
						hand2.remove(0).setVisible(false);
					}
					gui.activateTheSpellFromField(a1,c,active);
					String[] options = {"Play again","exit"};
					if(board.getWinner()!=null){
						int k = JOptionPane.showOptionDialog(null, board.getWinner().getName()+" Won this game","Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
						if(k==0){
							try {
								new InputInterface();
								gui.dispose();
								return;
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						}
						gui.dispose();
						return;
					}
					
				//System.out.println(active.getField().getHand().size()+" "+opponent.getField().getHand().size());
					gui.getAc().getHandPanel().getBackCards().removeAll();
					for(int j=0;j<size;j++){
						HandButton handButton;
						if(active.getField().getHand().get(j)instanceof MonsterCard){
							handButton = gui.getAc().getHandPanel().addTheButton(active.getField().getHand().get(j));
							handButton.setName("Monster");
							handButton.setVisible(true);
						}else{
							handButton = gui.getAc().getHandPanel().addTheButton(active.getField().getHand().get(j));
							handButton.setName("Spell");
							handButton.setVisible(true);
							}
						handButton.addActionListener(this);
						handButton.addMouseListener(this);
						handButton.addMouseListener(gui.getAc().getHandPanel());
					}
					gui.getOp().getHandPanel().getBackCards().removeAll();
					for(int j=0;j<size2;j++){
						HandButton handButton;
						if(opponent.getField().getHand().get(j)instanceof MonsterCard){
							handButton =gui.getOp().getHandPanel().addTheButton(opponent.getField().getHand().get(j));
							handButton.setName("Monster");
							handButton.setVisible(true);

						}else{
							handButton = gui.getOp().getHandPanel().addTheButton(opponent.getField().getHand().get(j));
							handButton.setName("Spell");
							handButton.setVisible(true);
						}
						handButton.addActionListener(this);
						handButton.addMouseListener(gui.getOp().getHandPanel());
						handButton.addMouseListener(this);
					}
					ShowMessageThread cd7 = new ShowMessageThread(gui,"Drawing new cards for both players",active);
					Thread d6= new Thread(cd7);
					d6.start();
					break;
				case "Change Of Heart" :
					if(opponent.getField().getMonstersArea().size()==0){
						ShowMessageThread c13 = new ShowMessageThread(gui,"can be activated only if your opponent controls monsters",active);
						Thread d234= new Thread(c13);
						d234.start();
					}else{
						changingTheHeart=true;
						changingHeart = c;
						TheFieldButtonForChangingOfHeart = a1;
						ShowMessageThread cd2 = new ShowMessageThread(gui,"Please choose a monster to control",active);
						Thread d2= new Thread(cd2);
						d2.start();
					}
					break;
				case "Dark Hole":
					active.activateSpell(c, null);
					ShowMessageThread cd1210 = new ShowMessageThread(gui,"All the monsters on the field destroyed",active);
					Thread d75= new Thread(cd1210);
					d75.start();
					gui.getAc().getSpellsAndMonstersPanel().getMonstersPanel().removeAll();
					gui.getOp().getSpellsAndMonstersPanel().getMonstersPanel().removeAll();
					while(gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().size()>0){
						gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().get(0).setVisible(false);
						gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().remove(0);
					}
					while(gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().size()>0){
						gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().get(0).setVisible(false);
						gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().remove(0);
					}
					gui.activateTheSpellFromField(a1,c,active);

					break;
				case "Graceful Dice":
					active.activateSpell(c, null);
					GracefulDiceThread g = new GracefulDiceThread(gui,active.getField().getExtraPoints());
					for(int i=0;i<gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().size();i++){
						MonsterButton c1 =gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().get(i);
						JLabel plus = new JLabel("    +");
						plus.setFont(new Font("Papyrus",Font.BOLD,40));
						JLabel GracefulPoints = new JLabel("   "+(active.getField().getExtraPoints())+"");
						GracefulPoints.setFont(new Font("Papyrus",Font.BOLD,25));
						c1.setLayout(new GridLayout(2,1));
						c1.add(plus);
						c1.add(GracefulPoints);
					}
					Thread d5554 = new Thread(g);
					d5554.start();
					gui.activateTheSpellFromField(a1,c,active);
					break;
				case "Harpie's Feather Duster" : 
					active.activateSpell(c, null);
					ShowMessageThread ameen = new ShowMessageThread(gui,"Opponent's spells have been destroyed",active);
					Thread d901 = new Thread(ameen);
					d901.start();
					gui.getOp().getSpellsAndMonstersPanel().getSpellsPanel().removeAll();
					while(gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().size()>0){
						gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().get(0).setVisible(false);
						gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().remove(0);
					}
					gui.activateTheSpellFromField(a1,c,active);
					break;
				case "Heavy Storm" :
					active.activateSpell(c, null);
				//	gui.activateTheSpellFromHand(a1,c,active);
					ShowMessageThread ameen1 = new ShowMessageThread(gui,"All spells have been destroyed",active);
					Thread d900 = new Thread(ameen1);
					d900.start();
					gui.getOp().getSpellsAndMonstersPanel().getSpellsPanel().removeAll();
					gui.getAc().getSpellsAndMonstersPanel().getSpellsPanel().removeAll();
					while(gui.getAc().getSpellsAndMonstersPanel().getSpellButtons().size()>0){
						gui.getAc().getSpellsAndMonstersPanel().getSpellButtons().get(0).setVisible(false);
						gui.getAc().getSpellsAndMonstersPanel().getSpellButtons().remove(0);
					}
					while(gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().size()>0){
						gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().get(0).setVisible(false);
						gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().remove(0);
					}
					gui.activateTheSpellFromField(a1,c,active);

					break;
				case "Mage Power" :
					if(active.getField().getMonstersArea().size()==0){
						ShowMessageThread ameen3 = new ShowMessageThread(gui,"You have no monsters to activate on",active);
						Thread d909 = new Thread(ameen3);
						d909.start();
					}else{
					ShowMessageThread ameen3 = new ShowMessageThread(gui,"Please choose a monster to activate on",active);
					Thread d909 = new Thread(ameen3);
					d909.start();
					MagePower = true;
					MagePowerCard = c;
					MagePowerButtonField = a1;
					}
					break;
				case "Monster Reborn" :
					if(active.getField().getGraveyard().size()>0||opponent.getField().getGraveyard().size()>0){
						active.activateSpell(c, null);
						MonsterCard m = active.getField().getMonstersArea().get(active.getField().getMonstersArea().size()-1);
						String options1[] = {"Attack","Defense"};
						int i = JOptionPane.showOptionDialog(null, "In which mode do you want ?","Monster Reborn",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options1,options1[0]);
						MonsterButton x;
						if(i==0){
							m.setMode(Mode.ATTACK);
							x = gui.getAc().getSpellsAndMonstersPanel().summon(m);
							ShowMessageThread ameen3 = new ShowMessageThread(gui,"You have summoned "+m.getName(),active);
							Thread d909 = new Thread(ameen3);
							d909.start();
							x.addActionListener(this);
							x.addMouseListener(this);
						}else{
							if(i==1){
								m.setMode(Mode.DEFENSE);
								ShowMessageThread ameen3 = new ShowMessageThread(gui,"You have set "+m.getName(),active);
								Thread d909 = new Thread(ameen3);
								d909.start();
								x = gui.getAc().getSpellsAndMonstersPanel().set(m, gui);
								x.addActionListener(this);
								x.addMouseListener(this);
							}
						}

						}else{
							ShowMessageThread ameen3 = new ShowMessageThread(gui,"No monsters in both graveyards",active);
							Thread d909 = new Thread(ameen3);
							d909.start();
						}
						break;
				case "Pot of Greed" :
					HandButton handButton;
					active.activateSpell(c, null);
					String[] options1 = {"Play again","exit"};
					if(board.getWinner()!=null){
						int k = JOptionPane.showOptionDialog(null, board.getWinner().getName()+" Won this game","Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options1,options1[0]);
						gui.dispose();
						if(k==0){
							try {
								new InputInterface();
								return;
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						}
						return;
					}
					ShowMessageThread ameen3 = new ShowMessageThread(gui,"2 extra cards to your hand",active);
					Thread d909 = new Thread(ameen3);
					d909.start();
					for(int j=active.getField().getHand().size()-2;j<active.getField().getHand().size();j++){
					if(active.getField().getHand().get(j)instanceof MonsterCard){
						handButton = gui.getAc().getHandPanel().addTheButton(active.getField().getHand().get(j));
						handButton.setName("Monster");
						handButton.setVisible(true);
					}else{
						handButton = gui.getAc().getHandPanel().addTheButton(active.getField().getHand().get(j));
						handButton.setName("Spell");
						handButton.setVisible(true);
					}
					handButton.addActionListener(this);
					handButton.addMouseListener(this);
					handButton.addMouseListener(gui.getAc().getHandPanel());
				}
					gui.activateTheSpellFromField(a1,c,active);
					break;
				case "Raigeki" :
					active.activateSpell(c, null);
					ShowMessageThread cd1211 = new ShowMessageThread(gui,"All the monsters on the field destroyed",active);
					Thread d755= new Thread(cd1211);
					d755.start();
					gui.getOp().getSpellsAndMonstersPanel().getMonstersPanel().removeAll();
				
					while(gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().size()>0){
						gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().get(0).setVisible(false);
						gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().remove(0);
					}
					gui.activateTheSpellFromField(a1,c,active);

					
					break;
				}

				
				}catch(WrongPhaseException e){
					ShowMessageThread cd1211 = new ShowMessageThread(gui,"Wrong Phase",active);
					Thread d755= new Thread(cd1211);
					d755.start();
			}

			
		}
		
		if(a.getSource() instanceof AttackDirectlyClick ){
			MonsterButton c = tempMonster;
			gui.getCurrentPhase().setVisible(true);
			gui.getAttackDirect().setVisible(false);
			if(opponent.getField().getMonstersArea().size()!=0){
				ShowMessageThread cd1 = new ShowMessageThread(gui,"There's monster in opponent's field",active);
				Thread d1= new Thread(cd1);
				d1.start();
				//JOptionPane.showMessageDialog(null,"You can't attack directly and there's monster/s in your opponent's field");
			}else{
				try{
					int index =  gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().indexOf(c);
					MonsterCard current = active.getField().getMonstersArea().get(index);
					if(active.declareAttack(current)){
						if(board.getOpponentPlayer().getLifePoints()<=0||board.getActivePlayer().getLifePoints()<=0){
						JOptionPane.showMessageDialog(null, "Game is over , "+board.getWinner().getName() +" won");	
						}
						
					}
				}catch(WrongPhaseException e){
					ShowMessageThread cd1 = new ShowMessageThread(gui,"You can attack only in the battle phase",active);
					Thread d1= new Thread(cd1);
					d1.start();
					//JOptionPane.showMessageDialog(null,"You can attack only in the battle phase");
				}catch(MonsterMultipleAttackException e1){
					ShowMessageThread cd1 = new ShowMessageThread(gui,"A monster can attack only one time per turn",active);
					Thread d1= new Thread(cd1);
					d1.start();
					//JOptionPane.showMessageDialog(null,"A monster can attack only one time per turn");
				}catch(DefenseMonsterAttackException e2){
					ShowMessageThread cd1 = new ShowMessageThread(gui,"A monster can not attack only in attack mode",active);
					Thread d1= new Thread(cd1);
					d1.start();
					//JOptionPane.showMessageDialog(null,"A monster can not attack only in defense");
				}
			}

		}
		if(a.getSource() instanceof AttackMonsterClick){
			MonsterButton c = tempMonster;
			gui.getCurrentPhase().setVisible(true);
			gui.getAttackMonster().setVisible(false);
			if(opponent.getField().getMonstersArea().size()==0){
				ShowMessageThread cd1 = new ShowMessageThread(gui,"No monsters in your opponent field",active);
				Thread d1= new Thread(cd1);
				d1.start();
			}else{
				ShowMessageThread cd1 = new ShowMessageThread(gui,"Please choose the monster to attack",active);
				Thread d1= new Thread(cd1);
				d1.start();
				attacking=true;
				attackingMonsterButton = c;
				int index3= gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().indexOf(c);
				attackingMonster = active.getField().getMonstersArea().get(index3);
			}
		}
		if(a.getSource() instanceof SwitchModeClick){
			MonsterButton c = tempMonster;
			gui.getCurrentPhase().setVisible(true);
			gui.getSwitchMode().setVisible(false);
			try{
				int index = gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().indexOf(c);
				if(active.switchMonsterMode(active.getField().getMonstersArea().get(index))){
				gui.getAc().getSpellsAndMonstersPanel().changeMode(c,active.getField().getMonstersArea().get(index),gui);
				}else{
					ShowMessageThread cd1 = new ShowMessageThread(gui,"You can't change mode twice",active);
					Thread d1= new Thread(cd1);
					d1.start();
				}
			}catch(WrongPhaseException e){
				ShowMessageThread cd1 = new ShowMessageThread(gui,"Wrong phase",active);
				Thread d1= new Thread(cd1);
				d1.start();
			}

		}
		if(a.getSource() instanceof ActivateClick){
			HandButton a1 = tempHand;
			gui.getActivateSpell().setVisible(false);
			gui.getSetSpell().setVisible(false);
			int index = gui.getAc().getHandPanel().getHandButtons().indexOf(a1);
			SpellCard c =(SpellCard) active.getField().getHand().get(index);
			try{
				
				switch(c.getName()){
				case "Card Destruction" :
					active.activateSpell(c, null);
					
					ArrayList<HandButton> hand =gui.getAc().getHandPanel().getHandButtons();
					ArrayList<HandButton> hand2 =gui.getOp().getHandPanel().getHandButtons();
					
					int size = hand.size();
					int size2 = hand2.size();

					for(int j=0;j<size;j++){
						gui.getAc().getHandPanel().getHandPanel().remove(hand.get(0));
						hand.remove(0).setVisible(false);
					}
					for(int j=0;j<size2;j++){
						gui.getOp().getHandPanel().getHandPanel().remove(hand2.get(0));
						hand2.remove(0).setVisible(false);
					}
					gui.activateTheSpellFromHand(a1,c,active);
					String[] options = {"Play again","exit"};
					if(board.getWinner()!=null){
						int k = JOptionPane.showOptionDialog(null, board.getWinner().getName()+" Won this game","Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
						gui.dispose();
						if(k==0){
							try {
								new InputInterface();
								return;
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						}
						return;
					}
					
					gui.getAc().getHandPanel().getBackCards().removeAll();
					for(int j=0;j<size-1;j++){
						HandButton handButton;
						if(active.getField().getHand().get(j)instanceof MonsterCard){
							handButton = gui.getAc().getHandPanel().addTheButton(active.getField().getHand().get(j));
							handButton.setName("Monster");
							handButton.setVisible(true);
						}else{
							handButton = gui.getAc().getHandPanel().addTheButton(active.getField().getHand().get(j));
							handButton.setName("Spell");
							handButton.setVisible(true);
							}
						handButton.addActionListener(this);
						handButton.addMouseListener(this);
						handButton.addMouseListener(gui.getAc().getHandPanel());
					}
					gui.getOp().getHandPanel().getBackCards().removeAll();
					for(int j=0;j<size2;j++){
						HandButton handButton;
						if(opponent.getField().getHand().get(j)instanceof MonsterCard){
							handButton =gui.getOp().getHandPanel().addTheButton(opponent.getField().getHand().get(j));
							handButton.setName("Monster");
							handButton.setVisible(true);

						}else{
							handButton = gui.getOp().getHandPanel().addTheButton(opponent.getField().getHand().get(j));
							handButton.setName("Spell");
							handButton.setVisible(true);

						}
						handButton.addActionListener(this);
						handButton.addMouseListener(gui.getOp().getHandPanel());
						handButton.addMouseListener(this);
					}
					ShowMessageThread cd7 = new ShowMessageThread(gui,"Drawing new cards for both players",active);
					Thread d6= new Thread(cd7);
					d6.start();
					break;
				case "Change Of Heart" :
					if(opponent.getField().getMonstersArea().size()==0){
						ShowMessageThread c13 = new ShowMessageThread(gui,"can be activated only if your opponent controls monsters",active);
						Thread d234= new Thread(c13);
						d234.start();
						//JOptionPane.showMessageDialog(null, "You can't activate this card and your opponent doesn't have any monsters in their field");
					}else{
						changingTheHeart=true;
						changingHeart = c;
						TheHandButtonForChangingOfHeart = a1;
						ShowMessageThread cd2 = new ShowMessageThread(gui,"Please choose a monster from your opponent's field to control",active);
						Thread d2= new Thread(cd2);
						d2.start();
					}
					break;
				case "Dark Hole":
					active.activateSpell(c, null);
					ShowMessageThread cd1210 = new ShowMessageThread(gui,"All the monsters on the field destroyed",active);
					Thread d75= new Thread(cd1210);
					d75.start();
					gui.getAc().getSpellsAndMonstersPanel().getMonstersPanel().removeAll();
					gui.getOp().getSpellsAndMonstersPanel().getMonstersPanel().removeAll();
					while(gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().size()>0){
						gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().get(0).setVisible(false);
						gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().remove(0);
					}
					while(gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().size()>0){
						gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().get(0).setVisible(false);
						gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().remove(0);
					}
					gui.activateTheSpellFromHand(a1,c,active);

					break;
				case "Graceful Dice":
					active.activateSpell(c, null);
					GracefulDiceThread g = new GracefulDiceThread(gui,active.getField().getExtraPoints());
					for(int i=0;i<gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().size();i++){
						MonsterButton c1 =gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().get(i);
						JLabel plus = new JLabel("    +");
						plus.setFont(new Font("Papyrus",Font.BOLD,30));
						JLabel GracefulPoints = new JLabel("       "+(active.getField().getExtraPoints())+"");
						GracefulPoints.setFont(new Font("Papyrus",Font.BOLD,15));
						c1.setLayout(new GridLayout(2,1));
						c1.add(plus);
						c1.add(GracefulPoints);
					}
					Thread d5554 = new Thread(g);
					d5554.start();
					gui.activateTheSpellFromHand(a1,c,active);
					break;
				case "Harpie's Feather Duster" : 
					active.activateSpell(c, null);
					ShowMessageThread ameen = new ShowMessageThread(gui,"Opponent's spells have been destroyed",active);
					Thread d901 = new Thread(ameen);
					d901.start();
					gui.getOp().getSpellsAndMonstersPanel().getSpellsPanel().removeAll();
					while(gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().size()>0){
						gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().get(0).setVisible(false);
						gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().remove(0);
					}
					gui.activateTheSpellFromHand(a1,c,active);
					break;
				case "Heavy Storm" :
					active.activateSpell(c, null);
					ShowMessageThread ameen1 = new ShowMessageThread(gui,"All spells have been destroyed",active);
					Thread d900 = new Thread(ameen1);
					d900.start();
					gui.getOp().getSpellsAndMonstersPanel().getSpellsPanel().removeAll();
					gui.getAc().getSpellsAndMonstersPanel().getSpellsPanel().removeAll();
					while(gui.getAc().getSpellsAndMonstersPanel().getSpellButtons().size()>0){
						gui.getAc().getSpellsAndMonstersPanel().getSpellButtons().get(0).setVisible(false);
						gui.getAc().getSpellsAndMonstersPanel().getSpellButtons().remove(0);
					}
					while(gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().size()>0){
						gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().get(0).setVisible(false);
						gui.getOp().getSpellsAndMonstersPanel().getSpellButtons().remove(0);
					}
					gui.activateTheSpellFromHand(a1,c,active);

					break;
				case "Mage Power" :
					if(active.getField().getMonstersArea().size()==0){
						ShowMessageThread ameen3 = new ShowMessageThread(gui,"You have no monsters to activate on",active);
						Thread d909 = new Thread(ameen3);
						d909.start();
					}else{
					ShowMessageThread ameen3 = new ShowMessageThread(gui,"Please choose a monster to activate on",active);
					Thread d909 = new Thread(ameen3);
					d909.start();
					MagePower = true;
					MagePowerCard = c;
					MagePowerButton = a1;
					}
					break;
				case "Monster Reborn" :
					if(active.getField().getGraveyard().size()>0||opponent.getField().getGraveyard().size()>0){
					active.activateSpell(c, null);
					MonsterCard m = active.getField().getMonstersArea().get(active.getField().getMonstersArea().size()-1);
					String options1[] = {"Attack","Defense"};
					int i = JOptionPane.showOptionDialog(null, "In which mode do you want ?","Monster Reborn",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options1,options1[0]);
					MonsterButton x;
					if(i==0){
						m.setMode(Mode.ATTACK);
						x = gui.getAc().getSpellsAndMonstersPanel().summon(m);
						ShowMessageThread ameen3 = new ShowMessageThread(gui,"You have summoned "+m.getName(),active);
						Thread d909 = new Thread(ameen3);
						d909.start();
						x.addActionListener(this);
						x.addMouseListener(this);
					}else{
						if(i==1){
							m.setMode(Mode.DEFENSE);
							ShowMessageThread ameen3 = new ShowMessageThread(gui,"You have set "+m.getName(),active);
							Thread d909 = new Thread(ameen3);
							d909.start();
							x = gui.getAc().getSpellsAndMonstersPanel().set(m, gui);
							x.addActionListener(this);
							x.addMouseListener(this);
						}
					}

					}else{
						ShowMessageThread ameen3 = new ShowMessageThread(gui,"No monsters in both graveyards",active);
						Thread d909 = new Thread(ameen3);
						d909.start();
					}
					break;
				case "Pot of Greed" :
					HandButton handButton;
					active.activateSpell(c, null);
					String[] options1 = {"Play again","exit"};
					if(board.getWinner()!=null){
						int k = JOptionPane.showOptionDialog(null, board.getWinner().getName()+" Won this game","Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options1,options1[0]);
						gui.dispose();
						if(k==0){
							try {
								new InputInterface();
								return;
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
						}
						return;
					}
					ShowMessageThread ameen3 = new ShowMessageThread(gui,"2 extra cards to your hand",active);
					Thread d909 = new Thread(ameen3);
					d909.start();
					for(int j=active.getField().getHand().size()-2;j<active.getField().getHand().size();j++){
					if(active.getField().getHand().get(j)instanceof MonsterCard){
						handButton = gui.getAc().getHandPanel().addTheButton(active.getField().getHand().get(j));
						handButton.setName("Monster");
						handButton.setVisible(true);
					}else{
						handButton = gui.getAc().getHandPanel().addTheButton(active.getField().getHand().get(j));
						handButton.setName("Spell");
						handButton.setVisible(true);
					}
					handButton.addActionListener(this);
					handButton.addMouseListener(this);
					handButton.addMouseListener(gui.getAc().getHandPanel());
				}
					gui.activateTheSpellFromHand(a1,c,active);
					break;
				case "Raigeki" :
					active.activateSpell(c, null);
					ShowMessageThread cd1211 = new ShowMessageThread(gui,"All the monsters on the field destroyed",active);
					Thread d755= new Thread(cd1211);
					d755.start();
					gui.getOp().getSpellsAndMonstersPanel().getMonstersPanel().removeAll();
				
					while(gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().size()>0){
						gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().get(0).setVisible(false);
						gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().remove(0);
					}
					gui.activateTheSpellFromHand(a1,c,active);

					
					break;
				}

				
				}catch(WrongPhaseException e){
					ShowMessageThread cd1211 = new ShowMessageThread(gui,"Wrong Phase",active);
					Thread d755= new Thread(cd1211);
					d755.start();
				}catch(NoMonsterSpaceException e){
					ShowMessageThread cd121 = new ShowMessageThread(gui,"No monster space",active);
					Thread d55= new Thread(cd121);
					d55.start();
				}
			
			sacrificing=false;
			toBeSummonedSacr = null;
			sacrificing=false;
			sacrifices1=null;
			sacrifices2=null;
			sacrifices1But=null;
			sacrifices2But=null;
		}
		if(a.getSource() instanceof SetSpellClick){
			HandButton a1 = tempHand;
			gui.getActivateSpell().setVisible(false);
			gui.getSetSpell().setVisible(false);
			int index = gui.getAc().getHandPanel().getHandButtons().indexOf(a1);
			SpellCard c =(SpellCard) active.getField().getHand().get(index);
			try{
				SpellButton spellButton;
				active.setSpell(c);
				a1.setVisible(false);
				gui.getAc().getHandPanel().getHandPanel().remove(a1);
				gui.getAc().getHandPanel().getBackCards().remove(0);
				gui.getAc().getHandPanel().getHandButtons().remove(a1);	
				spellButton = gui.getAc().getSpellsAndMonstersPanel().setSpell(c);
				spellButton.addActionListener(this);
				spellButton.addMouseListener(this);

			}catch(WrongPhaseException e){
				ShowMessageThread cd333 = new ShowMessageThread(gui,"Wrong phase",active);
				Thread d= new Thread(cd333);
				d.start();
				//JOptionPane.showMessageDialog(null,"Wrong phase");
			}
		}
		if(a.getSource() instanceof SummonClick){
			HandButton a1 = tempHand;
			gui.getSummon().setVisible(false);
			gui.getSetMonster().setVisible(false);
			int index = gui.getAc().getHandPanel().getHandButtons().indexOf(a1);
			
				try{
					MonsterCard c =(MonsterCard) active.getField().getHand().get(index);


					if(c.getLevel()<=4){
						active.summonMonster(c);
	///					summonAudio.play();
						a1.setVisible(false);
						gui.getAc().getHandPanel().getHandPanel().remove(a1);
						gui.getAc().getHandPanel().getBackCards().remove(0);
						gui.getAc().getHandPanel().getHandButtons().remove(a1);
						MonsterButton monsterButton = gui.getAc().getSpellsAndMonstersPanel().summon(c); ;
						monsterButton.addActionListener(this);
						monsterButton.addMouseListener(this);

						sacrificing=false;
						toBeSummonedSacr = null;
						sacrificing=false;
						sacrifices1=null;
						sacrifices2=null;
						sacrifices1But=null;
						sacrifices2But=null;
					}else{
						if(c.getLevel()==5||c.getLevel()==6){
							if(active.getField().getMonstersArea().size()<1){
								ShowMessageThread cd33 = new ShowMessageThread(gui,"You don't have enough monsters",active);
								Thread d= new Thread(cd33);
								d.start();
								//JOptionPane.showMessageDialog(null,"You don't have enough monsters in your monsters area to be sacrificed with");
							}else{	
								sacrificing = true;
								toBeSummonedSacr = c;
								summoningORsetting = 0;
								//System.out.println(toBeSummoned);
								//		toBeSummonedBut = monsterButton;
								ShowMessageThread cd44 = new ShowMessageThread(gui,"Choose one monster to be sacrificed with",active);
								Thread d= new Thread(cd44);
								d.start();
								//JOptionPane.showMessageDialog(null,"Please choose one monster from your monsters area to sacrifice with");
								
							}
						}else{
							if(active.getField().getMonstersArea().size()<2){
							//	System.out.println(active.getField().getMonstersArea().size());
								ShowMessageThread cd88 = new ShowMessageThread(gui,"You don't have enough monsters to be sacrificed",active);
								Thread d= new Thread(cd88);
								d.start();
								//JOptionPane.showMessageDialog(null,"You don't have enough monsters in your monsters area to be sacrificed with");

							}else{
							summoningORsetting = 0;
							sacrificing=true;
							toBeSummonedSacr = c;
							ShowMessageThread cd = new ShowMessageThread(gui,"Choose two monsters to be sacrificed with",active);
							Thread d= new Thread(cd);
							d.start();
							//JOptionPane.showMessageDialog(null,"Please choose two monsters from your monsters area to sacrifice with");
							}
						}
					}

					//	gui.getAc().getSpellsAndMonstersPanel().summon(c,monsterButton);
				}catch(MultipleMonsterAdditionException e){
					ShowMessageThread cd32 = new ShowMessageThread(gui,"You can't add two monsters in the same turn",active);
					Thread d= new Thread(cd32);
					d.start();
					//JOptionPane.showMessageDialog(null,"You can't add two monsters in the same turn","hello",JOptionPane.INFORMATION_MESSAGE,test);
				}catch(WrongPhaseException e1){
					ShowMessageThread cd45 = new ShowMessageThread(gui,"Wrong phase",active);
					Thread d= new Thread(cd45);
					d.start();
					//JOptionPane.showMessageDialog(null,"Wrong phase");
				}catch(NoMonsterSpaceException e2){
					ShowMessageThread cd54 = new ShowMessageThread(gui,"There is no monster space",active);
					Thread d= new Thread(cd54);
					d.start();
					//JOptionPane.showMessageDialog(null,"There is no monster space");
				}
		}
		if(a.getSource() instanceof SetClick ){
			HandButton a1 = tempHand;
			gui.getSummon().setVisible(false);
			gui.getSetMonster().setVisible(false);
			int index = gui.getAc().getHandPanel().getHandButtons().indexOf(a1);
			try{
				MonsterCard c =(MonsterCard) active.getField().getHand().get(index);
				if(c.getLevel()<=4){
				active.setMonster(c);
			//	summonAudio.play();
				a1.setVisible(false);
				gui.getAc().getHandPanel().getHandPanel().remove(a1);
				gui.getAc().getHandPanel().getBackCards().remove(0);
				gui.getAc().getHandPanel().getHandButtons().remove(a1);
				MonsterButton monsterButton = gui.getAc().getSpellsAndMonstersPanel().set(c,gui);
				monsterButton.addActionListener(this);
				monsterButton.addMouseListener(this);
				
				sacrificing=false;
				toBeSummonedSacr = null;
				sacrificing=false;
				sacrifices1=null;
				sacrifices2=null;
				sacrifices1But=null;
				sacrifices2But=null;
				//	gui.getAc().getHandPanel().getTheHand().remove(c);
				//		gui.getAc().getSpellsAndMonstersPanel().set(c,monsterButton);
				}
				else{
					if(c.getLevel()==5||c.getLevel()==6){
						if(active.getField().getMonstersArea().size()<1){
							ShowMessageThread cd98 = new ShowMessageThread(gui,"You don't have enough monsters in your field",active);
							Thread d= new Thread(cd98);
							d.start();
							//JOptionPane.showMessageDialog(null,"You don't have enough monsters in your monsters area to be sacrificed with");
						}else{
							
							sacrificing = true;
							//System.out.println("success");
							toBeSummonedSacr = c;
							summoningORsetting = 1;
							//System.out.println(toBeSummoned);
							//		toBeSummonedBut = monsterButton;
							ShowMessageThread cd89 = new ShowMessageThread(gui,"Choose one monster to sacrifice with",active);
							Thread d= new Thread(cd89);
							d.start();
							//JOptionPane.showMessageDialog(null,"Please choose one monster from your monsters area to sacrifice with");
							
						}
					}else{
						if(active.getField().getMonstersArea().size()<2){
						//	System.out.println(active.getField().getMonstersArea().size());
							ShowMessageThread cd87 = new ShowMessageThread(gui,"You don't have enough monsters",active);
							Thread d= new Thread(cd87);
							d.start();
							//JOptionPane.showMessageDialog(null,"You don't have enough monsters in your monsters area to be sacrificed with");

						}else{
							//System.out.println("success");
							summoningORsetting = 1;

						sacrificing=true;
						toBeSummonedSacr = c;
						ShowMessageThread cd77 = new ShowMessageThread(gui,"Choose two monsters to be sacrificed with",active);
						Thread d= new Thread(cd77);
						d.start();
						//JOptionPane.showMessageDialog(null,"Please choose two monsters from your monsters area to sacrifice with");
						}
					}
				}
			}catch(MultipleMonsterAdditionException e){
				ShowMessageThread cd556 = new ShowMessageThread(gui,"You can't add two monsters in the same turn",active);
				Thread d= new Thread(cd556);
				d.start();
				//JOptionPane.showMessageDialog(null,"You can't add two monsters in the same turn");
			}catch(WrongPhaseException e1){
				ShowMessageThread cd76 = new ShowMessageThread(gui,"Wrong phase",active);
				Thread d= new Thread(cd76);
				d.start();
			//	JOptionPane.showMessageDialog(null,"Wrong phase");
			}catch(NoMonsterSpaceException e2){
				ShowMessageThread cd599 = new ShowMessageThread(gui,"There is no monster space",active);
				Thread d= new Thread(cd599);
				d.start();
			//	JOptionPane.showMessageDialog(null,"There is no monster space");
			}	
		}

		
		if(a.getSource() instanceof HandButton){
			HandButton a1 = (HandButton) a.getSource();
			tempHand = a1;
			//	sacrificing=false;
		//	System.out.println(gui.getAc().getHandPanel().getHandButtons().size()+" "+gui.getAc().getHandPanel().getTheHand().size());
			//	System.out.println();
			if(a1.getName().equals("Monster")){
				gui.getSummon().setVisible(true);
				gui.getSetMonster().setVisible(true);
				//String options[] = {"Summon","Set"};
				//int i = JOptionPane.showOptionDialog(null, "summon or set","activating monster",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				//String x = JOptionPane.showInputDialog("Please write summon or set");
					
			}
			if(a1.getName().equals("Spell")){
				gui.getSetSpell().setVisible(true);
				gui.getActivateSpell().setVisible(true);
				//	String x = JOptionPane.showInputDialog("Please write activate or set");
				//String x[] = {"Activate","Set"};
				//int i = JOptionPane.showOptionDialog(null, "What do you want to do with this spell","Spell",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,x,x[0]);
			}
		}
		if(a.getSource() instanceof EndTurnButton){
			if(active.endTurn()){
				//System.out.println(gui.getAc().getHandPanel().getTheHand().size()+" "+gui.getAc().getHandPanel().getHandButtons().size());
				gui.getAc().getHandPanel().getHandPanel().setVisible(false);
				gui.getOp().getHandPanel().getBackCards().setVisible(false);
				gui.getOp().getHandPanel().getHandPanel().setVisible(true);
				gui.getAc().getHandPanel().getBackCards().setVisible(true);
				PlayerPanel temp = new PlayerPanel("");
				temp = gui.getAc();
				gui.setAc(gui.getOp());
				gui.setOp(temp);
				active = board.getActivePlayer();
				opponent = board.getOpponentPlayer();
				//	System.out.println("active :"+gui.getAc().getName()+" "+active.getName());
				//	System.out.println(gui.getAc().getHandPanel().getTheHand().get(0).getName()+"  "+active.getField().getHand().get(0).getName());
				Card hand1 = gui.getAc().getHandPanel().getTheHand().get(gui.getAc().getHandPanel().getTheHand().size()-1);
				HandButton newBut = gui.getAc().getHandPanel().addTheButton(hand1);

				//System.out.println(gui.getAc().getHandPanel().getTheHand().get(gui.getAc().getHandPanel().getTheHand().size()-1).getName());
				//	System.out.println(hand1.getName());
				if(hand1 instanceof MonsterCard){
					//	newBut = new HandButton();
					newBut.setName("Monster");
					//	System.out.println(true);
				}else{
					//handButton = new HandButton();
					newBut.setName("Spell");
				}

				newBut.addActionListener(this);
				newBut.addMouseListener(this);
				newBut.addMouseListener(gui.getAc().getHandPanel());

				//	gui.getAc().getHandPanel().addDescription(newBut, hand1);
				//	System.out.println(gui.getAc().getHandPanel().getHandButtons().size()+" "+gui.getAc().getHandPanel().getHandButtons().size());
				sacrificing=false;
				toBeSummonedSacr = null;
				sacrificing=false;
				sacrifices1=null;
				sacrifices2=null;
				sacrifices1But=null;
				sacrifices2But=null;
				gui.setCurrentPhase(active.getField().getPhase()+"");

			}
		}
		if(a.getSource() instanceof EndPhaseButton){
			if(active.getField().getPhase()==Phase.MAIN2){
				active.endPhase();
				gui.setCurrentPhase(active.getField().getPhase()+"");
				//		System.out.println(gui.getAc().getHandPanel().getTheHand().size()+" "+gui.getAc().getHandPanel().getHandButtons().size());
				gui.getAc().getHandPanel().getHandPanel().setVisible(false);
				gui.getOp().getHandPanel().getHandPanel().setVisible(true);
				gui.getAc().getHandPanel().getBackCards().setVisible(true);
				gui.getOp().getHandPanel().getBackCards().setVisible(false);
				PlayerPanel temp = new PlayerPanel("");
				temp = gui.getAc();
				gui.setAc(gui.getOp());
				gui.setOp(temp);
				Player temp1 = active;
				active = opponent;
				opponent = temp1;
				HandButton newBut = gui.getAc().getHandPanel().addTheButton(gui.getAc().getHandPanel().getTheHand().get(gui.getAc().getHandPanel().getTheHand().size()-1));
				//System.out.println(gui.getAc().getHandPanel().getTheHand().get(gui.getAc().getHandPanel().getTheHand().size()-1).getName());
				Card hand1 = gui.getAc().getHandPanel().getTheHand().get(gui.getAc().getHandPanel().getTheHand().size()-1);
				if(hand1 instanceof MonsterCard){
					//	newBut = new HandButton();
					newBut.setName("Monster");
				}else{
					//handButton = new HandButton();
					newBut.setName("Spell");
				}
				newBut.addActionListener(this);
				newBut.addMouseListener(this);
				newBut.addMouseListener(gui.getAc().getHandPanel());
				gui.setCurrentPhase(active.getField().getPhase()+"");
				gui.getCurrentPhase().setLocation(243, 340);


				//System.out.println(gui.getAc().getHandPanel().getTheHand().size()+" "+gui.getAc().getHandPanel().getHandButtons().size());


			}else{
				active.endPhase();
				gui.setCurrentPhase(active.getField().getPhase()+"");
			}
			sacrificing=false;
			toBeSummonedSacr = null;
			sacrificing=false;
			sacrifices1=null;
			sacrifices2=null;
			sacrifices1But=null;
			sacrifices2But=null;
		}
		if(a.getSource() instanceof MonsterButton){
			
			try{
			MonsterButton c = (MonsterButton) a.getSource();
			
			//sacrificing = true;
			int index1 = gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().indexOf(c);
			//System.out.println(index1);
			JLabel plus = new JLabel("    +");
			plus.setFont(new Font("Papyrus",Font.BOLD,30));
			if(MagePower&&gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().contains(c)){
				MagePower = false;
				MonsterCard mm = active.getField().getMonstersArea().get(index1);
				if(!active.getField().getSpellArea().contains(MagePowerCard)){
				active.activateSpell(MagePowerCard, mm);
				gui.activateTheSpellFromHand(MagePowerButton,MagePowerCard,active);
				}else{
					active.activateSpell(MagePowerCard, mm);
					gui.activateTheSpellFromField(MagePowerButtonField,MagePowerCard,active);
				}
				JLabel magePoints = new JLabel(" "+(500*(active.getField().getSpellArea().size()+opponent.getField().getSpellArea().size()))+"");
				magePoints.setFont(new Font("Papyrus",Font.BOLD,30));
				c.setLayout(new GridLayout(2,1));
				c.add(plus);
				c.add(magePoints);
				ShowMessageThread cd1 = new ShowMessageThread(gui,mm.getName()+" gained "+(500*(active.getField().getSpellArea().size()+opponent.getField().getSpellArea().size()))+" points",active);
				Thread d1= new Thread(cd1);
				d1.start();
				return;
			}
			if(changingTheHeart&&gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().contains(c)){
				changingTheHeart = false;
				int index2 = gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().indexOf(c);
				gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().remove(c);
				gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().add(c);
				c.setVisible(true);
				gui.getAc().getSpellsAndMonstersPanel().getMonstersPanel().add(c);
				MonsterCard mm = opponent.getField().getMonstersArea().get(index2);
				if(!active.getField().getSpellArea().contains(changingHeart)){
				active.activateSpell(changingHeart, mm);
				gui.activateTheSpellFromHand(TheHandButtonForChangingOfHeart,changingHeart,active);
				}else{
					active.activateSpell(changingHeart, mm);
					gui.activateTheSpellFromField(TheFieldButtonForChangingOfHeart,changingHeart,active);
				}
				ShowMessageThread cd1 = new ShowMessageThread(gui,"You took the control of "+mm.getName(),active);
				Thread d1= new Thread(cd1);
				d1.start();
				return;
			}

			//System.out.println(sacrificing);
			boolean impFlag1 = false;
			boolean impFlag2 = false;
			if(sacrificing==true&&active.getField().getHand().contains(toBeSummonedSacr))	{
				if(!gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().contains(c)){
					ShowMessageThread cd1 = new ShowMessageThread(gui,"You must chose only monsters in your monsters Area",active);
					Thread d1= new Thread(cd1);
					d1.start();
					//JOptionPane.showMessageDialog(null,"You must chose only monsters in your monsters Area");
					sacrificing = false;
					sacrifices1 = null;

				}else{
				MonsterCard m =(MonsterCard) active.getField().getMonstersArea().get(index1);
				//System.out.println(toBeSummoned);
				if(sacrifices1==null&&(toBeSummonedSacr.getLevel()==5||toBeSummonedSacr.getLevel()==6)){
					sacrifices1 = m;
					sacrifices1But = gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().get(index1);
					impFlag1 = true;
				}else{
					if(sacrifices1==null){
						sacrifices1 = m;
						sacrifices1But = gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().get(index1);
						impFlag1 = false;;
						impFlag2 = false;
					}else{
						if(sacrifices2==null){
							sacrifices2=m;
							sacrifices2But = gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().get(index1);
							impFlag2 = true;
							impFlag1 = false;
						}
					}
				}
				}
				try{
				if(sacrifices1!=null&&(toBeSummonedSacr.getLevel()==5||toBeSummonedSacr.getLevel()==6)&&impFlag1){
					
						
						if(!active.getField().getMonstersArea().contains(sacrifices1)){
							ShowMessageThread cd1 = new ShowMessageThread(gui,"You must chose only monsters in your monsters Area",active);
							Thread d1= new Thread(cd1);
							d1.start();
							//JOptionPane.showMessageDialog(null,"You must chose only monsters in your monsters Area");
							sacrificing=false;
							toBeSummonedSacr = null;
							sacrificing=false;
							sacrifices1=null;
							sacrifices2=null;
							sacrifices1But=null;
							sacrifices2But=null;

						}else{
					int x =gui.getAc().getHandPanel().getTheHand().indexOf(toBeSummonedSacr);
					//System.out.println(gui.getAc().getHandPanel().getHandButtons().contains(x));
						//System.out.println(gui.getAc().getHandPanel().getTheHand().size()+" "+gui.getAc().getHandPanel().getHandButtons().size());
					//System.out.println(gui.getAc().getHandPanel().getTheHand().indexOf(toBeSummoned)+" index to be summoned");
					HandButton temp = gui.getAc().getHandPanel().getHandButtons().get(x);
	//				summonAudio.play();
					if(summoningORsetting==0){
					active.summonMonster(toBeSummonedSacr);
					}else{
					active.setMonster(toBeSummonedSacr);
					}

					temp.setVisible(false);
					gui.getAc().getHandPanel().getHandPanel().remove(temp);
					gui.getAc().getHandPanel().getBackCards().remove(0);
					gui.getAc().getHandPanel().getHandButtons().remove(temp);
					MonsterButton monsterButton;
					if(summoningORsetting==0){
						monsterButton = gui.getAc().getSpellsAndMonstersPanel().summon(toBeSummonedSacr);
						}else{
						monsterButton = gui.getAc().getSpellsAndMonstersPanel().set(toBeSummonedSacr,gui);
						}
				//	MonsterButton monsterButton = gui.getAc().getSpellsAndMonstersPanel().summon(toBeSummoned);
					monsterButton.addActionListener(this);
					monsterButton.addMouseListener(this);

				//	active.summonMonster(toBeSummoned);


					gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().remove(sacrifices1But);
					gui.getAc().getSpellsAndMonstersPanel().getMonstersPanel().remove(sacrifices1But);
					gui.getAc().getSpellsAndMonstersPanel().remove(sacrifices1But);
					sacrifices1But.setVisible(false);

					active.getField().removeMonsterToGraveyard(sacrifices1);

					sacrificing=false;
					sacrificing = false;
					toBeSummonedSacr = null;
					sacrifices1=null;
					sacrifices2=null;
					sacrifices1But=null;
					sacrifices2But=null;
						}
				}else{
					if(sacrifices2!=null&&sacrifices1!=null&&(toBeSummonedSacr.getLevel()==7||toBeSummonedSacr.getLevel()==8)&&impFlag2&&sacrifices1!=sacrifices2){
						if(!active.getField().getMonstersArea().contains(sacrifices1)){
							ShowMessageThread cd1 = new ShowMessageThread(gui,"You must chose only monsters in your monsters Area",active);
							Thread d1= new Thread(cd1);
							d1.start();
							//JOptionPane.showMessageDialog(null,"You must chose only monsters in your monsters Area");
						//	sacrificing = false;
							sacrifices2 = null;
							

						}else{
						
					
						int x =gui.getAc().getHandPanel().getTheHand().indexOf(toBeSummonedSacr);
						HandButton temp = gui.getAc().getHandPanel().getHandButtons().get(x);
						if(summoningORsetting==0){
							active.summonMonster(toBeSummonedSacr);
							}else{
								active.setMonster(toBeSummonedSacr);
						}
						temp.setVisible(false);
						gui.getAc().getHandPanel().getHandPanel().remove(temp);
						gui.getAc().getHandPanel().getBackCards().remove(0);
						gui.getAc().getHandPanel().getHandButtons().remove(temp);
						MonsterButton monsterButton;
						if(summoningORsetting==0){
							monsterButton = gui.getAc().getSpellsAndMonstersPanel().summon(toBeSummonedSacr);
							}else{
							monsterButton = gui.getAc().getSpellsAndMonstersPanel().set(toBeSummonedSacr,gui);
							}
						monsterButton.addActionListener(this);
						monsterButton.addMouseListener(this);

					//	active.summonMonster(toBeSummoned);

						sacrifices1But.setVisible(false);
						gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().remove(sacrifices1But);
						gui.getAc().getSpellsAndMonstersPanel().getMonstersPanel().remove(sacrifices1But);
						gui.getAc().getSpellsAndMonstersPanel().remove(sacrifices1But);

						sacrifices2But.setVisible(false);
						gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().remove(sacrifices2But);
						gui.getAc().getSpellsAndMonstersPanel().getMonstersPanel().remove(sacrifices2But);
						gui.getAc().getSpellsAndMonstersPanel().remove(sacrifices2But);


						active.getField().removeMonsterToGraveyard(sacrifices1);
						active.getField().removeMonsterToGraveyard(sacrifices2);
						
						sacrificing = false;
						toBeSummonedSacr = null;
						//						sacrificing=false;
						sacrifices1=null;
						sacrifices2=null;
						sacrifices1But=null;
						sacrifices2But=null;
						}
					}
				}
				}catch(MultipleMonsterAdditionException e){
					ShowMessageThread cd1 = new ShowMessageThread(gui,"You can't add two monsters in the same turn",active);
					Thread d1= new Thread(cd1);
					d1.start();
					//JOptionPane.showMessageDialog(null,"You can't add two monsters in the same turn");
				}catch(WrongPhaseException e1){
					ShowMessageThread cd1 = new ShowMessageThread(gui,"Wrong phase",active);
					Thread d1= new Thread(cd1);
					d1.start();
					//JOptionPane.showMessageDialog(null,"Wrong phase");
				}catch(NoMonsterSpaceException e2){
					ShowMessageThread cd1 = new ShowMessageThread(gui,"You can't add, There is no monster space",active);
					Thread d1= new Thread(cd1);
					d1.start();
					//JOptionPane.showMessageDialog(null,"There is no monster space");
				}
			}else{


				sacrificing=false;
				toBeSummonedSacr = null;
				sacrificing=false;
				sacrifices1=null;
				sacrifices2=null;
				sacrifices1But=null;
				sacrifices2But=null;
				if(gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().contains(c)&&attacking==false){
					tempMonster = c;
					gui.getCurrentPhase().setVisible(false);
					if(board.getActivePlayer().getField().getPhase()==Phase.BATTLE){
						if(board.getOpponentPlayer().getField().getMonstersArea().size()==0){
							gui.getAttackDirect().setVisible(true);
							
						}else{
							gui.getAttackMonster().setVisible(true);
						}
					}else{
						gui.getSwitchMode().setVisible(true);
					}
					
				}else{
					if(attacking==true&&gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().contains(c)){
						int index =  gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().indexOf(c);
						MonsterCard toBeAttacked = opponent.getField().getMonstersArea().get(index);
						attacking = false;
						int activeMonsterAreaBefore = active.getField().getMonstersArea().size();
						int opponentMonsterAreaBefore = opponent.getField().getMonstersArea().size();
						try{
							if(active.declareAttack(attackingMonster, toBeAttacked)){
								if(board.getOpponentPlayer().getLifePoints()<=0||board.getActivePlayer().getLifePoints()<=0){
									JOptionPane.showMessageDialog(null, "Game is over , "+board.getWinner().getName() +" won");	
									}
								
								if(active.getField().getMonstersArea().size()<activeMonsterAreaBefore){
									attackingMonsterButton.setVisible(false);
									gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().remove(attackingMonsterButton);
									gui.getAc().getSpellsAndMonstersPanel().getMonstersPanel().remove(attackingMonsterButton);
									gui.getAc().getSpellsAndMonstersPanel().remove(attackingMonsterButton);
								}
								if(opponent.getField().getMonstersArea().size()<opponentMonsterAreaBefore){
									c.setVisible(false);
									gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().remove(c);
									gui.getOp().getSpellsAndMonstersPanel().getMonstersPanel().remove(c);
									gui.getOp().getSpellsAndMonstersPanel().remove(c);
								}	
							}
						}catch(WrongPhaseException e){
							ShowMessageThread cd1 = new ShowMessageThread(gui,"You can attack only in the battle phase",active);
							Thread d1= new Thread(cd1);
							d1.start();
							//JOptionPane.showMessageDialog(null,"You can attack only in the battle phase");
						}catch(MonsterMultipleAttackException e1){
							ShowMessageThread cd1 = new ShowMessageThread(gui,"A monster can attack only one time per turn",active);
							Thread d1= new Thread(cd1);
							d1.start();
							//JOptionPane.showMessageDialog(null,"A monster can attack only one time per turn");
						}catch(DefenseMonsterAttackException e2){
							ShowMessageThread cd1 = new ShowMessageThread(gui,"A monster can not attack in defense mode",active);
							Thread d1= new Thread(cd1);
							d1.start();
							//JOptionPane.showMessageDialog(null,"A monster can not attack in defense mode");
						}
					}
				}
			}
			}catch(WrongPhaseException e){
				ShowMessageThread cd1 = new ShowMessageThread(gui,"You can attack only in the battle phase",active);
				Thread d1= new Thread(cd1);
				d1.start();
			}catch(MonsterMultipleAttackException e1){
				ShowMessageThread cd1 = new ShowMessageThread(gui,"A monster can attack only one time per turn",active);
				Thread d1= new Thread(cd1);
				d1.start();
				//JOptionPane.showMessageDialog(null,"A monster can attack only one time per turn");
			}catch(DefenseMonsterAttackException e2){
				ShowMessageThread cd1 = new ShowMessageThread(gui,"A monster can not attack in defense mode",active);
				Thread d1= new Thread(cd1);
				d1.start();
				//JOptionPane.showMessageDialog(null,"A monster can not attack in defense mode");
			}catch(NoSpellSpaceException e){
				ShowMessageThread cd1 = new ShowMessageThread(gui,"No spell space",active);
				Thread d1= new Thread(cd1);
				d1.start();
			}
		}
		if(a.getSource() instanceof SpellButton){
			tempSpell = (SpellButton)a.getSource();
			gui.getActivateFromField().setVisible(true);
			gui.getCurrentPhase().setVisible(false);
			sacrificing=false;
			toBeSummonedSacr = null;
			sacrificing=false;
			sacrifices1=null;
			sacrifices2=null;
			sacrifices1But=null;
			sacrifices2But=null;
		}

		if(board.getWinner()!=null){
			gui.setVisible(false);
			gui.dispose();
		}

		gui.getAc().getDeckLabel().setText(active.getField().getDeck().getDeck().size()+"");
		gui.getOp().getDeckLabel().setText(opponent.getField().getDeck().getDeck().size()+"");

		
		if(opponent.getField().getGraveyard().size()!=0){
			if(gui.getP2Name()==opponent.getName()){
			Card c = opponent.getField().getGraveyard().get(opponent.getField().getGraveyard().size()-1);
			switch (c.getName()){
			case "Blue-Eyes White Dragon" : gui.setGraveyardOpponent(BlueEyesWhiteDragon);break;
			case "Cosmo Queen" : gui.setGraveyardOpponent(CosmoQueen);break;
			case "Dark Magician" : gui.setGraveyardOpponent(DarkMagician);break;
			case "Red-Eyes Black Dragon" : gui.setGraveyardOpponent(RedEyesBlackDragon);break;
			//case "Gaia The Fierce Knight" : m=new MonsterButton(GaiaTheFierceKnight);
			case "Summoned Skull" : gui.setGraveyardOpponent(SummonedSkull);break;
			//case "Fence Guard Magician" : m=new MonsterButton(FenceGuardMagician);
			case "Dark Magician Girl" : gui.setGraveyardOpponent(DarkMagicianGirl);break;
			case "Curse Of Dragon" : gui.setGraveyardOpponent(CurseOfDragon);break;
			//case "Fence Guard Dragon" : m=new MonsterButton(FenceGuardDragon);
			case "Alexandrite Dragon" :gui.setGraveyardOpponent(AlexandriteDragon);break;
			case "Vorse Raider" :gui.setGraveyardOpponent(VorseRaider);break;
			case "Gemini Elf" :gui.setGraveyardOpponent(GeminiElf);break;
			//case "Fence Guard Apprentice" : m=new MonsterButton(FenceGuardApprentice);
			case "Beta The Magnet Warrior" : gui.setGraveyardOpponent(BetaTheMagnetWarrior);break;
			case "Alligator Sword" : gui.setGraveyardOpponent(AlligatorSword);break;
			case "Gamma The Magnet Warrior" : gui.setGraveyardOpponent(GammaTheMagnetWarrior);break;
			case "Celtic Guardian" : gui.setGraveyardOpponent(CelticGuardian);break;
			case "Alpha The Magnet Warrior" : gui.setGraveyardOpponent(AlphaTheMagnetWarrior);break;
			case "Harpie Lady" : gui.setGraveyardOpponent(HarpieLady);break;
			case "Big Shield Gardna" : gui.setGraveyardOpponent(BigShieldGardna);break;
			case "Witty Phantom" :gui.setGraveyardOpponent(WittyPhantom);break;
			case "Baby Dragon" : gui.setGraveyardOpponent(BabyDragon);break;
			case "Cyber Jar" :gui.setGraveyardOpponent(CyberJar);break;
			case "Clown Zombie" :gui.setGraveyardOpponent(ClownZombie);break;
			case "Time Wizard" :gui.setGraveyardOpponent(TimeWizard);break;
			case "Man-Eater Bug" :gui.setGraveyardOpponent(ManEaterBug);break;
			case "Kuriboh" :gui.setGraveyardOpponent(Kuriboh);break;
			case "Fence Guard" :gui.setGraveyardOpponent(FenceGuard);break;
			case "Fence Guard Magician" :gui.setGraveyardOpponent(FenceGuardMagician);break;
			case "Fence Guard Dragon" :gui.setGraveyardOpponent(FenceGuardDragon);break;
			case "Fence Guard Apprentice" :gui.setGraveyardOpponent(FenceGuardApprentice);break;
			
			
			case "Dark Hole" :gui.setGraveyardOpponent(DarkHole);break;
			case "Graceful Dice" :gui.setGraveyardOpponent(GracefulDice);break;
			case "Heavy Storm" :gui.setGraveyardOpponent(HeavyStorm);break;
			case "Mega Power" :gui.setGraveyardOpponent(MegaPower);break;
			case "Monster Reborn" :gui.setGraveyardOpponent(MonsterReborn);break;
			case "Pot of Greed" :gui.setGraveyardOpponent(PotOfGreed);break;
			case "Harpie's Feather Duster" :gui.setGraveyardOpponent(HarpieFeather);break;
			case "Raigeki" :gui.setGraveyardOpponent(Raigeki);break;
			case "Card Destruction" : gui.setGraveyardOpponent(CardDestruction);break;
			case "Change Of Heart" : gui.setGraveyardOpponent(ChangeofHeart);break;
			}
			}else{
				Card c = opponent.getField().getGraveyard().get(opponent.getField().getGraveyard().size()-1);
				switch (c.getName()){
				case "Blue-Eyes White Dragon" : gui.setGrraveyardActive(BlueEyesWhiteDragon);break;
				case "Cosmo Queen" : gui.setGrraveyardActive(CosmoQueen);break;
				case "Dark Magician" : gui.setGrraveyardActive(DarkMagician);break;
				case "Red-Eyes Black Dragon" : gui.setGrraveyardActive(RedEyesBlackDragon);break;
				//case "Gaia The Fierce Knight" : m=new MonsterButton(GaiaTheFierceKnight);
				case "Summoned Skull" : gui.setGrraveyardActive(SummonedSkull);break;
				//case "Fence Guard Magician" : m=new MonsterButton(FenceGuardMagician);
				case "Dark Magician Girl" : gui.setGrraveyardActive(DarkMagicianGirl);break;
				case "Curse Of Dragon" : gui.setGrraveyardActive(CurseOfDragon);break;
				//case "Fence Guard Dragon" : m=new MonsterButton(FenceGuardDragon);
				case "Alexandrite Dragon" :gui.setGrraveyardActive(AlexandriteDragon);break;
				case "Vorse Raider" :gui.setGrraveyardActive(VorseRaider);break;
				case "Gemini Elf" :gui.setGrraveyardActive(GeminiElf);break;
				//case "Fence Guard Apprentice" : m=new MonsterButton(FenceGuardApprentice);
				case "Beta The Magnet Warrior" : gui.setGrraveyardActive(BetaTheMagnetWarrior);break;
				case "Alligator Sword" : gui.setGrraveyardActive(AlligatorSword);break;
				case "Gamma The Magnet Warrior" : gui.setGrraveyardActive(GammaTheMagnetWarrior);break;
				case "Celtic Guardian" : gui.setGrraveyardActive(CelticGuardian);break;
				case "Alpha The Magnet Warrior" : gui.setGrraveyardActive(AlphaTheMagnetWarrior);break;
				case "Harpie Lady" : gui.setGrraveyardActive(HarpieLady);break;
				case "Big Shield Gardna" : gui.setGrraveyardActive(BigShieldGardna);break;
				case "Witty Phantom" :gui.setGrraveyardActive(WittyPhantom);break;
				case "Baby Dragon" : gui.setGrraveyardActive(BabyDragon);break;
				case "Cyber Jar" :gui.setGrraveyardActive(CyberJar);break;
				case "Clown Zombie" :gui.setGrraveyardActive(ClownZombie);break;
				case "Time Wizard" :gui.setGrraveyardActive(TimeWizard);break;
				case "Man-Eater Bug" :gui.setGrraveyardActive(ManEaterBug);break;
				case "Kuriboh" :gui.setGrraveyardActive(Kuriboh);break;
				case "Mokey Mokey" :gui.setGrraveyardActive(MokeyMokey);break;
				case "Fence Guard" :gui.setGrraveyardActive(FenceGuard);break;
				case "Fence Guard Magician" :gui.setGrraveyardActive(FenceGuardMagician);break;
				case "Fence Guard Dragon" :gui.setGrraveyardActive(FenceGuardDragon);break;
				case "Fence Guard Apprentice" :gui.setGrraveyardActive(FenceGuardApprentice);break;

				
				case "Dark Hole" :gui.setGrraveyardActive(DarkHole);break;
				case "Graceful Dice" :gui.setGrraveyardActive(GracefulDice);break;
				case "Heavy Storm" :gui.setGrraveyardActive(HeavyStorm);break;
				case "Mega Power" :gui.setGrraveyardActive(MegaPower);break;
				case "Monster Reborn" :gui.setGrraveyardActive(MonsterReborn);break;
				case "Pot of Greed" :gui.setGrraveyardActive(PotOfGreed);break;
				case "Harpie's Feather Duster" :gui.setGrraveyardActive(HarpieFeather);break;
				case "Raigeki" :gui.setGrraveyardActive(Raigeki);break;
				case "Card Destruction" : gui.setGrraveyardActive(CardDestruction);break;
				case "Change Of Heart" : gui.setGrraveyardActive(ChangeofHeart);break;
				
				
			}
		}
			if(active.getField().getGraveyard().size()!=0){
				
				Card c = active.getField().getGraveyard().get(active.getField().getGraveyard().size()-1);

				if(active.getName()==gui.getP1Name()){
					switch (c.getName()){
					case "Blue-Eyes White Dragon" : gui.setGrraveyardActive(BlueEyesWhiteDragon);break;
					case "Cosmo Queen" : gui.setGrraveyardActive(CosmoQueen);break;
					case "Dark Magician" : gui.setGrraveyardActive(DarkMagician);break;
					case "Red-Eyes Black Dragon" : gui.setGrraveyardActive(RedEyesBlackDragon);break;
					case "Gaia The Fierce Knight" : gui.setGrraveyardActive(GiaTheFierceKnight);
					case "Summoned Skull" : gui.setGrraveyardActive(SummonedSkull);break;
					//case "Fence Guard Magician" : m=new MonsterButton(FenceGuardMagician);
					case "Dark Magician Girl" : gui.setGrraveyardActive(DarkMagicianGirl);break;
					case "Curse Of Dragon" : gui.setGrraveyardActive(CurseOfDragon);break;
					//case "Fence Guard Dragon" : m=new MonsterButton(FenceGuardDragon);
					case "Alexandrite Dragon" :gui.setGrraveyardActive(AlexandriteDragon);break;
					case "Vorse Raider" :gui.setGrraveyardActive(VorseRaider);break;
					case "Gemini Elf" :gui.setGrraveyardActive(GeminiElf);break;
					//case "Fence Guard Apprentice" : m=new MonsterButton(FenceGuardApprentice);
					case "Beta The Magnet Warrior" : gui.setGrraveyardActive(BetaTheMagnetWarrior);break;
					case "Alligator Sword" : gui.setGrraveyardActive(AlligatorSword);break;
					case "Gamma The Magnet Warrior" : gui.setGrraveyardActive(GammaTheMagnetWarrior);break;
					case "Celtic Guardian" : gui.setGrraveyardActive(CelticGuardian);break;
					case "Alpha The Magnet Warrior" : gui.setGrraveyardActive(AlphaTheMagnetWarrior);break;
					case "Harpie Lady" : gui.setGrraveyardActive(HarpieLady);break;
					case "Big Shield Gardna" : gui.setGrraveyardActive(BigShieldGardna);break;
					case "Witty Phantom" :gui.setGrraveyardActive(WittyPhantom);break;
					case "Baby Dragon" : gui.setGrraveyardActive(BabyDragon);break;
					case "Cyber Jar" :gui.setGrraveyardActive(CyberJar);break;
					case "Clown Zombie" :gui.setGrraveyardActive(ClownZombie);break;
					case "Time Wizard" :gui.setGrraveyardActive(TimeWizard);break;
					case "Man-Eater Bug" :gui.setGrraveyardActive(ManEaterBug);break;
					case "Kuriboh" :gui.setGrraveyardActive(Kuriboh);break;
					case "Mokey Mokey" :gui.setGrraveyardActive(MokeyMokey);break;
					case "Fence Guard" :gui.setGrraveyardActive(FenceGuard);break;
					case "Fence Guard Magician" :gui.setGrraveyardActive(FenceGuardMagician);break;
					case "Fence Guard Dragon" :gui.setGrraveyardActive(FenceGuardDragon);break;
					case "Fence Guard Apprentice" :gui.setGrraveyardActive(FenceGuardApprentice);break;

					
					case "Dark Hole" :gui.setGrraveyardActive(DarkHole);break;
					case "Graceful Dice" :gui.setGrraveyardActive(GracefulDice);break;
					case "Heavy Storm" :gui.setGrraveyardActive(HeavyStorm);break;
					case "Mega Power" :gui.setGrraveyardActive(MegaPower);break;
					case "Monster Reborn" :gui.setGrraveyardActive(MonsterReborn);break;
					case "Pot of Greed" :gui.setGrraveyardActive(PotOfGreed);break;
					case "Harpie's Feather Duster" :gui.setGrraveyardActive(HarpieFeather);break;
					case "Raigeki" :gui.setGrraveyardActive(Raigeki);break;
					case "Card Destruction" : gui.setGrraveyardActive(CardDestruction);break;
					case "Change Of Heart" : gui.setGrraveyardActive(ChangeofHeart);break;
					}
					
				}else{

					switch (c.getName()){
					case "Blue-Eyes White Dragon" : gui.setGraveyardOpponent(BlueEyesWhiteDragon);break;
					case "Cosmo Queen" : gui.setGraveyardOpponent(CosmoQueen);break;
					case "Dark Magician" : gui.setGraveyardOpponent(DarkMagician);break;
					case "Red-Eyes Black Dragon" : gui.setGraveyardOpponent(RedEyesBlackDragon);break;
					case "Gaia The Fierce Knight" : gui.setGraveyardOpponent(GiaTheFierceKnight);
					case "Summoned Skull" : gui.setGraveyardOpponent(SummonedSkull);break;
					//case "Fence Guard Magician" : m=new MonsterButton(FenceGuardMagician);
					case "Dark Magician Girl" : gui.setGraveyardOpponent(DarkMagicianGirl);break;
					case "Curse Of Dragon" : gui.setGraveyardOpponent(CurseOfDragon);break;
					//case "Fence Guard Dragon" : m=new MonsterButton(FenceGuardDragon);
					case "Alexandrite Dragon" :gui.setGraveyardOpponent(AlexandriteDragon);break;
					case "Vorse Raider" :gui.setGraveyardOpponent(VorseRaider);break;
					case "Gemini Elf" :gui.setGraveyardOpponent(GeminiElf);break;
					//case "Fence Guard Apprentice" : m=new MonsterButton(FenceGuardApprentice);
					case "Beta The Magnet Warrior" : gui.setGraveyardOpponent(BetaTheMagnetWarrior);break;
					case "Alligator Sword" : gui.setGraveyardOpponent(AlligatorSword);break;
					case "Gamma The Magnet Warrior" : gui.setGraveyardOpponent(GammaTheMagnetWarrior);break;
					case "Celtic Guardian" : gui.setGraveyardOpponent(CelticGuardian);break;
					case "Alpha The Magnet Warrior" : gui.setGraveyardOpponent(AlphaTheMagnetWarrior);break;
					case "Harpie Lady" : gui.setGraveyardOpponent(HarpieLady);break;
					case "Big Shield Gardna" : gui.setGraveyardOpponent(BigShieldGardna);break;
					case "Witty Phantom" :gui.setGraveyardOpponent(WittyPhantom);break;
					case "Baby Dragon" : gui.setGraveyardOpponent(BabyDragon);break;
					case "Cyber Jar" :gui.setGraveyardOpponent(CyberJar);break;
					case "Clown Zombie" :gui.setGraveyardOpponent(ClownZombie);break;
					case "Time Wizard" :gui.setGraveyardOpponent(TimeWizard);break;
					case "Man-Eater Bug" :gui.setGraveyardOpponent(ManEaterBug);break;
					case "Kuriboh" :gui.setGraveyardOpponent(Kuriboh);break;
					case "Mokey Mokey" :gui.setGraveyardOpponent(MokeyMokey);break;
					case "Fence Guard" :gui.setGraveyardOpponent(FenceGuard);break;
					case "Fence Guard Magician" :gui.setGraveyardOpponent(FenceGuardMagician);break;
					case "Fence Guard Dragon" :gui.setGraveyardOpponent(FenceGuardDragon);break;
					case "Fence Guard Apprentice" :gui.setGraveyardOpponent(FenceGuardApprentice);break;

					
//					case "Dark Hole" :gui.setGraveyardOpponent(DarkHole);break;
//					case "Graceful Dice" :gui.setGraveyardOpponent(GracefulDice);break;
//					case "Heavy Storm" :gui.setGraveyardOpponent(HeavyStorm);break;
//					case "Mega Power" :gui.setGraveyardOpponent(MegaPower);break;
//					case "Monster Reborn" :gui.setGraveyardOpponent(MonsterReborn);break;
//					case "Pot of Greed" :gui.setGraveyardOpponent(PotOfGreed);break;
//					case "Harpie's Feather Duster" :gui.setGraveyardOpponent(HarpieFeather);break;
//					case "Raigeki" :gui.setGraveyardOpponent(Raigeki);break;
//					case "Card Destruction" : gui.setGraveyardOpponent(CardDestruction);break;
//					case "Change Of Heart" : gui.setGraveyardOpponent(ChangeofHeart);break;
					}
					
				}
				
				
				gui.getGraveyardActive().setVisible(true);
				gui.getGraveyardOpponent().setVisible(true);
				gui.getGraveyardActive().validate();
				gui.getGraveyardOpponent().validate();
				
			}
			
			
			
			if(board.getOpponentPlayer().getLifePoints()<=0||board.getActivePlayer().getLifePoints()<=0){
				JOptionPane.showMessageDialog(null, "Game is over , "+board.getWinner().getName() +" won");	
				}
		}
		
		
		
		if(gui.getP1Name()==active.getName()){
			int oldPointsActive = Integer.parseInt(gui.getActiveNumber().getText());
			int oldPointsOpponent = Integer.parseInt(gui.getOpponentNumber().getText());
			//gui.setActiveNumber(active.getLifePoints()+"");
			//gui.setOpponentNumber(opponent.getLifePoints()+"");
			if(oldPointsActive>active.getLifePoints()){
			//	lifePointsAudio.play();

				int ratio = (oldPointsActive-active.getLifePoints())/10;
				firstThread f = new firstThread(oldPointsActive-=ratio,oldPointsOpponent,gui,1000);
				Thread t = new Thread(f);
				t.start();
				firstThread f1 = new firstThread(oldPointsActive-=ratio,oldPointsOpponent,gui,1200);
				Thread t1 = new Thread(f1);
				t1.start();
				firstThread f2 = new firstThread(oldPointsActive-=ratio,oldPointsOpponent,gui,1300);
				Thread t2 = new Thread(f2);
				t2.start();
				firstThread f3 = new firstThread(oldPointsActive-=ratio,oldPointsOpponent,gui,1400);
				Thread t3 = new Thread(f3);
				t3.start();
				firstThread f4 = new firstThread(oldPointsActive-=ratio,oldPointsOpponent,gui,1500);
				Thread t4 = new Thread(f4);
				t4.start();
				firstThread f5 = new firstThread(oldPointsActive-=ratio,oldPointsOpponent,gui,1600);
				Thread t5 = new Thread(f5);
				t5.start();
				firstThread f6 = new firstThread(oldPointsActive-=ratio,oldPointsOpponent,gui,1700);
				Thread t6 = new Thread(f6);
				t6.start();
				firstThread f7 = new firstThread(oldPointsActive-=ratio,oldPointsOpponent,gui,1900);
				Thread t7 = new Thread(f7);
				t7.start();
				firstThread f8 = new firstThread(oldPointsActive-=ratio,oldPointsOpponent,gui,2100);
				Thread t8 = new Thread(f8);
				t8.start();
				firstThread f9 = new firstThread(oldPointsActive-=ratio,oldPointsOpponent,gui,2500);
				Thread t9 = new Thread(f9);
				t9.start();
				firstThread f10 = new firstThread(active.getLifePoints(),opponent.getLifePoints(),gui,3000);
				Thread t10 = new Thread(f10);
				t10.start();
			}
			if(oldPointsOpponent>opponent.getLifePoints()){
		//		lifePointsAudio.play();
				int ratio = (oldPointsOpponent-opponent.getLifePoints())/10;
				firstThread f = new firstThread(oldPointsActive,oldPointsOpponent-=ratio,gui,1000);
				Thread t = new Thread(f);
				t.start();
				firstThread f1 = new firstThread(oldPointsActive,oldPointsOpponent-=ratio,gui,1200);
				Thread t1 = new Thread(f1);
				t1.start();
				firstThread f2 = new firstThread(oldPointsActive,oldPointsOpponent-=ratio,gui,1300);
				Thread t2 = new Thread(f2);
				t2.start();
				firstThread f3 = new firstThread(oldPointsActive,oldPointsOpponent-=ratio,gui,1400);
				Thread t3 = new Thread(f3);
				t3.start();
				firstThread f4 = new firstThread(oldPointsActive,oldPointsOpponent-=ratio,gui,1500);
				Thread t4 = new Thread(f4);
				t4.start();
				firstThread f5 = new firstThread(oldPointsActive,oldPointsOpponent-=ratio,gui,1600);
				Thread t5 = new Thread(f5);
				t5.start();
				firstThread f6 = new firstThread(oldPointsActive,oldPointsOpponent-=ratio,gui,1700);
				Thread t6 = new Thread(f6);
				t6.start();
				firstThread f7 = new firstThread(oldPointsActive,oldPointsOpponent-=ratio,gui,1900);
				Thread t7 = new Thread(f7);
				t7.start();
				firstThread f8= new firstThread(oldPointsActive,oldPointsOpponent-=ratio,gui,2100);
				Thread t8 = new Thread(f8);
				t8.start();
				firstThread f9 = new firstThread(oldPointsActive,oldPointsOpponent-=ratio,gui,2500);
				Thread t9 = new Thread(f9);
				t9.start();
				firstThread f10 = new firstThread(active.getLifePoints(),opponent.getLifePoints(),gui,3000);
				Thread t10 = new Thread(f10);
				t10.start();
			}
		}
		
		else{
			//gui.setActiveNumber(opponent.getLifePoints()+"");
			//gui.setOpponentNumber(active.getLifePoints()+"");
			int oldPointsActive = Integer.parseInt(gui.getOpponentNumber().getText());
			int oldPointsOpponent = Integer.parseInt(gui.getActiveNumber().getText());
		
			
			
			if(oldPointsActive>active.getLifePoints()){
			//	lifePointsAudio.play();
				int ratio = (oldPointsActive-active.getLifePoints())/10;
				firstThread f = new firstThread(oldPointsOpponent,oldPointsActive-=ratio,gui,1000);
				Thread t = new Thread(f);
				t.start();
				firstThread f1 = new firstThread(oldPointsOpponent,oldPointsActive-=ratio,gui,1200);
				Thread t1 = new Thread(f1);
				t1.start();
				firstThread f2 = new firstThread(oldPointsOpponent,oldPointsActive-=ratio,gui,1300);
				Thread t2 = new Thread(f2);
				t2.start();
				firstThread f3 = new firstThread(oldPointsOpponent,oldPointsActive-=ratio,gui,1400);
				Thread t3 = new Thread(f3);
				t3.start();
				firstThread f4 = new firstThread(oldPointsOpponent,oldPointsActive-=ratio,gui,1500);
				Thread t4 = new Thread(f4);
				t4.start();
				firstThread f5 = new firstThread(oldPointsOpponent,oldPointsActive-=ratio,gui,1600);
				Thread t5 = new Thread(f5);
				t5.start();
				firstThread f6 = new firstThread(oldPointsOpponent,oldPointsActive-=ratio,gui,1700);
				Thread t6 = new Thread(f6);
				t6.start();
				firstThread f7 = new firstThread(oldPointsOpponent,oldPointsActive-=ratio,gui,1900);
				Thread t7 = new Thread(f7);
				t7.start();
				firstThread f8 = new firstThread(oldPointsOpponent,oldPointsActive-=ratio,gui,2100);
				Thread t8 = new Thread(f8);
				t8.start();
				firstThread f9 = new firstThread(oldPointsOpponent,oldPointsActive-=ratio,gui,2500);
				Thread t9 = new Thread(f9);
				t9.start();
				firstThread f10 = new firstThread(opponent.getLifePoints(),active.getLifePoints(),gui,3000);
				Thread t10 = new Thread(f10);
				t10.start();
			}
			if(oldPointsOpponent>opponent.getLifePoints()){
	//			lifePointsAudio.play();
				int ratio = (oldPointsOpponent-opponent.getLifePoints())/10;
				firstThread f = new firstThread(oldPointsOpponent-=ratio,oldPointsActive,gui,1000);
				Thread t = new Thread(f);
				t.start();
				firstThread f1 = new firstThread(oldPointsOpponent-=ratio,oldPointsActive,gui,1200);
				Thread t1 = new Thread(f1);
				t1.start();
				firstThread f2 = new firstThread(oldPointsOpponent-=ratio,oldPointsActive,gui,1300);
				Thread t2 = new Thread(f2);
				t2.start();
				firstThread f3 = new firstThread(oldPointsOpponent-=ratio,oldPointsActive,gui,1400);
				Thread t3 = new Thread(f3);
				t3.start();
				firstThread f4 = new firstThread(oldPointsOpponent-=ratio,oldPointsActive,gui,1500);
				Thread t4 = new Thread(f4);
				t4.start();
				firstThread f5 = new firstThread(oldPointsOpponent-=ratio,oldPointsActive,gui,1600);
				Thread t5 = new Thread(f5);
				t5.start();
				firstThread f6 = new firstThread(oldPointsOpponent-=ratio,oldPointsActive,gui,1700);
				Thread t6 = new Thread(f6);
				t6.start();
				firstThread f7 = new firstThread(oldPointsOpponent-=ratio,oldPointsActive,gui,1800);
				Thread t7 = new Thread(f7);
				t7.start();
				firstThread f8= new firstThread(oldPointsOpponent-=ratio,oldPointsActive,gui,2000);
				Thread t8 = new Thread(f8);
				t8.start();
				firstThread f9 = new firstThread(oldPointsOpponent-=ratio,oldPointsActive,gui,2500);
				Thread t9 = new Thread(f9);
				t9.start();
				firstThread f10 = new firstThread(opponent.getLifePoints(),active.getLifePoints(),gui,3000);
				Thread t10 = new Thread(f10);
				t10.start();
			}
		}
		//gui.setCurrentPhase(active.getField().getPhase()+"");
		gui.getAc().repaint();
		gui.getOp().repaint();
		gui.validate();
		gui.getAc().getSpellsAndMonstersPanel().getSpellsPanel().repaint();
		gui.getAc().getSpellsAndMonstersPanel().getMonstersPanel().repaint();
		gui.getOp().getSpellsAndMonstersPanel().getSpellsPanel().repaint();
		gui.getOp().getSpellsAndMonstersPanel().getMonstersPanel().repaint();
		gui.getAc().getHandPanel().repaint();
		gui.getOp().getHandPanel().repaint();
		gui.getGraveyardActive().repaint();
		gui.getGraveyardOpponent().repaint();
		gui.getGraveyardActive().validate();
		gui.getGraveyardOpponent().validate();
		
		
		
		String[] options2 = {"Play again","exit"};
		if(board.getWinner()!=null){
			int k = JOptionPane.showOptionDialog(null, board.getWinner().getName()+" Won this game","Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options2,options2[0]);
			if(k==0){
				try {
					new InputInterface();
					gui.dispose();

					return;
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			gui.dispose();
			return;
		}
		}catch(WrongPhaseException e){
			ShowMessageThread cd1 = new ShowMessageThread(gui,"You can attack only in the battle phase",active);
			Thread d1= new Thread(cd1);
			d1.start();
		}catch(MonsterMultipleAttackException e1){
			ShowMessageThread cd1 = new ShowMessageThread(gui,"A monster can attack only one time per turn",active);
			Thread d1= new Thread(cd1);
			d1.start();
			//JOptionPane.showMessageDialog(null,"A monster can attack only one time per turn");
		}catch(DefenseMonsterAttackException e2){
			ShowMessageThread cd1 = new ShowMessageThread(gui,"A monster can not attack in defense mode",active);
			Thread d1= new Thread(cd1);
			d1.start();
			//JOptionPane.showMessageDialog(null,"A monster can not attack in defense mode");
		}catch(NoSpellSpaceException e){
			ShowMessageThread cd1 = new ShowMessageThread(gui,"No spell space",active);
			Thread d1= new Thread(cd1);
			d1.start();
		}catch(NoMonsterSpaceException e3){
			ShowMessageThread cd1 = new ShowMessageThread(gui,"No monster",active);
			Thread d1= new Thread(cd1);
			d1.start();
		}catch(MultipleMonsterAdditionException e4){
			ShowMessageThread cd1 = new ShowMessageThread(gui,"You can't add to monsters in the same turn",active);
			Thread d1= new Thread(cd1);
			d1.start();
		}
	}
	public void setActionListeners(){
		PlayerPanel activeG = gui.getAc();
		PlayerPanel opponentG = gui.getOp();
		SpellsAndMonstersPanel opponentMonSpel = opponentG.getSpellsAndMonstersPanel();
		SpellsAndMonstersPanel activeMonSpel = activeG.getSpellsAndMonstersPanel();
		HandPanel activeHand = activeG.getHandPanel();
		HandPanel opponentHand = opponentG.getHandPanel();
		ArrayList<HandButton> acHand = activeHand.getHandButtons();
		ArrayList<HandButton> opHand = opponentHand.getHandButtons();
		ArrayList<SpellButton> acSpells = activeMonSpel.getSpellButtons();
		ArrayList<SpellButton> opSpells = opponentMonSpel.getSpellButtons();
		ArrayList<MonsterButton> acMons = activeMonSpel.getMonsterButtons();
		ArrayList<MonsterButton> opMons = opponentMonSpel.getMonsterButtons();

		gui.getEndPhase().addActionListener(this);
		gui.getEndTurn().addActionListener(this);
		for (HandButton handButton : acHand) {
			handButton.addActionListener(this);
			handButton.addMouseListener(this);
		}for (HandButton handButton : opHand) {
			handButton.addActionListener(this);
			handButton.addMouseListener(this);

		}for (MonsterButton handButton : acMons) {
			handButton.addActionListener(this);
			handButton.addMouseListener(this);

		}for (MonsterButton handButton : opMons) {
			handButton.addActionListener(this);
			handButton.addMouseListener(this);

		}for (SpellButton handButton : acSpells) {
			handButton.addActionListener(this);
			handButton.addMouseListener(this);

		}for (SpellButton handButton : opSpells) {
			handButton.addActionListener(this);
			handButton.addMouseListener(this);
		}

	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
	
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		if(e.getSource() instanceof MonsterButton){
		//	Point x =e.getLocationOnScreen();
			if(gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().contains(e.getSource())){
				int index = gui.getAc().getSpellsAndMonstersPanel().getMonsterButtons().indexOf(e.getSource());
				gui.setTheInfoBig(active.getField().getMonstersArea().get(index));
			}else{
				int index = gui.getOp().getSpellsAndMonstersPanel().getMonsterButtons().indexOf(e.getSource());
				if(opponent.getField().getMonstersArea().get(index).getMode()==Mode.ATTACK)
				gui.setTheInfoBig(opponent.getField().getMonstersArea().get(index));
			}
		}else
		if(e.getSource() instanceof SpellButton){
			if(gui.getAc().getSpellsAndMonstersPanel().getSpellButtons().contains(e.getSource())){
				int index = gui.getAc().getSpellsAndMonstersPanel().getSpellButtons().indexOf(e.getSource());
				System.out.println(index);
				gui.setTheInfoBig(active.getField().getSpellArea().get(index));
		}

		}else{
			if(e.getSource() instanceof HandButton){
				int index = gui.getAc().getHandPanel().getHandButtons().indexOf(e.getSource());
				gui.setTheInfoBig(active.getField().getHand().get(index));
			
			}
		}
		if(e.getSource() instanceof GraveyardButton){
				if(e.getSource()==gui.getGraveyardActive()){
			if(gui.getP1Name()==active.getName()){
				if(active.getField().getGraveyard().size()!=0)
				gui.setTheInfoBig(active.getField().getGraveyard().get(active.getField().getGraveyard().size()-1));
			}else{
				if(opponent.getField().getGraveyard().size()!=0)
				gui.setTheInfoBig(opponent.getField().getGraveyard().get(opponent.getField().getGraveyard().size()-1));
			}
				}else{
					if(gui.getP1Name()!=active.getName()){
						if(active.getField().getGraveyard().size()!=0)
						gui.setTheInfoBig(active.getField().getGraveyard().get(active.getField().getGraveyard().size()-1));
					}else{
						if(opponent.getField().getGraveyard().size()!=0)
						gui.setTheInfoBig(opponent.getField().getGraveyard().get(opponent.getField().getGraveyard().size()-1));
					}
				}
		}
	}
	public void mouseExited(MouseEvent e) {
		gui.resetTheInfoBig();
		
	}
}