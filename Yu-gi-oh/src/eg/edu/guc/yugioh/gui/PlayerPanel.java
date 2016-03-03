package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerPanel extends JPanel {
	private SpellsAndMonstersPanel spellsAndMonstersPanel;
	private HandPanel handPanel;
//	private JLabel label;
 //   private BufferedImage image;
    private JLabel DeckLabel;
public JLabel getDeckLabel() {
		return DeckLabel;
	}

	public void setDeckLabel(JLabel deckLabel) {
		DeckLabel = deckLabel;
	}
	public PlayerPanel (String name) {
		super();
		
		this.setOpaque(false);
		this.setName(name);
		//label = new JLabel(name+"'s FIELD");
		//this.setPreferredSize(new Dimension(980,250));
		spellsAndMonstersPanel = new SpellsAndMonstersPanel();
		handPanel = new HandPanel();
		//label.setToolTipText("Amgad Prince");

		DeckLabel = new JLabel("20");
		DeckLabel.setFont(new Font("Papyrus", Font.BOLD, 20));
		DeckLabel.setForeground(Color.RED);
		//deckButton = new DeckButton();
		this.setLayout(new BorderLayout());
		//this.add(monstersPanel,BorderLayout.CENTER);
		this.add(spellsAndMonstersPanel,BorderLayout.NORTH);
		this.add(handPanel,BorderLayout.SOUTH);

	}
	
	public SpellsAndMonstersPanel getSpellsAndMonstersPanel() {
		return spellsAndMonstersPanel;
	}

	public void setSpellsAndMonstersPanel(
			SpellsAndMonstersPanel spellsAndMonstersPanel) {
		this.spellsAndMonstersPanel = spellsAndMonstersPanel;
	}

	public HandPanel getHandPanel() {
		return handPanel;
	}
	public void setHandPanel(HandPanel handPanel) {
		this.handPanel = handPanel;
	}
}
