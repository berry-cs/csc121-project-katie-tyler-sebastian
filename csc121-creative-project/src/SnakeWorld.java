import java.util.Objects;

import processing.core.PApplet;

/**
 * represent the state of my falling circle animation.
 */
public class SnakeWorld implements IWorld {

	Posn posn;
	String dir;
	boolean alive;
	
	SnakeWorld(Posn posn, String dir, boolean alive) {
		super();
		this.posn = posn;
		this.dir = dir;
		this.alive = alive;
	
	}
	
	
	
	/* 
	 * draw a picture with a snake segment at this worlds (x, y)
	 */
	public PApplet draw(PApplet w) { 
		w.background(255);
		w.fill(0,255,0);
		w.square(this.posn.x, this.posn.y, 10);
		return w;
		}
	
	public IWorld update() {
		
		if (!this.alive) {
			return this;
		}
		
		int newX = this.posn.x;
	    int newY = this.posn.y;

	    if (this.dir.equals("right")) {
	        newX += 3;
	    } 
	    else if (this.dir.equals("left")) {
	        newX -= 3;
	    } 
	    else if (this.dir.equals("up")) {
	        newY -= 3;
	    } 
	    else if (this.dir.equals("down")) {
	        newY += 3;
	    }

	    
	    if (newX < 0) {
	        return new SnakeWorld(this.posn, this.dir, false);
	    }
	    else if (newX >= 400) {
	    	 return new SnakeWorld(this.posn, this.dir, false);
	     }
	    else if (newY < 0) {
	    	 return new SnakeWorld(this.posn, this.dir, false);
	     }	 
	    else if (newY >= 400) {
	    	 return new SnakeWorld(this.posn, this.dir, false);
	     }
	     
	    

	    
	    return new SnakeWorld(new Posn(newX, newY), this.dir, true);
	}
 
	


	@Override
	public int hashCode() {
		return Objects.hash(alive, dir);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SnakeWorld other = (SnakeWorld) obj;
		return alive == other.alive && Objects.equals(dir, other.dir);
	}

}

