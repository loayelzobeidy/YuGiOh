package eg.edu.guc.yugioh.listeners;
import javax.swing.JOptionPane;
public class getNames {
	private String nameFirstPlayer;
	private String nameSecondPlayer;
	public String getNameFirstPlayer() {
		return nameFirstPlayer;
	}
	public void setNameFirstPlayer(String nameFirstPlayer) {
		this.nameFirstPlayer = nameFirstPlayer;
	}
	public String getNameSecondPlayer() {
		return nameSecondPlayer;
	}
	public void setNameSecondPlayer(String nameSecondPlayer) {
		this.nameSecondPlayer = nameSecondPlayer;
	}
	public getNames(){
		nameFirstPlayer = JOptionPane.showInputDialog("Please enter the first player name");
		nameSecondPlayer = JOptionPane.showInputDialog("Please enter the second player name");
	}
}
