/**
 * Describes a position on a chessboard by means of a row number and a
 * column number, both in interval [1..8].
 */
public class Position {
    private int row;
    private int col;

    /**
     * Default position is [1][1]
     */ 
    Position() {
	row=1;
	col=1;
    }

    /**
     * Builds a position with <i>row</i> as the row number and
     * <i>col</i> as the column number. The column and row number are not
     * verified to be in interval [1..8]. This verification is devoted to
     * method <i>isValid()</i>.
     * @param row the row number of the position
     * @param col the col number of the position
    */
    Position(int row, int col) {
	this.row=row;
	this.col=col;
    }

    /** 
     * @return the row number of the position 
     */
    public int getRow() { 
	return row;
    }

    /** 
     * @return the column number of the position 
     */
    public int getCol() { 
	return col;
    }

    /** 
     * Checks that both the column and row number of the position are
     * in interval [1..8].
     * @return true if both the column and row number of the position are
     * in interval [1..8], false otherwise
    */
    public boolean isValid() {
	return (1 <= row && row <= 8 && 1 <= col && col <= 8);
    }

    /** Tests if position <i>this</i> equals position <i>that</i>.
     * @return true if <i>this</i> and <i>that</i> have the same row
     * number and the same column number, false otherwise.
    */
    public boolean equals(Position that) {
	return this.row == that.row && this.col == that.col;
    }

    /**
     * Builds a String representation of a position as the row number
     * enclosed in square brackets, followed be the column number
     * enclosed in square brackets. 
     * @return the String representation of the position.
     */
    public String toString() {
	return "["+row+"]["+col+"]";
    }
}