import java.util.Objects;

import processing.core.PApplet;
import processing.event.MouseEvent;

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
	 * draw a picture with the circle at this worlds (x, y)
	 */
	public PApplet draw(PApplet w) { 
		w.background(255);
		w.fill(0, 0, 255);
		w.circle(this.x, this.y, 15);
		return w;
		}
	
	public IWorld update() {
		if (this.y < 400) {
			return new SnakeWorld(this.x, this.y +1);
		} else {return this;}
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

