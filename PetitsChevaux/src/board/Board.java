package board;
import java.util.*;

import cells.Cell;
import cells.CellEnd;
import cells.CellFree;
import cells.CellHedge;
import cells.CellHole;
import cells.CellRiver;
import cells.CellSide;
import cells.CellStart;
import cells.CellWhite;
import rider.Rider;

/**
 * @author Quentin et Maxime
 *
 */
public class Board {

	private List<Cell> board; //List of cells
	private List<Rider> chevals; //List of riders
	
	private int sLine; //Number of cells per lines
	private int nb_cell; //Number of cells in the list
	
	private int right_top; //Position of the righter top cell
	private int right_mid; //Position of the righter middle cell
	private int right_bot; //Position of the righter bottom cell
	private int left_top; //Position of the most left top cell
	private int left_mid; //Position of the most left middle cell
	private int left_bot; //Position of the most left bottom cell
	
	
	private String turn_rules; //Rules of current turn
	private String r_stat; //Current stat of red rider
	private String b_stat; //Current stat of blue rider
	
	private int traps[]; //Array with number of traps as his size and  values as positions
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
//Constructor
	
	/**
	 * @param difficulty difficulty chosen by player
	 */
	public Board(int difficulty) {
		turn_rules = "";
		r_stat ="";
		b_stat ="";
		
		//init list for riders and cells
		chevals = new ArrayList<Rider>();
		board = new ArrayList<Cell>();
		
		//uses predefined parameters depending on the difficulty chosen
		if(difficulty  == 1) {
			//easy mode
			setBoard(10,0);
		}
		else if(difficulty  == 2) {
			//normal mode
			setBoard(16,3);
		}
		else if(difficulty  == 3) {
			//hard mode
			setBoard(25,10);
		}
		else if(difficulty  == 4) {
			//nightmare mode
			setNightmareBoard(30);
		}
		else {
			
		}
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
//Setting of board
	
	/**
	 * @param sLine number of cell per line
	 * @param nbTraps number of traps in game
	 */
	public void setBoard(int sLine, int nbTraps){
		
		this.sLine = sLine+2; //Number of cells per line with CellSide
		nb_cell = 7*this.sLine; //Number of cell in the list
		int mid_space= (sLine%2 == 0)? 2:3; //Middle space calculation : if number of cells is pair -> middle_space = 4 else -> middle_space = 5
		
		right_top =(int)((nb_cell/7)*2-2);//Set position of the righter top cell
		right_mid =(int)((nb_cell/7)*4-2);//Set position of the righter middle cell
		right_bot =(int)((nb_cell/7)*6-2);//Set position of the righter middle cell
		left_top =(int)((nb_cell/7)+1);   //Set position of the righter middle cell
		left_mid =(int)((nb_cell/7)*3+1); //Set position of the most left middle cell
		left_bot =(int)((nb_cell/7)*5+1); //Set position of the most left bottom cell
		
		//set number of traps depending of difficulty chosen
		//set positions of traps in Traps array
		setTraps(nbTraps);
		
		//index to move in traps array
		int j =0;
		

		for(int i =0; i<=nb_cell; ++i) {
			
			//init red player at his stable
			if(i == 1) {
				chevals.add(new Rider(i,'R',(i+this.sLine)));
				board.add(new CellSide(i));
				r_stat = board.get(i).process(chevals.get(0));
			}
			//init blue player at his stable 
			else if(i == nb_cell-2) {
				chevals.add(new Rider(i,'B',(i-this.sLine)));
				board.add(new CellSide(i));
				b_stat = board.get(i).process(chevals.get(1));
			}
			
			//set special cells
			////////////////////////////////////////////////////////////////
			//if index is out of array
			else if(j<nbTraps && i == traps[j]) {
				//Set CellHole
				board.add(new CellHole(i));
			}
			
			//if index is out of array
			else if(j+1<nbTraps && i == traps[j+1]) {
				//Set CellRiver
				board.add(new CellRiver(i));
			}
			
			
			//if index is out of array
			else if(j+2<nbTraps && i == traps[j+2]) {
				//Set CellHedge
				board.add(new CellHedge(i));
				if(j+3 < nbTraps) {
					j +=3;
				}
			}
			
			
			///////////////////////////////////////////////////////////////
			
			
			//set start cells
			///////////////////////////////////////////////////////////////
			//set CellStart for blue player
			else if(i == right_bot) {
				board.add(new CellStart(i));
			}
			//set CellStart for red player
			else if(i ==left_top) {
				board.add(new CellStart(i));
			}
			///////////////////////////////////////////////////////////////
			
			
			//set end cells
			///////////////////////////////////////////////////////////////
			//set CellEnd of red player
			else if(i == (int)(nb_cell/2)-3) {
				board.add(new CellEnd(i));
			}
			//set CellEnd of blue player
			else if(i == (int)(nb_cell/2)+mid_space) {
				board.add(new CellEnd(i));
			}
			///////////////////////////////////////////////////////////////
			
			
			//set side cells
			///////////////////////////////////////////////////////////////
			//set CellSide of the first line
			else if(i<this.sLine) {
				board.add(new CellSide(i));
			}
			
			//set CellSide of the last line
			else if (i>=right_bot){
				board.add(new CellSide(i));
			}
			
			//set CellSide of the border of each lines
			else if( i%this.sLine == 0 || (i+1)%this.sLine == 0) {
				board.add(new CellSide(i));
			}
			///////////////////////////////////////////////////////////////
			
			
			//set white cells
			///////////////////////////////////////////////////////////////
			//set first line of CellWhite
			else if(i < left_mid-2 && i > this.sLine*2) {
				board.add(new CellWhite(i));
			}
			
			//set 4 or 5 CellWhite on center of middle line
			else if(i < (nb_cell/2)+mid_space && i >= (nb_cell/2)-2) {
				board.add(new CellWhite(i));
			}
			
			//set second line of CellWhite
			else if(i < this.sLine*5-1 && i > this.sLine*4) {
				board.add(new CellWhite(i));
			}
			///////////////////////////////////////////////////////////////
			
			
			//set free cells
			else {
				board.add(new CellFree(i));
			}
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Create a board with traps everywhere
	 * 
	 * @param sLine number of cell per line
	 * 
	 */
	public void setNightmareBoard(int sLine){
		
		this.sLine = sLine+2; //Number of cells per line with CellSide
		nb_cell = 7*this.sLine; //Number of cell in the list
		int mid_space= (sLine%2 == 0)? 2:3; //Middle space calculation : if number of cells is pair -> middle_space = 4 else -> middle_space = 5
		
		right_top =(int)((nb_cell/7)*2-2);//Set position of the righter top cell
		right_mid =(int)((nb_cell/7)*4-2);//Set position of the righter middle cell
		right_bot =(int)((nb_cell/7)*6-2);//Set position of the righter middle cell
		left_top =(int)((nb_cell/7)+1);   //Set position of the righter middle cell
		left_mid =(int)((nb_cell/7)*3+1); //Set position of the most left middle cell
		left_bot =(int)((nb_cell/7)*5+1); //Set position of the most left bottom cell
		

		for(int i =0; i<=nb_cell; ++i) {
			
			//init red player at his stable
			if(i == 1) {
				chevals.add(new Rider(i,'R',(i+this.sLine)));
				board.add(new CellSide(i));
				r_stat = board.get(i).process(chevals.get(0));
			}
			//init blue player at his stable 
			else if(i == nb_cell-2) {
				chevals.add(new Rider(i,'B',(i-this.sLine)));
				board.add(new CellSide(i));
				b_stat = board.get(i).process(chevals.get(1));
			}
			
			
			//set start cells
			///////////////////////////////////////////////////////////////
			//set CellStart for blue player
			else if(i == right_bot) {
				board.add(new CellStart(i));
			}
			//set CellStart for red player
			else if(i ==left_top) {
				board.add(new CellStart(i));
			}
			///////////////////////////////////////////////////////////////
			
			
			//set end cells
			///////////////////////////////////////////////////////////////
			//set CellEnd of red player
			else if(i == (int)(nb_cell/2)-3) {
				board.add(new CellEnd(i));
			}
			//set CellEnd of blue player
			else if(i == (int)(nb_cell/2)+mid_space) {
				board.add(new CellEnd(i));
			}
			///////////////////////////////////////////////////////////////
			
			
			//set side cells
			///////////////////////////////////////////////////////////////
			//set CellSide of the first line
			else if(i<this.sLine) {
				board.add(new CellSide(i));
			}
			
			//set CellSide of the last line
			else if (i>=right_bot){
				board.add(new CellSide(i));
			}
			
			//set CellSide of the border of each lines
			else if( i%this.sLine == 0 || (i+1)%this.sLine == 0) {
				board.add(new CellSide(i));
			}
			///////////////////////////////////////////////////////////////
			
			
			//set white cells
			///////////////////////////////////////////////////////////////
			//set first line of CellWhite
			else if(i < left_mid-2 && i > this.sLine*2) {
				board.add(new CellWhite(i));
			}
			
			//set 4 or 5 CellWhite on center of middle line
			else if(i < (nb_cell/2)+mid_space && i >= (nb_cell/2)-2) {
				board.add(new CellWhite(i));
			}
			
			//set second line of CellWhite
			else if(i < this.sLine*5-1 && i > this.sLine*4) {
				board.add(new CellWhite(i));
			}
			///////////////////////////////////////////////////////////////
			
			
			//set full traps everywhere
			else {
				int randPos = (int)(Math.random()*3);
				
				
				if(randPos == 0) {
					//Set CellHole
					board.add(new CellHole(i));
				}
				
				else if(randPos == 1) {
					//Set CellRiver
					board.add(new CellRiver(i));
				}
				
				
				else if(randPos == 2) {
					//Set CellHedge
					board.add(new CellHedge(i));
				}

			}
		}
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
	

	
	

	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
//Move management of Riders
	
	
	
	/**
	 * Make move of rider
	 * 
	 * @param rider rider number in list of it
	 * @param dice_nb number of dice
	 */
	public void move(int rider, int dice_nb) {
		int n_pos;//next position of rider
		int rider_pos = chevals.get(rider).get_pos();//rider current position
		
		
		//test if dice value can make move rider
		if (board.get(rider_pos).can_move(dice_nb,chevals.get(rider))) {
			
			//free last position of rider
			board.get(rider_pos).free_Rider();
			
			//test if rider leave from stable
			if(board.get(rider_pos).getClass().getSimpleName().equals("CellSide")) {
				//Make the rider go to his CellStart
				dice_nb =1;
			}
			
			//next position of player
			if (rider == 0) {
				n_pos = red_n_pos(rider_pos, dice_nb);
				
				
				//test there is already a rider in the cell
				if(board.get(n_pos).is_Rider()) {
					b_stat = board.get(chevals.get(1).get_cellStart()).process(chevals.get(1));
				}
				
				//add player at his new position
				r_stat = board.get(n_pos).process(chevals.get(rider));
			}
			else {
				n_pos = blue_n_pos(rider_pos, dice_nb);
				
				//test there is already a rider in the cell
				if(board.get(n_pos).is_Rider()) {
					r_stat = board.get(chevals.get(0).get_cellStart()).process(chevals.get(0));
				}
				
				//add player at his new position
				b_stat = board.get(n_pos).process(chevals.get(rider));
			}
			
			//update rider_pos to use it like the "new current position" in this function only
			rider_pos = n_pos;
		}
		
		//Set turn rules
		set_turn_rules(rider);
		
		//test if rider won the party
		if(board.get(rider_pos).getClass().getSimpleName().equals("CellEnd")) {
			chevals.get(rider).setWin(true);
			
			//free last position of rider
			board.get(rider_pos).free_Rider();
			
			if(rider == 0) {
				board.get(rider_pos+1).process(chevals.get(rider));
			}
			else {
				board.get(rider_pos-1).process(chevals.get(rider));
			}
		}
		return;
	}
	


	/**
	 * Calculating next position of red rider
	 * 
	 * @param rider_pos rider current position
	 * @param dice_nb number of the dice
	 * @return next position of red rider
	 */
	private int red_n_pos(int rider_pos,int dice_nb) {
		int j = 0;
		int n_pos = rider_pos; //next position
		int i = n_pos;
		
		//Count only Cell != CellSide to calculate valid next position of rider 
		while(j<dice_nb) {				
			
			//Set step depending of current position
			int step = (n_pos >= left_bot)? -1 :1;
			
			i+=step; //update i
			
			//Test if isn't a CellSide
			boolean good_cell = (board.get(i).getClass().getSimpleName().equals("CellSide") && board.get(n_pos).getClass().getSimpleName().equals("CellSide"))? false: true;
			
			//Test if next cell is white
			if(board.get(i).getClass().getSimpleName().equals("CellWhite")) {
				break;
			}
			
			if(good_cell) {
				//Set step and/or new position depending on current position
				if(n_pos == right_top) {
					i = right_mid;
					step = 0;
				}
				else if(n_pos == right_mid) {
					i = right_bot;
					step =-1;
				}
				else if(n_pos == left_bot) {
					i = left_mid;
					step =0;
				}
				++j;
			}
			
			n_pos =i; //update n_pos
			
		}
		return n_pos;
	}
	
	
	
	/**
	 * Calculating next position of blue rider
	 * 
	 * @param rider_pos rider current position
	 * @param dice_nb number of the dice
	 * @return next position of blue rider
	 */
	private int blue_n_pos(int rider_pos,int dice_nb) {
		int j = 0;
		int n_pos = rider_pos; //next position
		int i = n_pos;
		
		//Count only Cell != CellSide to calculate valid next position of rider 
		while(j<dice_nb) {				
			
			//Set step depending of current position
			int step = (n_pos <= right_top)? 1 :-1;
			
			i+=step; //update i
			
			//Test if isn't a CellSide
			boolean good_cell = (board.get(i).getClass().getSimpleName().equals("CellSide") && board.get(n_pos).getClass().getSimpleName().equals("CellSide"))? false: true;
			
			//Test if next cell is white
			if(board.get(i).getClass().getSimpleName().equals("CellWhite")) {
				break;
			}
			
			if(good_cell) {
				//Set new position depending on current position
				if(n_pos == left_bot) {
					i = left_mid;
					step = 0;
				}
				else if(n_pos == left_mid) {
					i = left_top;
					step = 1;
				}
				else if(n_pos == right_top) {
					i = right_mid;
					step = 0;
				}
				++j;
				
				n_pos =i; //update n_pos
			}
		}
		return n_pos;
	}
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
//Randomizer of position of traps
	
	
	/**
	 * set an array sized by nbTraps
	 * set and put in the array positions  of traps randomly generated
	 * 
	 * @param nbTraps number of traps
	 */
	private void setTraps(int nbTraps) {
		
		traps = new int[nbTraps];
		for(int i =0; i<nbTraps; ++i) {
			//set position in ascending order to avoid duplicates
			//first separated because it can't be compared to previous
			if(i == 0) {
				traps[i] = (int)(Math.random()*(right_top-left_top))+left_top+1;
			}
			
			else {
				//for each other while position of trap wasn't upper than position of previous, generate random new position
				
				//positions on first line of the board
				if(traps[i-1] < right_top) {
					while(traps[i]<=traps[i-1]) {
						traps[i] = (int)(Math.random()*(right_top-left_top))+left_top+1;
					}
				}
				
				//positions on last line of the board
				else if(traps[i-1] < right_bot-1){
					if(traps[i-1] < left_bot) {
						traps[i] = (int)(Math.random()*(right_bot-left_bot))+left_bot;
					}
					else {
						while(traps[i]<=traps[i-1]) {
							traps[i] = (int)(Math.random()*(right_bot-traps[i-1]))+traps[i-1];
						}	
					}
				}
				//if last position is end of board set all traps on it to avoid error
				else {
					traps[i] = traps[i-1];
				}
			}
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////
//Getters and setters
	
	
	/**
	 * Set rules of current turn
	 * 
	 * @param rider rider number in list of it
	 */
	public void set_turn_rules(int rider) {
		//buffer of rider position
		int r_pos = chevals.get(rider).get_pos();
		
		//if red rider
		if(rider == 0) {
			//if red rider is on blue rider CellStart
			if(r_pos == right_bot) {
				//set rules of CellFree
				turn_rules = "";
			}
			else{
				//set current cell rules
				//set name of rider if rules are more than nothing
				turn_rules = (board.get(r_pos).get_rules() =="")? "": "** Le cavalier ROUGE "+board.get(r_pos).get_rules()+" **";
			}
		}
		else {
			//if blue rider is on red rider CellStart
			if(r_pos == left_top) {
				//set rules of CellFree
				turn_rules = "";
			}
			else{
				//set current cell rules
				//set name of rider if rules are more than nothing 
				turn_rules = (board.get(r_pos).get_rules() =="")? "": "** Le cavalier BLEU "+board.get(r_pos).get_rules()+" **";
			}
		}
	}
	
	
	/**
	 * Return stat of rider
	 * 
	 * @param rider rider number in list of it
	 * @return stat of rider
	 */
	public String get_rider_stat(int rider) {
		if(rider == 0) {
			return r_stat;
		}
		else {
			return b_stat;
		}
	}
	
	
	/**
	 * @param pos Cell position
	 * @return Cell at position in parameter
	 */
	Cell getCell(int pos) {
		return board.get(pos);
	}
	
	
	/**
	 * @return state of board
	 */
	public String toString() {
		String platal = "";
		for(int i =0; i<nb_cell; ++i) {
			if((i)%sLine == 0) {
				platal = platal+"\n";
			}
			platal = platal+board.get(i).get_symbol();
		}
		return platal;
	}
	
	public List<Cell> getBoard() {
		return board;
	}


	public List<Rider> getChevals() {
		return chevals;
	}


	public int getsLine() {
		return sLine;
	}


	public String getTurn_rules() {
		return turn_rules;
	}


	public String getR_stat() {
		return r_stat;
	}


	public String getB_stat() {
		return b_stat;
	}
}
