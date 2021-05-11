/**
 * Description
 * 
 * Classe répertoriant les méthodes de test de mouvement
 */

/**
 * @author Maxime Caron
 *
 */


public final class Move {

  /**
   *Vérifie si un mouvement est horizontal 
   * 
   * @param p1
   * @param p2
   * @return true si le mouvement est horizontal, false sinon
   */
  static boolean horizontal(Position p1, Position p2){
    return (p1.getRow() == p2.getRow());
  }

  /**
   * Calcul la longueur d'un déplacement horizontal
   * 
   * @param p1
   * @param p2
   * @return distance horizotal entre p1 et p2
   */
  static int longueurHorizontal(Position p1, Position p2){
    return (p1.getRow()-p1.getRow());
  }

  
  /**
   *Vérifie si un mouvement est vertical 
   * 
   * @param p1
   * @param p2
   * @return true si le mouvement est vertical, false sinon
   */
  static boolean vertical(Position p1, Position p2){
    return (p1.getCol() == p2.getCol());
  }

  
  /**
   * Calcul la longueur d'un déplacement vertical
   * 
   * @param p1
   * @param p2
   * @return distance vertical entre p1 et p2
   */
  static int longueurVertical(Position p1, Position p2){
    return (p2.getCol()-p1.getCol());
  }

  
  /**
   *Vérifie si un mouvement est diagonal 
   * 
   * @param p1
   * @param p2
   * @return true si le mouvement est diagonal, false sinon
   */
  static boolean diagonal(Position p1, Position p2){
    return (longueurVertical(p1,p2) == longueurHorizontal(p1,p2));
  }

}
