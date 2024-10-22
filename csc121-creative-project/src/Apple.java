import processing.core.PApplet;

public class Apple {
Posn posn;

public Apple(Posn posn) {
	super();
	this.posn = posn;
}

public PApplet draw(PApplet w) { 
	w.fill(255,0,0);
	w.circle(this.posn.x, this.posn.y, 10);
	return w;
}
}
