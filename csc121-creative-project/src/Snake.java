import processing.core.PApplet;

public class Snake {

	Posn posn;
	Posn dir;   //  new Posn(1, 0)  OR  new Posn(-1, 0)  OR  new Posn(0, 1)   OR   new Posn(0, -1)
				//   "right"
	boolean alive;


	Snake(Posn posn, Posn dir, boolean alive) {
		super();
		this.posn = posn;
		this.dir = dir;
		this.alive = alive;
	}


	public PApplet draw(PApplet w) { 
		w.background(255);
		w.fill(0,255,0);
		w.square(this.posn.x, this.posn.y, 10);
		return w;
	}
	
	
	public Snake move() {
		Posn newPosn = posn.translate( dir.scale(3) );
		return new Snake(newPosn, dir, alive);
	}
	public Snake changeDirection(Posn newDir) {
        return new Snake(this.posn, newDir, this.alive);
    }

}
