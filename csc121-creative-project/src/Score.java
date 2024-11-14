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

    // Display the score and high score
    public void displayScores(PApplet app) {
        app.fill(0, 0, 0); 
        app.textSize(15);
        app.text("Score: " + score, 10, 20);
        app.text("High Score: " + highScore, 10, 40);
    }
}


    
