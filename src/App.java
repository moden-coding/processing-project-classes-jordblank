import java.util.ArrayList;
import java.util.Scanner;

import processing.core.*;



public class App extends PApplet {
    ArrayList<Brick> brick = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Ball first;
    Paddle paddle;
    Brick board;
    int score = 0;
    int x = (int)random(500);
    int y = (int)random(700);
    boolean start;
    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        first = new Ball(400, 500, 10, 20, this);
        paddle = new Paddle(350, 670, this); 
        board = new Brick(250, 150, this);

    }

    public void settings() {
        size(800, 750);

    }

    public void draw() {
        background(192, 178, 207);
        fill(192, 178, 207);
        if (start) {
           first.update();
           //first.ballTesting(mouseX, mouseY);
            first.display();
            board.display();
            paddle.display();
            //touching();
            paddle.paddleTesting(mouseX, 670);
            ballCollision(first, board);
            paddleCollision(first, paddle);
            fill(108, 89, 128);
            textSize(30);
            text("Score: " + score, 660, 40);
            
        
        } else {
            first.display();
            
         }
        // paddle.px = mouseX;


        //fill(159, 138, 181);
       // rect(325, 200, 150, 50);

        //fill(220, 220, 220);
        //rect(335, 600, 70, 10);
        // fill(255, 255, 255);
        // circle(400, 500, 30);

    }

    public void keyPressed() {
        if (keyCode == UP) {
            start = true;
       
        }
        if (keyCode == LEFT){
             paddle.px -= 40;
            paddle.display();
        }
        if (keyCode == RIGHT){
            paddle.px += 40;
            paddle.display();
        }

    }

//   public void touching(){
//     if(first.x + 16 == board.x){
//         board.x = (int)random(500);
        
   
//   }
//     if (first.y + 16 == board.y){
//         board.y = (int)random(500);

//     }
// }
    private void  ballCollision(Ball ball, Brick brick) { //chatgpt helped me with this
        float ballLeft = ball.x - ball.size / 2;
        float ballRight = ball.x + ball.size / 2;
        float ballTop = ball.y - ball.size / 2;
        float ballBottom = ball.y + ball.size / 2;

        float brickLeft = brick.x;
        float brickRight = brick.x + 100;
        float brickTop = brick.y;
        float brickBottom = brick.y + 50;

        if (ballRight > brickLeft && ballLeft < brickRight &&
        ballBottom > brickTop && ballTop < brickBottom){
        brick.moveToRandom();
        score += 10;
    }

}
private void  paddleCollision(Ball ball, Paddle paddle) { //modified the chatgt code from above
        float ballLeft = first.x - first.size / 2;
        float ballRight = first.x + first.size / 2;
        float ballTop = first.y - first.size / 2;
        float ballBottom = first.y + first.size / 2;

        float paddleLeft = paddle.px;
        float paddleRight = paddle.px + 130; //90
        float paddleTop = paddle.py;
        float paddleBottom = paddle.py + 30;

        if (ballRight > paddleLeft && ballLeft < paddleRight &&
        ballBottom > paddleTop && ballTop < paddleBottom){
            first.speedY = -abs(first.speedY); //chatgpt helped me with the absolute command
            score++;
        
    }

}
}