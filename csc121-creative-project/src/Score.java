import processing.core.PApplet;
import java.util.Scanner;
import java.io.*;


public class Score {

	private int score;
	private int highScore;
    

    public Score(int score) {
        this.score = 0;
        this.highScore = 
        		readHighScore();
    }

    // Increment the score
    public void incrementScore(int points) {
        score += points;
        if (score > highScore) {
            highScore = score;
            writeHighScore();
        }
}
    // Reset score
    public Score resetScore() {
        return new Score(0);
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
	
	//Output file writing high scores
	public void writeHighScore() {
		try (FileWriter writer = new FileWriter("highscore.txt")){
			writer.write(String.valueOf(highScore));
		} catch(IOException e) {
			System.err.println("Error writing high score to file:" + e.getMessage());
		}
	}
	
	//Read from high score file
	public int readHighScore() {
		File file = new File("highscore.txt");
		if (file.exists()) {
			try (Scanner scanner = new Scanner(file)){
				if (scanner.hasNextInt()) {
					return scanner.nextInt();
				}
			} catch (IOException e) {
				System.err.println("Error reading high score from file: " + e.getMessage());
			}
		}
		return this.score; // Default high score
	}
}


    
