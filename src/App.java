import processing.core.*;

public class App extends PApplet {
    Ball first;
    int x = 100;
    int y = 200;
    boolean start = false;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        background(192, 178, 207);
        first = new Ball(400, 500, this);

    }

    public void settings() {
        size(800, 750);

    }

    public void draw() {
        background(192, 178, 207);
        if (start == true) {
        first.update();
        }
        else{
            first.display();
        }
  
    
        fill(159, 138, 181);
        rect(325, 200, 150, 50);
    //     fill(255, 255, 255);
    //    // circle(400, 500, 30);

    }
    public void mousePressed() {

    }

    public void keyPressed() {
        if (keyCode == DOWN) {
            start = true;
            background(random(255), 0, 0);
        }
    }
     public void update(){
        x = (int)random(700);
        y = (int)random(700);



    }
}