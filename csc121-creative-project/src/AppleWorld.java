import processing.core.PApplet;
import java.util.Random;

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
 
 @Override
 public PApplet draw(PApplet z) { 
	 if (!eaten) {
	 	z.fill(225, 0, 0);
		z.circle(this.posn.x, this.posn.y, 10);
	 }
		return z;
		}
	
	public IWorld update(SnakeWorld s) {
		if (Math.abs(this.posn.x - s.posn.x) < 10 && Math.abs(this.posn.y - s.posn.y) < 10) {
			
			Random rand = new Random();
			int newX = rand.nextInt(400);
			int newY = rand.nextInt(400);
			
			return new AppleWorld(new Posn(newX, newY), false);
		} else {return this;}
	}
}

