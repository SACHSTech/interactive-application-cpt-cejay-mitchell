import processing.core.PApplet;

/**
 * Template for programs with Processing graphics output.
 * @author Your Name
 */
public class Sketch extends PApplet {
    int roadColour = color(255);

    public static void main(String[] args) {
        PApplet.main("Sketch");
    }

    @Override
    public void settings() {
        size(800, 900); 
    }

    @Override
    public void setup() {
        background(128, 128, 128);
        fill(roadColour);
        // rect(304, 0, 8, 900); // First lane line
        // rect(485, 0, 8, 900);

        noStroke();

        // Dash 1
        rect(304, 0, 11, 20);
        rect(485, 0, 11, 20);

        // 2
        rect(304, 40, 11, 20);
        rect(485, 40, 11, 20);

        // 3
        rect(304, 80, 11, 20);
        rect(485, 80, 11, 20);

        // 4
        rect(304, 120, 11, 20);
        rect(485, 120, 11, 20);

        // 5
        rect(304, 160, 11, 20);
        rect(485, 160, 11, 20);

        // 6
        rect(304, 200, 11, 20);
        rect(485, 200, 11, 20);

        // 7
        rect(304, 240, 11, 20);
        rect(485, 240, 11, 20);

        // 8
        rect(304, 280, 11, 20);
        rect(485, 280, 11, 20);

        // 9
        rect(304, 320, 11, 20);
        rect(485, 320, 11, 20);

        // 10
        rect(304, 360, 11, 20);
        rect(485, 360, 11, 20);

        // 11
        rect(304, 400, 11, 20);
        rect(485, 400, 11, 20);

        // 12
        rect(304, 440, 11, 20);
        rect(485, 440, 11, 20);

        // 13
        rect(304, 480, 11, 20);
        rect(485, 480, 11, 20);

        // 14
        rect(304, 520, 11, 20);
        rect(485, 520, 11, 20);

        // 15
        rect(304, 560, 11, 20);
        rect(485, 560, 11, 20);

        // 16
        rect(304, 600, 11, 20);
        rect(485, 600, 11, 20);

        // 17
        rect(304, 640, 11, 20);
        rect(485, 640, 11, 20);

        // 18
        rect(304, 680, 11, 20);
        rect(485, 680, 11, 20);

        // 19
        rect(304, 720, 11, 20);
        rect(485, 720, 11, 20);

        // 20
        rect(304, 760, 11, 20);
        rect(485, 760, 11, 20);

        // 21
        rect(304, 800, 11, 20);
        rect(485, 800, 11, 20);

        // 22
        rect(304, 840, 11, 20);
        rect(485, 840, 11, 20);

        // 23
        rect(304, 880, 11, 20);
        rect(485, 880, 11, 20);

        // Draw green grass borders
        fill(0, 180, 0);
        noStroke();
        rect(0, 0, 133, 900);
        rect(667, 0, 133, 900);

        fill(0, 180, 0);
        noStroke();
        rect(0, 0, 133, 900);
        rect(667, 0, 133, 900);

        fill(100,100,0);
        line(133,900,133,0);
    }

    @Override
    public void draw() {

    }

    /** Additional helper methods below */

}
