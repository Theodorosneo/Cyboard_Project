
public class Board {

	private  Cell board[][]; 
	
	public Board(int size) { // Creates a size X size board of cells initialised as Empty.
	    board=new Cell[size][size];
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++) {
				board[i][j]=new Cell();
			}
	}
	
	public int getSize() { // gives the size of the board.
		return board.length;
	}
	
	public char getCell(Position p) { // Gives the pawn type of the cell at position p.
		return board[p.getRow()][p.getCollumn()].getPawn();
	}
	
	public boolean isEmpty(Position p) { // Returns if the cell at position p is empty.
		return (board[p.getRow()][p.getCollumn()].isEmpty());
	}
	
	public void setCell(Position p, char pawnType) {  // Sets the cell at p with the provided pawn type.
		board[p.getRow()][p.getCollumn()].setPawn(pawnType);
	}
	
	public void moveSquare(Position a,Position b) {  // If the cell at b is Empty, then sets the cell to the pawn type of the pawn at position a.
		if(board[b.getRow()][b.getCollumn()].isEmpty()) {
			board[b.getRow()][b.getCollumn()].setPawn(board[a.getRow()][a.getCollumn()].getPawn());
			board[a.getRow()][a.getCollumn()].setPawn('E');
		}
	}
	
	public String toString() { // Prints the board as a String variable.
		String st="";  // Empty String to start with.
		String divider=""; // Empty String to start with.
		for(int i=0;i<4*board.length+1;i++) {  // Creates the horizontal lines of the board.
			divider+="-";
		}
		divider+="\n";  // Switches line at the end of the divider.
		st+=divider;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if((board[i][j].isEmpty())) {  // If Empty, then prints nothing in that exact position on the board.
					st+="|   ";
				}
				else {
				st+="| "+board[i][j].toString()+" "	;  // If not Empty, prints the pawn type of the cell.
				}
			}	
		st+="|\n"; //Switches line.
		st+=divider;
		}
		return st; 
	}
	
	public boolean winningState() {
		boolean win_rows=true;  //Initialised variable.
		boolean win_collumns=true;  //Initialised variable.
		for(int i=0; i<board.length; i++) {
			win_collumns=true;  // Sets the boolean variable to true after each collumn check.
			for(int j=1; j<board.length; j++) 
			    if(board[i][0].getPawn()!=board[i][j].getPawn() || board[i][0].isEmpty()) {
			    	win_collumns=false;  // if one of the cells in the column we are working on is not the same type as the first cell of the column 
			    	break; // then we do not have a winning state in that exact column. If the first cell is Empty then, again, we do not have a winning state. 
			    }
			if(win_collumns) { // If we check a column and the boolean variable is, still, true then we have a winning state.
				return true;
			}
	    }
		for(int i=0; i<board.length; i++) { // Same as columns but for rows.
			win_rows=true;
			for(int j=1; j<board.length; j++)
			    if(board[0][i].getPawn()!=board[j][i].getPawn() || board[0][i].isEmpty()) {
			    	win_rows=false;
			    	break;
			    }
			if(win_rows)
				return true;
			
	    }
		return false; // If the check is over and the program did not return true then that means we do not have a winning state and returns false.
	}
	}


