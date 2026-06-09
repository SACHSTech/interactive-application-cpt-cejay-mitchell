import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class Sketch extends PApplet {

    int roadColour = color(255);

    int carX = 394;
    int carY = 750;

    int targetX = 394;
    int slideSpeed = 12;

    int roadY = 0;
    int roadSpeed = 5;

    ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    int score = 0;
    boolean gameOver = false;

    int[] lanes = {218, 394, 570};

    // NEW: difficulty scaling
    int difficultyLevel = 1;

    public static void main(String[] args) {
        PApplet.main("Sketch");
    }

    @Override
    public void settings() {
        size(800, 900);
    }

    @Override
    public void setup() {
        obstacles.add(new Obstacle(218, -100, 6));
        obstacles.add(new Obstacle(394, -400, 6));
        obstacles.add(new Obstacle(570, -700, 6));
    }

    @Override
    public void draw() {

        if (!gameOver) {

            moveBackground();
            drawRoad();

            handleObstacles();
            checkCollision();

            moveCar();
            drawCar();
            drawScore();

        } else {

            background(0);

            textAlign(CENTER);

            fill(255, 0, 0);
            textSize(60);
            text("GAME OVER", width / 2, height / 2);

            textSize(30);
            text("Score: " + score, width / 2, height / 2 + 60);

            text("Press SPACE to restart", width / 2, height / 2 + 120);
        }
    }

    // Score counter

    void drawScore() {

        if (frameCount % 30 < 15) {
            fill(255, 0, 0);
        } else {
            fill(180, 0, 0);
        }

        textAlign(CENTER);
        textSize(32);
        text("Score: " + score, width / 2, 50);
    }

    // Road

    private void drawRoad() {
        background(128, 128, 128);
        fill(roadColour);
        noStroke();

        for (int y = -40 + roadY; y < height; y += 40) {
            rect(304, y, 11, 20);
            rect(485, y, 11, 20);
        }

        fill(0, 180, 0);
        rect(0, 0, 133, 900);
        rect(667, 0, 133, 900);

        stroke(255, 255, 0);
        strokeWeight(7);
        line(133, 0, 133, 900);
        line(667, 0, 667, 900);
    }

    private void moveBackground() {
        roadY += roadSpeed;
        if (roadY >= 40) roadY = 0;
    }

    // Player car

    private void drawCar() {
        noStroke();

        fill(0);
        rect(carX - 25, carY - 20, 8, 15);
        rect(carX + 17, carY - 20, 8, 15);
        rect(carX - 27, carY + 15, 10, 18);
        rect(carX + 17, carY + 15, 10, 18);

        fill(255, 100, 0);
        rect(carX - 20, carY - 20, 40, 55);

        triangle(carX - 20, carY - 20, carX + 20, carY - 20, carX, carY - 40);

        fill(30, 30, 50);
        rect(carX - 12, carY - 10, 24, 15);
    }

    private void moveCar() {
        if (carX < targetX) {
            carX += slideSpeed;
            if (carX > targetX) carX = targetX;
        } else if (carX > targetX) {
            carX -= slideSpeed;
            if (carX < targetX) carX = targetX;
        }
    }

    // Obstacles

    class Obstacle {
        int x, y, speed;

        Obstacle(int x, int y, int speed) {
            this.x = x;
            this.y = y;
            this.speed = speed;
        }

        void move() {
            y += speed;
        }

        void display() {
            fill(200, 0, 0);
            rect(x - 20, y - 40, 40, 70);
        }
    }

    void handleObstacles() {

        for (Obstacle o : obstacles) {

            o.move();
            o.display();

            if (o.y > height + 50) {

                score += 100;

                int lane = (int) random(3);
                o.x = lanes[lane];
                o.y = -200;

                // difficulty scaling (FIXED)
                if (score / 500 >= difficultyLevel) {
                    difficultyLevel++;

                    roadSpeed += 1;

                    for (Obstacle ob : obstacles) {
                        ob.speed += 1;
                    }
                }
            }
        }
    }

    void checkCollision() {

        for (Obstacle o : obstacles) {

            if (abs(carX - o.x) < 40 &&
                abs(carY - o.y) < 60) {

                gameOver = true;
            }
        }
    }

    // Input

    public void keyPressed() {

        if (gameOver && key == ' ') {
            restartGame();
            return;
        }

        if (key == 'a' || key == 'A') {
            if (targetX == 394) targetX = 218;
            else if (targetX == 570) targetX = 394;
        }

        if (key == 'd' || key == 'D') {
            if (targetX == 394) targetX = 570;
            else if (targetX == 218) targetX = 394;
        }
    }

    void restartGame() {

        score = 0;
        gameOver = false;

        roadSpeed = 5;
        difficultyLevel = 1;

        obstacles.clear();

        obstacles.add(new Obstacle(218, -100, 6));
        obstacles.add(new Obstacle(394, -400, 6));
        obstacles.add(new Obstacle(570, -700, 6));

        carX = 394;
        targetX = 394;
    }
}