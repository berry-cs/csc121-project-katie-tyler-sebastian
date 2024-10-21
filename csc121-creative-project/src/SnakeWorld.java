import processing.core.PApplet;
import processing.event.KeyEvent;

public class SnakeWorld implements IWorld {

	Snake snake;
	Apple apple;
	
	
	SnakeWorld(Snake snake, Apple apple) {
		this.snake = snake;
		this.apple = apple;
	}
	
	
	/** produce an updated state of this world after one time tick */
	public IWorld update() { 
		return new SnakeWorld(snake.move(), apple);
	}

	
	/** produce a visual rendering of this world on the given window */
	public PApplet draw(PApplet w) { 
		snake.draw(w);
		//apple.draw(w);
		
		return w;
	}


	/** produce an updated state of this world after a key press event */
	public IWorld keyPressed(KeyEvent kev) { 
		return this;
		}


	
}
