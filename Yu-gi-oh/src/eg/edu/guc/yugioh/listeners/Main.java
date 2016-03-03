	package eg.edu.guc.yugioh.listeners;

import java.io.IOException;

//import javax.swing.JOptionPane;
//import eg.edu.guc.yugioh.board.Board;
//import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.exceptions.EmptyFieldException;
import eg.edu.guc.yugioh.exceptions.MissingFieldException;
import eg.edu.guc.yugioh.exceptions.UnknownCardTypeException;
import eg.edu.guc.yugioh.exceptions.UnknownSpellCardException;
//import eg.edu.guc.yugioh.gui.GUI;

public class Main {
	Controller c;
	public Main(String p1,String p2) throws CloneNotSupportedException, IOException, NumberFormatException, MissingFieldException, EmptyFieldException, UnknownSpellCardException, UnknownCardTypeException{
		c = new Controller(p1,p2);
	}
	
	
}