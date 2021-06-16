package controller;

import board.Board;
import gameBoardComponents.GBotBoard;
import gameBoardComponents.GGameBoard;
import gameBoardComponents.GTopBoard;
import windows.PlayWindow;

/**
 * @author Quentin et Maxime
 * 
 * Convert Console mode in graphic mode
 *
 */
public class Controller {
	
	private Board consolBoard; //Console Board
	
	private PlayWindow win; //window with all panel
	
	private GTopBoard tBoard; //Top panel
	private GGameBoard GameBoard; //Game board panel
	private GBotBoard bBoard; //Bottom panel
	
	private int turn; //turn
	
	private int width; //Cumulate the width of each element
	private int height; //Cumulate the height of each element
	
	
	/**
	 * @param consolBoard game board of console mode
	 * @param turn number of turn
	 */
	public Controller(Board consolBoard, int turn){
		this.turn = turn; //set turn
		this.consolBoard = consolBoard; // set board
		
		
		//Create and init game board panel
		GameBoard = new GGameBoard(this.consolBoard.getBoard(), this.consolBoard.getChevals());
		
		//Create and init top panel
		tBoard = new GTopBoard();
		
		//Create and init bot panel
		bBoard = new GBotBoard();
		
		width = GameBoard.getWidth();
		height = GameBoard.getHeight()+tBoard.getHeight();
		
		//Create window with top and game board panels
		this.win = new PlayWindow(tBoard, GameBoard, bBoard, width, height);
		win.setRestart();
	}
	
	/**
	 * Update window
	 * used for each turn
	 * 
	 * @param consolBoard = game board of console mode
	 */
	public void updateGame(Board consolBoard,int nbDice) {
		this.consolBoard = consolBoard;
		this.GameBoard.updateBoard(this.consolBoard.getBoard(), this.consolBoard.getChevals());
		this.bBoard.updateText(this.consolBoard.getR_stat(), this.consolBoard.getB_stat());
		
		width = GameBoard.getWidth();
		height = GameBoard.getHeight()+tBoard.getHeight()+bBoard.getHeight();
		
		win.UpdateWindow(width, height);
		++this.turn;
	}
	
	public void updateDicePrint(int nbDice) {
		this.GameBoard.updateDice(nbDice);
		win.UpdateWindow(width, height);
	}
	
	public void updateTurnPrint() {
		this.tBoard.printWhosTurn(turn);
		win.UpdateWindow(width, height);
	}
	
	
	//getters for listener
	////////////////////////////////////
		
	
	/**
	 * @return a boolean which indicates if the player wishes to restart the game
	 */
	public boolean getRestart() {
		//close window if player want to reset game
		if(win.getRestart()) {
			win.dispose();
		}
		return win.getRestart();
	}
	
	/**
	 * If RollButton was clicked return true and re-init value of rolling to false
	 * else return false
	 * 
	 * @return value of rolling in "RollButton" class
	 */
	public boolean can_roll() {
		if(tBoard.getRoll()== true) {
			tBoard.resetRoll();
			return true;
		}
		return tBoard.getRoll();
	}	
	
}
