package first;



/**
 * Posn class
 */
public class Posn {
    int x;
    int y;


public Posn(int x, int y) {
	this.x = x;
	this.y = y;
	}

/**
 *  moves the snake forward and backward
 * 
 */

public int moveX() {
	
	return x;
}

/**
 *  move the snake up and down
 */
public int moveY() {
	return y;
}

/**
 * wall class
 * 
 */

public class wall {
	Posn posn;
	
	public wall(Posn posn) {
		this.posn = posn;
	}
}

}