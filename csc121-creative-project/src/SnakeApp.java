import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class SnakeApp extends PApplet {	// <----- 1. rename AppTemplate everywhere in this file
    IWorld w;
    IWorld z;
    
    public void settings() {
        this.size(400, 400);
    }
    
    public void setup() {
       w = new SnakeWorld(new Posn(0, 200), "Right", true);
       z = new AppleWorld(new Posn(200, 100), false);
    }
    
    public void draw() {
        w = w.update();
        z = z.update();
        w.draw(this);
        z.draw(this);
    }
    
    @Override
    public void mousePressed(MouseEvent mev) {
        w = w.mousePressed(mev);
    }
    
    @Override
   public void mouseReleased(MouseEvent mev) {
    	w = w.mouseReleased(mev);
    }

    @Override
   public void mouseMoved(MouseEvent mev) {
    	w = w.mouseMoved(mev);
    }
    
    @Override
    public void mouseDragged(MouseEvent mev) {
    	w = w.mouseDragged(mev);
    }
    
    @Override
    public void mouseClicked(MouseEvent mev) {
    	w = w.mouseClicked(mev);
    }

    @Override
    public void mouseEntered(MouseEvent mev) {
    	w = w.mouseEntered(mev);
    }

    @Override
    public void mouseExited(MouseEvent mev) {
    	w = w.mouseExited(mev);
    }
    
    @Override
    public void mouseWheel(MouseEvent mev) {
    	w = w.mouseWheel(mev);
    }

    @Override
    public void keyPressed(KeyEvent kev) {
        if (kev.getKeyCode() == PApplet.RIGHT) {
            w = new SnakeWorld(((SnakeWorld) w).posn, "right", true);
        } else if (kev.getKeyCode() == PApplet.LEFT) {
            w = new SnakeWorld(((SnakeWorld) w).posn, "left", true);
        } else if (kev.getKeyCode() == PApplet.UP) {
            w = new SnakeWorld(((SnakeWorld) w).posn, "up", true);
        } else if (kev.getKeyCode() == PApplet.DOWN) {
            w = new SnakeWorld(((SnakeWorld) w).posn, "down", true);
        }
    }



    @Override
    public void keyReleased(KeyEvent kev) {
        w = w.keyReleased(kev);
    }
    
    @Override
    public void keyTyped(KeyEvent kev) {
        w = w.keyTyped(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { SnakeApp.class.getName() }, new SnakeApp());
    }
}
