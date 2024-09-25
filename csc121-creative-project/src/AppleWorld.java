import processing.core.PApplet;

/**
 * Class for Apple for snake 
 */


public class AppleWorld implements IWorld {
 Posn posn;
 boolean eaten;
 
 public AppleWorld(Posn posn, boolean eaten) {
 this.posn = posn;
 this.eaten = eaten;
 }
 
 public PApplet draw(PApplet z) { 
		z.circle(this.posn.x, this.posn.y, 10);
		return z;
		}
	
	public IWorld update(SnakeWorld s) {
		if (this.posn.x == s.posn.x && this.posn.y == s.posn.y) {
			return new AppleWorld(new Posn(this.posn.x, this.posn.y), true);
		} else {return this;}
	}
}

