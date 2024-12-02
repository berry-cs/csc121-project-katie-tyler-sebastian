import java.util.List;

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
    public Apple regenerate(List<Posn> snakeBody) {
        Posn newPosn;
        do {
            int newX = (int) (Math.random() * SnakeApp.SCN_WIDTH / SnakeApp.GRID_SIZE) * SnakeApp.GRID_SIZE;
            int newY = (int) (Math.random() * SnakeApp.SCN_WIDTH / SnakeApp.GRID_SIZE) * SnakeApp.GRID_SIZE;
            newPosn = new Posn(newX, newY);
        } while (snakeBody.contains(newPosn)); // Ensure the apple does not spawn on the snake
        return new Apple(newPosn);
    }
}