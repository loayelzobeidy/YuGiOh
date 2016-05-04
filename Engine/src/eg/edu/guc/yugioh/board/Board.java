package eg.edu.guc.yugioh.board;

import java.io.IOException;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;

public class Board {

	private Player activePlayer;
	private Player opponentPlayer;
	private Player winner;
	
	public Player getActivePlayer() {
		return activePlayer;
	}
	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}
	public Player getOpponentPlayer() {
		return opponentPlayer;
	}
	public void setOpponentPlayer(Player opponentPlayer) {
		this.opponentPlayer = opponentPlayer;
	}
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player playerWinner) {
	this.winner = playerWinner;
	
	}
	public Board(){
		Card.setBoard(this);
	}
	public void whoStarts(Player p1, Player p2){
		int i = (int)(2*Math.random());
		if(i==0){
			this.setActivePlayer(p1);
			this.setOpponentPlayer(p2);
		}else{
			this.setActivePlayer(p2);
			this.setOpponentPlayer(p1);
		}
	}
	 public void startGame(Player p1, Player p2){
		 
		 for(int i=0;i<5;i++){
			p1.getField().addCardToHand();
			p2.getField().addCardToHand();
		 }
		whoStarts(p1,p2);	
		this.activePlayer.getField().addCardToHand();
	 }
	 public void nextPlayer(){
		Player temp = this.activePlayer;
		this.activePlayer = this.opponentPlayer;
		this.opponentPlayer = temp;
		if(this.activePlayer.getField().getDeck().getDeck().isEmpty()){
			this.setWinner(opponentPlayer);
		}
		this.activePlayer.getField().setPhase(Phase.MAIN1);
		this.activePlayer.getField().addCardToHand();
	 }
	 public static void main(String[] args) throws Exception, IOException {
		 Board board = new Board();
			Player p1 = new Player("Yugi");
			Player p2 = new Player("Kaiba");
			board.startGame(p1, p2);

	}
}
