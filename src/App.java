// import java.util.ArrayList;
// import java.util.Scanner;

import processing.core.*;

public class App extends PApplet {
    Ball first;
    Paddle paddle;
    Brick board;
    // int x = (int)random(700);
    // int y = (int)random(700);
    boolean start;
    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        first = new Ball(400, 500, 10, 20, this);
        paddle = new Paddle(400, 70, this); 
        board = new Brick(250, 150, this);

    }

    public void settings() {
        size(800, 750);

    }

    public void draw() {
        background(192, 178, 207);
        fill(192, 178, 207);
        if (start) {
           // first.update();
           first.ballTesting(mouseX, mouseY);
            first.display();
            board.display();
            touching();
            
        
        } else {
            first.display();
            
        }
        paddle.px = mouseX;


        //fill(159, 138, 181);
       // rect(325, 200, 150, 50);

        //fill(220, 220, 220);
        //rect(335, 600, 70, 10);
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
            paddle.px =- 50;
            paddle.location();
        }
        if (keyCode == RIGHT){
            paddle.py =+50;
            paddle.location();
        }

    }

  public void touching(){
    if(first.x + 16 == board.x);
    System.out.println("touching");
     
  }
}