
public class Player {

	private String playerType;
	private Board board;
	private char pawnType;
	
	public Player(String p,Board board,char pawn) { //Creates a Player object with the provided player type, board and pawn type.
		playerType=p;
		pawnType=pawn;
	    this.board=board;
	}
	
	public void setPiece() {
		System.out.println("Enter row and column to place your pawn (0-"+(board.getSize()-1)+"): ");
		boolean occupiedCell;  // Variable to check if a cell is already occupied.
		int x0=StdIn.readInt();  //Reads two integer variables and creates a position.
		int y0=StdIn.readInt();
		Position p=new Position(x0,y0);
		do{
			occupiedCell=true;
			while(x0<0||x0>board.getSize()-1||y0<0||y0>board.getSize()-1) {  // Checks if the provided integers are out of bounds and asks to be given again.
				System.out.println("Wrong coordinates! Give new coordinates!"); // Error message.
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p=new Position(x0,y0); //Creates a new position object with the new variables.
			}
			
			if(!board.isEmpty(p)) { //If the cell at the provided position is not empty, then asks to give new coordinates.
				occupiedCell=false;
				System.out.println("Occupied cell. Give new coordinates!");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
				p=new Position(x0,y0);
			}
		}while(!occupiedCell);
		board.setCell(p,this.pawnType); //If the provided variables are correct then sets the cell at the position p to the player's pawn type.
		
		
	}	
	public void movePiece() {
		boolean pos_pawntype;
		Position p1=null; 
		System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
		int x0=StdIn.readInt();
		int y0=StdIn.readInt();
	    Position p0=new Position(x0,y0);  //Creates a position object corresponding to the cell the player wants to move from.
		do {
			
			pos_pawntype=true; // Boolean variable for checking if the cell from where the player wants to move is his.
			while(x0<0||x0>board.getSize()-1||y0<0||y0>board.getSize()-1) {  // Checks if the variables are out of bounds and asks the user to provide with new ones.
				System.out.println("Wrong coordinates! Give new coordinates!");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
				p0=new Position(x0,y0);
			}
			if( board.getCell(p0)!=this.pawnType ) {  //If the cell's pawn type does not correspond with the player's pawn type then asks to provide with new cell.
				pos_pawntype=false;
				System.out.println("Wrong position!This cell's pawn type doesn't correspond to your pawn type.");  //Error message.
				System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p0=new Position(x0,y0);
			}
			else if (x0==0 && y0==0 && !(board.isEmpty(new Position(x0+1,y0) ))&& !(board.isEmpty(new Position(x0,y0+1)))) { //If the cell the player wants to move does not have options to move the a cell next to it then he cannot move that exact pawn.Up left cell.
				pos_pawntype=false;
				System.out.println("You cannot move this pawn!");
				System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p0=new Position(x0,y0);
			}
			else if(x0==0 && y0==board.getSize()-1 && !(board.isEmpty(new Position(x0+1,y0) ))&& !(board.isEmpty(new Position(x0,y0-1)))) { // Up right cell.
				pos_pawntype=false;
				System.out.println("You cannot move this pawn!");
				System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p0=new Position(x0,y0);
			}
			else if(x0==board.getSize()-1 && y0==0 && !(board.isEmpty(new Position(x0-1,y0) ))&& !(board.isEmpty(new Position(x0,y0+1)))) { // Down left cell.
				pos_pawntype=false;
				System.out.println("You cannot move this pawn!");
				System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p0=new Position(x0,y0);
			}
			else if(x0==board.getSize()-1 && y0==board.getSize()-1 && !(board.isEmpty(new Position(x0-1,y0) ))&& !(board.isEmpty(new Position(x0,y0-1))) ) { // Down right cell.
				pos_pawntype=false;
				System.out.println("You cannot move this pawn!");
				System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p0=new Position(x0,y0);
			}
			else if(x0==0 && y0!=0 && y0!=board.getSize()-1 && !(board.isEmpty(new Position(x0+1,y0) ))&& !(board.isEmpty(new Position(x0,y0-1))) && !(board.isEmpty(new Position(x0,y0+1)))) { //Any cell in the top row except the ones on the far right and left.
				pos_pawntype=false;
				System.out.println("You cannot move this pawn!");
				System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p0=new Position(x0,y0);
			}
			else if(x0==board.getSize()-1 && y0!=0 && y0!=board.getSize()-1 && !(board.isEmpty(new Position(x0-1,y0) ))&& !(board.isEmpty(new Position(x0,y0-1))) && !(board.isEmpty(new Position(x0,y0+1)))) { //Any cell in the bottom row except the ones on the far right and left.
				pos_pawntype=false;
				System.out.println("You cannot move this pawn!");
				System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p0=new Position(x0,y0);
			}
			else if (y0==board.getSize()-1 && x0!=0 && x0!=board.getSize()-1 && !(board.isEmpty(new Position(x0,y0-1) ))&& !(board.isEmpty(new Position(x0-1,y0))) && !(board.isEmpty(new Position(x0+1,y0)))) { //Any cell in the last column except the top and the bottom cells.
				pos_pawntype=false;
				System.out.println("You cannot move this pawn!");
				System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p0=new Position(x0,y0);
			}
			else if(y0==0 && x0!=0 && x0!=board.getSize()-1 && !(board.isEmpty(new Position(x0,y0+1) ))&& !(board.isEmpty(new Position(x0-1,y0))) && !(board.isEmpty(new Position(x0+1,y0)))) { //Any cell in the first column except the top and bottom cell.
				pos_pawntype=false;
				System.out.println("You cannot move this pawn!");
				System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p0=new Position(x0,y0);
			}
			else if( x0!=0 && x0!=board.getSize()-1 && y0!=0 && y0!=board.getSize()-1 && !(board.isEmpty(new Position(x0,y0+1) ))&& !(board.isEmpty(new Position(x0-1,y0))) && !(board.isEmpty(new Position(x0+1,y0))) && !(board.isEmpty(new Position(x0,y0-1)))) {
				pos_pawntype=false;
				System.out.println("You cannot move this pawn!");
				System.out.println("Enter the row and column of the pawn you want to move (0-"+(board.getSize()-1)+"):");
				x0=StdIn.readInt();
				y0=StdIn.readInt();
			    p0=new Position(x0,y0);
			}
			if(pos_pawntype) {  //If the variables were given correctly then asks the user the position they want to move their pawn to.
				System.out.println("Enter the row and column  where you want to move the pawn (0-"+(board.getSize()-1)+"):");
				int x1=StdIn.readInt();
				int y1=StdIn.readInt();
			    p1=new Position(x1,y1);
				while((x1<0||x1>board.getSize()-1||y1<0||y1>board.getSize()-1)) {  //Checks if the variables are given are put of bounds and asks for new ones.
					System.out.println("Wrong coordinates! Give new coordinates!");
					x1=StdIn.readInt();
					y1=StdIn.readInt();
					p1=new Position(x1,y1);
				}
				if( ((x1!=x0+1 && x1!=x0-1) || y1!=y0) && ((y1!=y0+1 && y1!=y0-1) || x1!=x0) ) {  //Checks if the position the player wants to move to is next to the original position.
					pos_pawntype=false;
					System.out.println("Wrong position!You cannot move to that cell!");
				}
				else if(board.getCell(p1)!='E') { //If the cell that the player wants to place their pawn is not Empty then is not a correct position.
					pos_pawntype=false;
					System.out.println("Wrong position!This cell is already occupied!"); //Error message.
					}	
			}
		}while(!pos_pawntype);
		board.moveSquare(p0,p1); // If the check is over then moves the pawn from position p0 to p1.
		
	}
	
	public String toString() { //Returns the player type of the player.
		return playerType+"";
	}
}