import processing.core.PApplet;
import processing.event.KeyEvent;

public class SnakeWorld implements IWorld {
    Snake snake;
    Apple apple;
    boolean gameOver;
    Score score; 

    SnakeWorld(Snake snake, Apple apple, boolean gameOver, Score score) {
        this.snake = snake;
        this.apple = apple;
        this.gameOver = false;
        this.score = score;
    }

    int frameCount = 0;
    	
    	public IWorld update() {
    	    frameCount++;
    	    if (!gameOver && frameCount % 5 == 0) { // Move the snake every 5 frames
    	        snake.move();
    	        if (!snake.alive) {
    	            gameOver = true;}
    	        else if (snake.body.get(0).distanceTo(apple.posn) < SnakeApp.GRID_SIZE) {
    	            apple = apple.regenerate(snake.body);
    	            snake.grow(); // Grow the snake when it eats the apple
    	            score.incrementScore(1);
    	        }
    	        if (isOutOfBounds(snake))  {
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
            w.text("Game Over", w.width / 2, w.height / 2);
            w.textSize(20);
            w.text("High Score:" + this.score.readHighScore(),  w.width / 2, w.height / 2 + 30);
            w.textSize(16);
            w.text("Press ENTER to restart", w.width / 2, w.height / 2 + 50);
        } else {
            w.background(144,238,144);
            snake.draw(w);
            apple.draw(w);
            score.draw(w);
        }
        return w;
    }

    private boolean isOutOfBounds(Snake snake) {
        Posn head = snake.body.get(0);
        return (head.x < 0 || head.x >= SnakeApp.SCN_WIDTH  || head.y < 0 || head.y >= SnakeApp.SCN_WIDTH );
    }

    
    
    public IWorld keyPressed(KeyEvent kev) {
        if (gameOver) {
            if (kev.getKeyCode() == PApplet.ENTER) {
                // Restart the game with a new snake and apple
                return new SnakeWorld(new Snake(new Posn(200, 200), new Posn(1, 0), true), new Apple(new Posn(200,200)), false, new Score(0));
            }
        } else {
            if (kev.getKeyCode() == PApplet.UP) {
                snake.changeDirection(new Posn(0, -1));
            } else if (kev.getKeyCode() == PApplet.DOWN) {
                snake.changeDirection(new Posn(0, 1));
            } else if (kev.getKeyCode() == PApplet.LEFT) {
                snake.changeDirection(new Posn(-1, 0));
            } else if (kev.getKeyCode() == PApplet.RIGHT) {
                snake.changeDirection(new Posn(1, 0));
            }
        }
        return this;
    }
}