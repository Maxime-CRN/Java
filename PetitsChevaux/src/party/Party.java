package party;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import board.Board;
import controller.Controller;
import dice.Dice;
import windows.SetupWindow;

/**
 * @author Quentin et Maxime
 *
 */
public class Party {
	private Board gboard; //game gboard
	
	private Controller gMode; //Controller of game, it used to launch graphic game 
	private int level; //number of cell per line
	
	private Dice dice; //dice for game
	
	private int turn; //current turn
	
	
	private String input; //buff data input, it's for add an interaction with user
	private BufferedReader rdConsole; //for read in console
	private File backupParty; //file for save each turn
	private BufferedWriter BuffWriter; //for write in file
	
	
	/**
	 * @param level level of game
	 * @throws IOException 
	 */
	public Party(int level) throws IOException{
		while(true){
			turn = 1;
			dice = new Dice();
			//init and create/re-create a file named BackupParty.txt
			backupParty =new File("BackupParty.txt");
			backupParty.createNewFile();
					
			//init a writer who write in BackupParty.txt
			BuffWriter = new BufferedWriter(new FileWriter("BackupParty.txt"));
			
			if(level>4) {
				//launch windows to choose difficulty
				SetupWindow setupGame = new SetupWindow();
				
				//get value of difficulty chosen
				this.level  = setupGame.getDifficulty();
				
				//Create the board
				gboard = new Board(this.level);
				
				//launch game
				playGraphic();
								
				//wait player click on restart
				while(! gMode.getRestart()) {
					System.out.print("");
				}
				
			}
			else {
				//set and play console game
				this.level = level;
				gboard = new Board(level);
				dice = new Dice();
				turn = 1;
				input = null;
				//Create a reader for read in console
				rdConsole= new BufferedReader(new InputStreamReader(System.in));
				
				playConsole();
			}
		}
	}
	
	
	
	/**
	 * Play a party in console mode
	 * 
	 * @throws IOException 
	 */
	private void playConsole() throws IOException{

		//While no one has won
		while(!gboard.getChevals().get(0).isWin() && !gboard.getChevals().get(0).isWin()) {
			
			dice.roll();
			
			//Odd turn is player turn
			if(turn%2==1) {
				//Asks the player to press enter for continue
				System.out.println("Pressez sur \"Entrer\" pour lancer le dé");
				
				//While player don't press enter game was locked
				while(input == null) {
					input = rdConsole.readLine();
				}
				
				//Get dice value and do a move for player rider (red rider)
				gboard.move(0, dice.getValue());
				input =null;
			}
			//Even turn is auto player turn
			else {
				//Get dice value and do a move for auto player rider (blue rider)
				gboard.move(1, dice.getValue());
			}
			
			//Print turn in the console
			print_turn(turn);
			
			save_turn(turn);
			
		}
		rdConsole.close();
		BuffWriter.close();
	}
	
	
	
	
	private void playGraphic() throws IOException{
		//Create and init game window
		gMode = new Controller(gboard,0);
		
		
		//update dice value on window
		gMode.updateDicePrint(dice.getValue());
		
		//While no one has won
		while(!gboard.getChevals().get(0).isWin() && !gboard.getChevals().get(0).isWin()) {
			
			//Exit game if restart
			if(gMode.getRestart()) {
				break;
			}
			
			//update turn on window
			gMode.updateTurnPrint();
			
			dice.roll();
			
			
			//Odd turn is player turn
			if(turn%2==1) {
				
				//While player don't click or restart don't equal true game was locked
				while(!gMode.can_roll() && !gMode.getRestart()) {
					System.out.print("");
				}
				
				//Exit game if restart
				if(gMode.getRestart()) {
					break;
				}
				
				//update dice value on window
				gMode.updateDicePrint(dice.getValue());
				
				//Delays the game
				try {
			        Thread.sleep(500);
			      }catch(Exception e){}
				
				//Get dice value and do a move for player rider (red rider)
				gboard.move(0, dice.getValue());
				
			}
			//Even turn is auto player turn
			else {
				//Delays the game
				try {
			        Thread.sleep(500);
			      }catch(Exception e){}
				
				//update dice value on window
				gMode.updateDicePrint(dice.getValue());
				
				//Delays the game
				try {
			        Thread.sleep(500);
			      }catch(Exception e){}
				
				//Get dice value and do a move for player rider (red rider)
				gboard.move(1, dice.getValue());
			}
					
			//Delays the game	
			try {
		        Thread.sleep(500);
		      }catch(Exception e){}
				
			//Update window and riders positions
			gMode.updateGame(gboard, dice.getValue());
				
			//Delays the game
			try {
		        Thread.sleep(500);
		      }catch(Exception e){}
				
			
			save_turn(turn);
					
			++turn;
		}
		
		BuffWriter.close();
	}
	
	
	
	
	
	/**
	 * Print turn in the console
	 * 
	 * @param nb_turn turn number
	 */
	private void print_turn(int nb_turn) {
		System.out.println("Tour n°"+nb_turn);
		System.out.println("Le cavalier de couleur "+((nb_turn%2==1)? "ROUGE":"BLEU")+" joue");
		System.out.println("Valeur du dé : "+dice.getValue()+"\n");
		if(gboard.getTurn_rules() != "") {
			System.out.println(gboard.getTurn_rules());
		}
		System.out.println(gboard.toString());
		for(int i = 0; i< 20; ++i) {
			System.out.print("__");
		}
		System.out.println("\n"+gboard.get_rider_stat(0)+"  "+gboard.get_rider_stat(1));
		for(int i = 0; i< 20; ++i) {
			System.out.print("__");
		}
		System.out.println("\n\n");
	}
	
	/**
	 * Save board at each turn in txt file
	 * We use it for debugging
	 * 
	 * @param nb_turn turn number
	 * @throws IOException
	 */
	private void save_turn(int nb_turn)throws IOException {
		String toWrite = "Tour n°"+nb_turn+"\n";
		BuffWriter.write(toWrite, 0, toWrite.length());
		
		toWrite ="Le cavalier de couleur "+((nb_turn%2==1)? "ROUGE":"BLEU")+" joue\n";
		BuffWriter.write(toWrite, 0, toWrite.length());
		
		toWrite ="Valeur du dé : "+dice.getValue()+"\n\n";
		BuffWriter.write(toWrite, 0, toWrite.length());
		
		toWrite = gboard.toString()+"\n";
		BuffWriter.write(toWrite, 0, toWrite.length());
		
			
		toWrite="\n"+gboard.get_rider_stat(0)+"  "+gboard.get_rider_stat(1)+"\n";
		BuffWriter.write(toWrite, 0, toWrite.length());
		
		
		toWrite ="\n\n\n";
		BuffWriter.write(toWrite, 0, toWrite.length());
	}
	
}

