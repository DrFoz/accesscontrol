package spaceMain;
/**
 * 
 */

/**
 * @author Lee Strenge
 *
 */
public class controller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		shipLayout player1ship=new shipLayout(1);
		shipLayout player2ship=new shipLayout(1);
		spaceMap gameBoard=new spaceMap(player1ship,player2ship);
		gameBoard.showMap();
		System.out.println("Player 1 possible spawn squares");
		if (gameBoard.displayP1SpawnPoints()==false){
			System.out.println("Error finding player 1 spawn points.");
		}
		System.out.println("Player 2 possible spawn squares");
		if (gameBoard.displayP2SpawnPoints()==false){
			System.out.println("Error finding player 2 spawn points.");
		}
	}
}
