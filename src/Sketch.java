import processing.core.PApplet;
import processing.core.PImage;


/**
 * Template for programs with Processing graphics output.
 * @author Mitchell & Cejay
 */
public class Sketch extends PApplet {
    int roadColour = color(255);
    
    int carX = 394; // Center lane
    int carY = 750; // Bottom of screen

    int targetX = 394;
    int slideSpeed = 12;

    int roadY = 0;
    int roadSpeed = 5;

    PImage redCar;

    public static void main(String[] args) {
        PApplet.main("Sketch");
    }

    @Override
    public void settings() {
        size(800, 900); 
    }

    @Override
    public void setup() {        
        redCar = loadImage("RED2.png");
    }

    @Override
    public void draw() {
        moveBackground();
        drawRoad();
        moveCar();
        drawCar();
        carD();
    }

    public void carD(){
        imageMode(CENTER);
        image(redCar, 400, 400);
    }

    public void drawCar(){
        noStroke();
        
        // Tires
        fill(0);
        rect(carX- 25, carY - 20, 8, 15);  // Front Left
        rect(carX + 17,carY - 20, 8, 15);  // Front Right
        rect(carX - 27, carY + 15, 10, 18); // Rear Left
        rect(carX + 17,carY + 15, 10, 18); // Rear Right

        fill(255, 100, 0); 
        rect(carX - 20, carY - 20, 40, 55); 
        
        // Nose
        triangle(carX-20, carY-20, carX+ 20, carY-20, carX, carY- 40);

        // Windshield
        fill(30, 30, 50);
        rect(carX - 12, carY - 10, 24, 15);
    }

    private void drawRoad() {
        background(128,128, 128);
        fill(roadColour);
        noStroke();

        for (int y = -40 + roadY; y < height; y += 40) {
            rect(304, y, 11, 20);
            rect(485, y, 11, 20); 
        }

        // Grass
        fill(0, 180, 0);
        rect(0, 0, 133, 900);
        rect(667, 0, 133, 900);

        // Yellow Borders
        stroke(255, 255, 0);
        strokeWeight(7);
        line(133, 0, 133, 900);
        line(667, 0, 667, 900);
    }

    private void moveBackground() {
        roadY += roadSpeed;
        if (roadY >= 40) {
        roadY = 0;
        }
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

    public void keyPressed() {
        if (key == 'a' || key == 'A') {
            if (targetX == 394) {
                targetX = 218; // Center to Left
            } else if (targetX == 570) { 
                targetX = 394; // Right to Center
            }
        } else if (key == 'd' || key == 'D') {
            if (targetX == 394) {
                targetX = 570; // Center to Right
            } else if (targetX == 218) {
                targetX = 394; // Left to Center
            }
        }
    }

    /** Additional helper methods below */

}
