import processing.core.PApplet;
import processing.event.KeyEvent;

public class SnakeWorld implements IWorld {

	Snake snake;
	Apple apple;
	boolean gameOver;
	
	
	SnakeWorld(Snake snake, Apple apple, boolean gameOver) {
		this.snake = snake;
		this.apple = apple;
		this.gameOver = gameOver;
	}
	
	
	/** produce an updated state of this world after one time tick */
	public IWorld update() { 
		
            // Check if the snake has hit the border
            if (snake.borderHit(400, 400)) {
                gameOver = true;
            }
    
		return new SnakeWorld(snake.move(), apple, false);
	}

	
	/** produce a visual rendering of this world on the given window */
	public PApplet draw(PApplet w) { 
		w.background(255);
		snake.draw(w);
		apple.draw(w);
		
		return w;
	}


	/** produce an updated state of this world after a key press event */
	public IWorld keyPressed(KeyEvent kev) { 
        if (kev.getKeyCode() == PApplet.UP) {
            snake = snake.changeDirection(new Posn(0, -1)); 
        } else if (kev.getKeyCode() == PApplet.DOWN) {
            snake = snake.changeDirection(new Posn(0, 1)); 
        } else if (kev.getKeyCode() == PApplet.LEFT) {
            snake = snake.changeDirection(new Posn(-1, 0)); 
        } else if (kev.getKeyCode() == PApplet.RIGHT) {
            snake = snake.changeDirection(new Posn(1, 0)); // move right
        }
        return this;
    }


	
}
