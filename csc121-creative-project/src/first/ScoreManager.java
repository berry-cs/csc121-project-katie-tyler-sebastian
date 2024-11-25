package first;

import processing.core.PApplet;

public class ScoreManager {
    private int score;
    private int highScore;

    public ScoreManager() {
        this.score = 0;
        this.highScore = 0;
    }

    public void incrementScore(int points) {
        score += points;
        if (score > highScore) {
            highScore = score;
        }
    }

    public void resetScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public int getHighScore() {
        return highScore;
    }

    public void displayScores(PApplet app) {
        app.fill(0); // Set text color to black
        app.textSize(16);
        app.text("Score: " + score, 10, 20);
        app.text("High Score: " + highScore, 10, 40);
    }
}
