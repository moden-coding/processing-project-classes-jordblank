import processing.core.*;

public class App extends PApplet {
    Ball first;
    Paddle paddle;
    // int x = (int)random(700);
    // int y = (int)random(700);
    boolean start;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        first = new Ball(400, 500, 10, 20, this);
        paddle = new Paddle(400, 70, this); 

    }

    public void settings() {
        size(800, 750);

    }

    public void draw() {
        background(192, 178, 207);
        fill(192, 178, 207);
        if (start) {
            first.update();
            first.display();
        
        } else {
            first.display();
            
        }
        paddle.x = mouseX;


        fill(159, 138, 181);
        rect(325, 200, 150, 50);

        fill(220, 220, 220);
        rect(335, 600, 70, 10);
        // fill(255, 255, 255);
        // circle(400, 500, 30);

    }

    public void keyPressed() {
        if (keyCode == DOWN) {
            start = true;
        if (keyCode == LEFT){

        }
        }
        if (keyCode == LEFT){
            paddle.x =- 50;
            paddle.location();
        }
        if (keyCode == RIGHT){
            paddle.y =+50;
            paddle.location();
        }

    }

    // public void touching(){
    //     if (first.x + 30 == 335 ){


    //     }
    // }

}