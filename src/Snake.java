import processing.core.PApplet;

import java.util.ArrayList;

public class Snake {
    ArrayList<String> body = new ArrayList<>();
    ArrayList<Integer> oldX = new ArrayList<>();
    ArrayList<Integer> oldY = new ArrayList<>();
    PApplet p;
    float x, y;
    int r, g, b;

    Snake(PApplet p) {
        this.p = p;
        x = 100;
        y = 100;
        r = 0;
        g = 255;
        b = 0;
    }
    void display() {
        // SNAKE HEAD
        p.fill(r, g, b);
        p.rect(x,y,10,10);

        // SNAKE BODY
        for (int i = 0; i < body.size(); i++) {
            int a = oldX.get((oldX.size() - 2) - i);
            int b = oldY.get((oldY.size() - 2) - i);
            p.rect(a,b,10,10);
        }
    }

    void checks () {
        // DID SNAKE GO OUTSIDE BORDER?
        if (y > 211 || x > 201 || y < 19 || x < 9) {
            p.noLoop();
            System.out.println("Out of bounds");
            new Death(Score.score);
        }

        // DID SNAKE GO INTO BODY?
        for (int i = 0; i < body.size(); i++) {
            int a = oldX.get((oldX.size() - 2) - i);
            int b = oldY.get((oldY.size() - 2) - i);
            if (a == x && b == y) {
                p.noLoop();
                System.out.println("Killed in Action");
                new Death(Score.score);
            }
        }
    }

    void cleans() {
        for (int i = oldX.size() - body.size() - 5; i > 0; i--) {
            oldX.remove(i);
            oldY.remove(i);
        }
    }

    void setColor() {
        r = (int) (Math.random() * 255);
        b = (int) (Math.random() * 255);
        g = (int) (Math.random() * 255);
    }

    float getX() {
        return x;
    }

    void setX(int x) {
        this.x += x;
    }

    float getY() {
        return y;
    }

    void setY(int y) {
        this.y += y;
    }

    void setBody() {
        body.add("");
    }

    void setOldX() {
        oldX.add((int)x);
    }

    void setOldY() {
        oldY.add((int)y);
    }
}