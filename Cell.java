
public class Cell {

	private char pawnType;
	
	
	public Cell() {  // Default constructor. Sets cell to Empty.
		pawnType='E';
	}
	
	public void setPawn(char p) {  // Sets cell to the provided pawn type.
		pawnType=p;
	}
	
	public char getPawn() {  // Returns the pawn type of the the cell object.
		return pawnType;
	}
	
	public boolean isEmpty() {  // Returns true if the cell's pawn type is Empty (E).
		return pawnType=='E';
	}
	
	public String toString() {  //Returns the pawn type of the cell in String.
		return pawnType+"";
	}
}
