import processing.core.PApplet;

public class base extends PApplet {
    private snake s;
    private score c;
    private int direction = 39;

    public static void main(String[] args) {
        PApplet.main("base");
    }

    public void settings() {
        size(220, 220);
    }

    public void setup(){
        frameRate(random(10,15));
        fill(255,12,12);
        s = new snake(this);
        c = new score(this);
    }

    public void draw(){
        // GENERAL
        background(5);
        playerMoved();

        // BORDER
        stroke(255);
        fill(10);
        rect(9,9,202,202);

        // SCORE
        stroke(30);
        c.display();

        // SNAKE
        s.display();
        s.checks();
        s.cleans();

        // DID SCORE?
        if (s.getX() == c.getX() && s.getY() == c.getY()) {
            c.setScore();
            c.move();
            s.setBody();
            System.out.println(c.getScore());
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
}