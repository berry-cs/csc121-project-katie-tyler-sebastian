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

    // Regenerate the apple at a random location within the given width and height bounds
    public Apple regenerate() {
        int newX = (int) (1 + (Math.random() * 39) * SnakeApp.GRID_SIZE);
        int newY = (int) (1 + (Math.random() * 39) * SnakeApp.GRID_SIZE);
        return new Apple(new Posn(newX, newY));
    }
}