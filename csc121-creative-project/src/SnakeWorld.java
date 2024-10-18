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
        if (this.dir.equals("right") && this.posn.x < 390) {
            return new SnakeWorld(new Posn(this.posn.x + 3, this.posn.y), "right", true);
        } 
        else if (this.dir.equals("left") && this.posn.x > 0) {
            return new SnakeWorld(new Posn(this.posn.x - 3, this.posn.y), "left", true);
        } 
        else if (this.dir.equals("up") && this.posn.y > 0) {
            return new SnakeWorld(new Posn(this.posn.x, this.posn.y - 3), "up", true);
        } 
        else if (this.dir.equals("down") && this.posn.y < 390) {
            return new SnakeWorld(new Posn(this.posn.x, this.posn.y + 3), "down", true);
        }
        return this; 
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

