import processing.core.PApplet;
import processing.event.KeyEvent;

public class SnakeWorld implements IWorld {
    Snake snake;
    Apple apple;
    Score score;
    boolean gameOver;  // Game over flag

	
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

    /** produce an updated state of this world after one time tick */
    public IWorld update() {
        if (!gameOver) {
            snake = snake.move();
            if (snake.posn.distanceTo(apple.posn) < 10) {
                apple = apple.regenerate(398, 398);
                score.incrementScore(1);
            }

            if (isOutOfBounds(snake)) {
                gameOver = true;
            }
        }

        return this;  
    }

    
    public PApplet draw(PApplet w) {
        if (gameOver) {
            w.background(0);  
            w.fill(0, 0, 255);  
            w.textSize(32);
            w.textAlign(PApplet.CENTER, PApplet.CENTER);
            w.text("Game Over", w.width / 2, w.height / 2 - 40);  
            w.textSize(16);
            w.text("Press ENTER to restart", w.width / 2, w.height / 2 ); 
            w.text("Final Score: " + score.getScore(), w.width / 2, w.height / 2 +30);
            w.text("High Score: " + score.getHighScore(), w.width / 2, w.height / 2 + 50);
        } else {
            w.background(255); 
            snake.draw(w);
            apple.draw(w);
            score.displayScores(w);
        }
        return w;
    }
    private boolean isOutOfBounds(Snake snake) {
        return (snake.posn.x < 0 || snake.posn.x >= 390 || snake.posn.y < 0 || snake.posn.y >= 390);
    }

    public IWorld keyPressed(KeyEvent kev) {
        if (gameOver) {
            if (kev.getKeyCode() == PApplet.ENTER) {
                // Restart the game with a new snake and apple
                return new SnakeWorld(new Snake(new Posn(200, 200), new Posn(1, 0), true), new Apple(new Posn(100, 100)), this.score.resetScore(), false);
            }
        } else {
            if (kev.getKeyCode() == PApplet.UP) {
                System.out.println("UP key pressed");
                snake = snake.changeDirection(new Posn(0, -1));
            } else if (kev.getKeyCode() == PApplet.DOWN) {
                System.out.println("DOWN key pressed");
                snake = snake.changeDirection(new Posn(0, 1));
            } else if (kev.getKeyCode() == PApplet.LEFT) {
                System.out.println("LEFT key pressed");
                snake = snake.changeDirection(new Posn(-1, 0));
            } else if (kev.getKeyCode() == PApplet.RIGHT) {
                System.out.println("RIGHT key pressed");
                snake = snake.changeDirection(new Posn(1, 0));
            }
            // Debugging: Print the current direction
            System.out.println("Snake direction: " + snake.dir);
        }
        return this;  // Keep returning the same world object, keeping the current state
    }

    // Overloaded constructor to keep the gameOver state
    SnakeWorld(Snake snake, Apple apple, Score score, boolean gameOver) {
        this.snake = snake;
        this.apple = apple;
        this.score = score;
        this.gameOver = gameOver;
    }
}
