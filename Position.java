
public class Position {

	private int row;
	private int collumn;
	
	public Position(int x,int y) { // Position constructor. 
		row=x;
		collumn=y;
	}
	
	public int getRow() {  // Returns the row of the position object.
		return row;
	}
	
	public int getCollumn() {  // Returns the column of the position object.
		return collumn;
	}
	
	public String toString() {  // Returns the row and column of the position object in String.
		return "("+row+", "+collumn+")";
	}
	
}
