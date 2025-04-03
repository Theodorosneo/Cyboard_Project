/**
* Author: THEODOROS NEOPHYTOU
* Written: 25/11/2024
* Last updated: 03/12/2024
*
* Compilation: javac Game.java
* Execution: java Game
*
* Information about what my program does:
* 
* My program combines all of 5 classes to create a Cyboard game and play it.
* Information about how I programmed the methods is provided via side notes on each of the classes.
* I have only implemented the Human vs Human game mode and no Graphics.
*/
public class Game {
	
	private  Player player1;
	private  Player player2;
	private  int N;
	private  Board board;	
	
	
	public Game(String p1,String p2,int size) {  //Constructor. Creates a game.
		 board=new Board(size);  //Creates a board with size X size cells.
		 player1=new Player(p1,board,'X'); //Creates two player objects.
		 player2=new Player(p2,board,'0');
	     N=size;
	}
	
	public void play() {
		boolean win=false; // Boolean variable to check if one of the players has won in the Setting phase and to not go in the Moving phase.
		System.out.println(board.toString());
		for(int i=1;i<=2*N;i++) {  //For loop for each player to set their pieces.
			if(i%2!=0) {  //If i is odd then player 1 plays.
				System.out.println("Current player: X");
				player1.setPiece(); // Player 1 sets his piece.
				System.out.println(board.toString());  //Prints the board.
			}
			else {  //If i is even then player 2 plays.
				System.out.println("Current player: 0");
				player2.setPiece();  //Player 2 sets his piece.
				System.out.println(board.toString());  //Prints the board.
			}	
			if(i==2*N-1 && board.winningState()) {  //Checks on the last Setting attempt of each player if they have won.
					System.out.println("Player X wins!"); //Winning message and program terminates.
					win=true;
					break;
			}
			if((i==2*N && board.winningState())) { //Checks on the last Setting attempt of each player if they have won.
				System.out.println("Player 0 wins!");  //Winning message and program terminates.
				win=true;
				break;
			}
		}
		while(!win) {  //This part of the code runs if no Player has won in the Setting phase.
			win=false;  // Win is initialised as false so if one of the players wins the while loop breaks.
			for(int i=0;i<2;i++) {
				if(i==0) {
					System.out.println("Current player: X");
					player1.movePiece();
					System.out.println(board.toString());
					if(board.winningState()) {  //If Player 1 has won then win is set to true and the for loop breaks.
						System.out.println("Player X wins!"); //Winning message.
						win=true;
						break;
					}
				}
				else {
					System.out.println("Current player: O");
					player2.movePiece();  //Player 2 moves his piece.
					System.out.println(board.toString());
					if(board.winningState()) {  //If Player 2 has won then win is set to true and the for loop breaks.
						System.out.println("Player O wins!");  //Winning message.
						win=true;
						break;
					}
				}	
			}
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Welcome to the Game!");
		System.out.println("1. Human vs Human");
		System.out.println("2. Human vs Computer – not implemented");
		System.out.println("3. Computer vs Computer – not implemented");
		System.out.println("Choose game mode (1-3) and board size (>2 and <6):");
		int gamemode=StdIn.readInt();  //Reads the game mode the player has chosen.
		int size=StdIn.readInt();  //Reads the size of the board that the game is going to be played on.
		while(gamemode>3 || gamemode<=0) {  //Checks if the game mode is correctly given.
			System.out.println("Wrong gamemode chosen!Choose a different gamemode!");
			gamemode=StdIn.readInt();
		}
		while (gamemode!=1) {  //Checks if the user has chosen an implemented game mode.
			System.out.println("Gamemode is not implemented.Give the implemented option!");
			gamemode=StdIn.readInt();
		}
		while(size<=2 || size>=6) {  //Checks if the size provided by the user is in bounds.
			System.out.println("The size of the board you provided is out of bounds! Give a new size!");
			size=StdIn.readInt();
		}
		Game game=new Game("Human","Human",size);  //Creates a game.
		game.play();  //Plays the game.
	}
}
