import java.util.Objects;

import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * represent the state of my falling circle animation.
 */
public class SnakeWorld implements IWorld {

	int x;      //the position of the circle
	int y;
	
	SnakeWorld(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
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
		return x == other.x && y == other.y;
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
	
	public IWorld mousePressed(MouseEvent mev) { return this; }

}
public class SnakeWorld {

}
