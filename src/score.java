import processing.core.PApplet;

class score {
    static int score;

    private PApplet p;
    private int x, y;

    score(PApplet p) {
        this.p = p;
        score = 0;
        move();
    }

    void display() {
        // SCORE
        p.fill(255, 0, 0);
        p.rect(x, y, 10, 10);
    }

    void move() {
        x = 10 + (10 * (int) (Math.random() * 18));
        y = 10 + (10 * (int) (Math.random() * 18));
    }

    int getScore() {
        return score;
    }

    void setScore() {
        score += 1;
    }

    float getX() {
        return x;
    }

    float getY() {
        return y;
    }
}