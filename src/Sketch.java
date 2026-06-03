import processing.core.PApplet;

/**
 * Template for programs with Processing graphics output.
 * @author Mitchell Jaja & Cejay Baxter
 */
public class Sketch extends PApplet {
    int roadColour = color(255);
    int carX = 394; // Center lane
    int carY = 750; // Bottom of screen

    public static void main(String[] args) {
        PApplet.main("Sketch");
    }

    @Override
    public void settings() {
        size(800, 900); 
    }

    @Override
    public void setup() {
        generateBackground();
        drawCar();
    }

    public void generateBackground(){
        background(128, 128, 128);
        fill(roadColour);

        noStroke();

        for (int y = 0; y < height; y += 40) {
            rect(304, y, 11, 20); // Left lane dashes
            rect(485, y, 11, 20); // Right lane dashes
        }

        // Green Grass
        fill(0, 180, 0);
        noStroke();
        rect(0, 0, 133, 900);
        rect(667, 0, 133, 900);

        fill(0, 180, 0);
        noStroke();
        rect(0, 0, 133, 900);
        rect(667, 0, 133, 900);

        // Borders
        stroke(255,255,0);
        strokeWeight(7);
        line(133,0,133,900);
        line(667,0,667,900);
    }

    public void drawCar(){
        noStroke();
        
        // Tires (Black rectangles)
        fill(0);
        rect(carX - 25, carY - 20, 8, 15);  // Front Left
        rect(carX + 17, carY - 20, 8, 15);  // Front Right
        rect(carX - 27, carY + 15, 10, 18); // Rear Left
        rect(carX + 17, carY + 15, 10, 18); // Rear Right

        // Main Car Body (Orange rectangle)
        fill(255, 100, 0); 
        rect(carX - 20, carY - 20, 40, 55); 
        
        // Pointy Nose (Triangle)
        triangle(carX - 20, carY - 20, carX + 20, carY - 20, carX, carY - 40);

        // Windshield (Dark box)
        fill(30, 30, 50);
        rect(carX - 12, carY - 10, 24, 15);
    }

    @Override
    public void draw() {

    }

    /** Additional helper methods below */

}
