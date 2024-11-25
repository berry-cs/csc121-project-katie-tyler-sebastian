import processing.core.PApplet;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    List<Posn> body; // List to track each segment of the snake
    Posn dir;
    boolean alive;

    Snake(Posn posn, Posn dir, boolean alive) {
        this.body = new ArrayList<>();
        this.body.add(posn); // Start with one segment at the given position
        this.dir = dir;
        this.alive = alive;
    }

    // Draw the snake by drawing each segment in the body list
    public PApplet draw(PApplet w) { 
        w.fill(0, 100, 0);
        for (Posn segment : body) {
            w.square(segment.x, segment.y, 10);
        }
        return w;
    }
    
    // Move the snake: each segment follows the one in front
    public Snake move() {
        List<Posn> newBody = new ArrayList<>();
        // Calculate new head position
        Posn newHead = body.get(0).translate(dir.scale(10));
        newBody.add(newHead);

        // Move each segment to the position of the segment in front of it
        for (int i = 1; i < body.size(); i++) {
            newBody.add(body.get(i - 1));
        }

        this.body = newBody;
        return this;
    }

    // Change direction of the snake
    public Snake changeDirection(Posn newDir) {
        // Ensure the snake cannot reverse directly into itself
        if (!(newDir.x == -dir.x && newDir.y == -dir.y)) {
            this.dir = newDir;
        }
        return this;
    }

    // Grow the snake by adding a new segment at the end of the body
    public void grow() {
        // Add a new segment at the position of the last segment
        Posn tail = body.get(body.size() - 1);
        body.add(tail);
    }
}
