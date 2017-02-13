import processing.core.PApplet;
import processing.core.PFont;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends PApplet {
    private Snake s;
    private Score c;
    private int direction = 38;
    private PFont font;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(220, 230);
    }

    public void setup(){
        frameRate(random(10,15));
        fill(255,12,12);
        s = new Snake(this);
        c = new Score(this);
        font = createFont("font/PressStart2P-Regular.ttf", 8, true);
    }

    public void draw(){
        // GENERAL
        background(5);
        playerMoved();
        textFont(font);
        text("SCORE: " + Score.score , 10, 14);
        text("HIGHSCORE: " + getHighScore() , width - textWidth("HIGHSCORE: " + getHighScore()) - 10, 14);

        // BORDER
        stroke(255);
        fill(10);
        rect(9,19,202,202);

        // SCORE
        stroke(50, 70);
        c.display();

        // SNAKE
        s.display();
        s.checks();
        s.cleans();

        // HORIZONTAL LINES
        for (int i = 0; i < 230; i+=2) {
            stroke(50, 50);
            line(0, i, width, i);
        }

        // DID SCORE?
        if (s.getX() == c.getX() && s.getY() == c.getY()) {
            c.setScore();
            c.move();
            s.setBody();
        }
    }

    public void keyPressed() {
        // SET DIRECTION TO LEFT
        if (keyCode == LEFT) {
            direction = 37;
        }

        // SET DIRECTION TO RIGHT
        if (keyCode == RIGHT) {
            direction = 39;
        }

        // SET DIRECTION TO UP
        if (keyCode == UP) {
            direction = 38;
        }

        // SET DIRECTION TO DOWN
        if (keyCode == DOWN) {
            direction = 40;
        }

        // SET THE SNAKE COLOR TO A RANDOM COLOR
        if (keyCode == 67) {
            s.setColor();
        }
    }

    private void playerMoved(){
        // MAKING SNAKE MOVE RIGHT
        if (direction == 39) {
            s.setX(10);
            s.setOldX();
            s.setOldY();
        }

        // MAKING SNAKE MOVE LEFT
        if (direction == 37) {
            s.setX(-10);
            s.setOldX();
            s.setOldY();
        }

        // MAKING SNAKE MOVE UP
        if (direction == 38) {
            s.setY(-10);
            s.setOldX();
            s.setOldY();
        }

        // MAKING SNAKE MOVE DOWN
        if (direction == 40) {
            s.setY(10);
            s.setOldX();
            s.setOldY();
        }
    }

    private int getHighScore() {
        int highscore = 0;

        try {
            File x = new File("highscore.txt");
            Scanner sc = new Scanner(x);
            while (sc.hasNext()) {
                int high = Integer.parseInt(sc.next());
                if (c.getScore() > high) {
                    highscore = c.getScore();
                } else {
                    highscore = high;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            new Death(Score.score);
        }

        return highscore;
    }
}