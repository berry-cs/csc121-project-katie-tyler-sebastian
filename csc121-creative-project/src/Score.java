import processing.core.PApplet;


public class Score {

	private int score;
    private int highScore;

    public Score(int score, int highScore) {
        this.score = 0;
        this.highScore = 0;
    }

    // Increment the score
    public void incrementScore(int points) {
        score += points;
        if (score > highScore) {
            highScore = score;
        }
}
    // Reset score
    public Score resetScore() {
        return new Score(0, this.highScore);
    }

    // Get the current score
    public int getScore() {
        return score;
    }

    // Get the high score
    public int getHighScore() {
        return highScore;
    }

// Display the score 
	public void draw(PApplet w) {
		w.fill(0, 0, 0); 
        w.textSize(15);
        w.textAlign(50,50);
        w.text("Score: " + score, 10, 20);

	}
}


    
