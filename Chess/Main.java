/**
 * Description
 * 
 * Programme principal
 */

/**
 * @author Maxime Caron
 *
 */



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Créer le jeu d'échec
		ChessBoard platal = new ChessBoard();
		
		//Affiche le plateau
		System.out.println(platal.toString());
		
		
		//Déplace une pièce en récupérant l'erreur si la métode retourn false
		String test = (platal.move(7, 4, 5, 4))? "" : "Error, this move isn't valid !\n";
		System.out.println(test);
		//Affiche le plateau
		System.out.println(platal.toString());
		
		test = (platal.move(8, 3, 3, 8))? "" : "Error, this move isn't valid !\n";
		System.out.println(test);
		System.out.println(platal.toString());
		
		test = (platal.move(3, 8, 2, 7))? "" : "Error, this move isn't valid !\n";
		System.out.println(test);
		System.out.println(platal.toString());
		
		test = (platal.move(2, 7, 4, 5))? "" : "Error, this move isn't valid !\n";
		System.out.println(test);
		System.out.println(platal.toString());
	}

}
