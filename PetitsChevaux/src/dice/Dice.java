package dice;

/**
 * @author Quentin et Maxime
 *
 */
public class Dice {
private int v; //value
	
	/**
	 *
	 */
	public Dice() {
		v=0;
	}
	
	/**
	 * Roll dice
	 */
	public void roll() {
		v=(int)(Math.random()*6)+1;
	}
	
	/**
	 * @return dice value
	 */
	public int getValue() {
		return v;
	}
}
