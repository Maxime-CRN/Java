package gameBoardComponents;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import cells.Cell;
import graphicCells.*;
import rider.Rider;

/**
 * @author Quentin et Maxime
 * 
 * Panel for print game board
 *
 */
public class GGameBoard extends JPanel {
	
	private static final long serialVersionUID = 2848734522806703906L;
	
	private List<GCell> cellsOfGBoard; //List of graphic cells
	private List<Cell> model; //List of cells;
	private List<Rider> riders; //List of riders

	private int lSize; //number of cell in 1 line
	private int midBoard; // Middle of Game board to know were set "dé" and his value
	
	private char onCell; //for communicate if there is 1, 2 or 0 player on the cell
	
	private int winHeight; //Height of panel
	private int winWidth; //Width of panel
	
	public static int sizeCell = 50; //use it to give same size to all cells of the board
	
	
	public GGameBoard(List<Cell> model,List<Rider> riders) {
		this.model = model; //take model of console version
		this.riders = riders; //take riders for knows their positions
		this.lSize = (model.size()-1)/7; //take size-1/7 for have cells number of 1 line
		this.midBoard = (model.size()%2 == 0)? (model.size()-1)/2: model.size()/2;
		
		this.cellsOfGBoard = new ArrayList<GCell>(); //used to save all cells of graphic board
		
		this.winWidth= this.lSize*sizeCell;
		this.winHeight = 7*sizeCell;
		
		//set size of gameBoard
		this.setPreferredSize(new Dimension(winWidth,winHeight));

		//Create a grid with size of console board
		this.setLayout(new GridLayout(7,this.lSize));
		
		//add color and symbol for each cells of game board grid
		for(int i = 0; i<model.size()-1 ; ++i) {
			
			//Set value of onCell for each cells
			//If there is two rider on cell set value on 'A'
			if(this.riders.get(0).get_pos()==i && this.riders.get(1).get_pos()==i) {
				onCell = 'A';
			}
			//If there is only red rider on cell set value on 'R'
			else if(this.riders.get(0).get_pos()==i) {
				onCell = 'R';
			}
			//If there is only blue rider on cell set value on 'B'
			else if(this.riders.get(1).get_pos()==i) {
				onCell = 'B';
			}
			//If there is no rider on cell set value on 'N'
			else {
				onCell = 'N';
			}
			
			
			//If cell is a CellSide
			if(this.model.get(i).getClass().getSimpleName().equals("CellSide")) {
				this.cellsOfGBoard.add(new GCellSide(onCell));
			}
			//If cell is a CellFree
			else if(this.model.get(i).getClass().getSimpleName().equals("CellFree")) {
				this.cellsOfGBoard.add(new GCellFree(onCell));
			}
			//If cell is a CellStart
			else if(this.model.get(i).getClass().getSimpleName().equals("CellStart")) {
				this.cellsOfGBoard.add(new GCellStart(onCell));
			}
			//If cell is a CellEnd
			else if(this.model.get(i).getClass().getSimpleName().equals("CellEnd")) {
				this.cellsOfGBoard.add(new GCellEnd(onCell));
			}
			//If cell is a CellHole
			else if(this.model.get(i).getClass().getSimpleName().equals("CellHole")) {
				this.cellsOfGBoard.add(new GCellHole(onCell));
			}
			//If cell is a CellHedge
			else if(this.model.get(i).getClass().getSimpleName().equals("CellHedge")) {
				this.cellsOfGBoard.add(new GCellHedge(onCell));
			}
			//If cell is a CellRiver
			else if(this.model.get(i).getClass().getSimpleName().equals("CellRiver")) {
				this.cellsOfGBoard.add(new GCellRiver(onCell));
			}
			//Else set on CellWhite
			else {
				if(i == this.midBoard-1) {
					this.cellsOfGBoard.add(new GCellWhite("dé"));
				}
				else {
					this.cellsOfGBoard.add(new GCellWhite(onCell));
				}
			}
			
			//add to JPanel
			this.add(cellsOfGBoard.get(i));
		}
		
	}
	

	/**
	 * 
	 * Update Graphic game board
	 * 
	 * @param model cell list of board
	 * @param riders rider list
	 */
	public void updateBoard(List<Cell> model,List<Rider> riders) {
		this.model = model; //take model of console version
		this.riders = riders; //take riders for knows their positions
		
		for(int i = 0; i<model.size()-1 ; ++i) {
			
			
			
			//Set value of onCell for each cells
			//If there is two rider on cell set value on 'A'
			if(this.riders.get(0).get_pos()==i && this.riders.get(1).get_pos()==i) {
				onCell = 'A';
			}
			//If there is only red rider on cell set value on 'R'
			else if(this.riders.get(0).get_pos()==i) {
				onCell = 'R';
			}
			//If there is only blue rider on cell set value on 'B'
			else if(this.riders.get(1).get_pos()==i) {
				onCell = 'B';
			}
			//If there is no rider on cell set value on 'N'
			else {
				onCell = 'N';
			}
			
			//update text in cells
			
			//here update players position
			if(i != this.midBoard-1 && i != this.midBoard) {
				cellsOfGBoard.get(i).setText(onCell);
			}
			
		}
	}
	
	/**
	 * Update dice value on the board
	 * 
	 * @param nbDice dice value
	 */
	public void updateDice(int nbDice) {
		cellsOfGBoard.get(midBoard).setText(nbDice);
	}
	
	public int getHeight() {
		return winHeight;
	}


	public int getWidth() {
		return winWidth;
	}


	public JPanel getBoard() {
		return this;
	}


}
