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
    int x = (int) random(500);
    int y = (int) random(700);
    int lives = 3;
    int scne;
    boolean start;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        // for (int i = 0 && first.x += 110){
        // rect(x, y, 100, 50);
        // }
        first = new Ball(400, 500, 10, 20, this);
        paddle = new Paddle(350, 670, this);
        board = new Brick(250, 150, this);
        initializeGrid();
    }

    public void settings() {
        size(800, 750);

    }

    public void draw() {
        background(192, 178, 207);
       
        // brick.add(board);
        //board.display();
        fill(192, 178, 207);
        if (start) {
            first.update();
            // first.ballTesting(mouseX, mouseY);
            first.display();
            // board.display();
            paddle.display();
            // touching();
            paddle.move(mouseX, 670);
            ballCollision(first, board);
            paddleCollision(first, paddle);
            fill(108, 89, 128);

        } else {
            first.display();

        }
         textSize(30);
        text("Score: " + score, 660, 40);
        text("Lives: " + lives, 550, 40);

        //disappear();
        for (int i = brick.size() - 1; i >= 0; i--) {
            Brick b = brick.get(i);
            b.display();

            if(ballCollision(first, b)){
                brick.remove(i);
                score += 10;
               // first.speedY -= first.speedY;
            }
            if(brick.size() == 0 ){
                initializeGrid();
            }
            

            }
        }
    
    public void keyPressed() {
        if (keyCode == UP) {
            start = true;

        }

    }

    // public void touching(){
    // if(first.x + 16 == board.x){
    // board.x = (int)random(500);

    // }
    // if (first.y + 16 == board.y){
    // board.y = (int)random(500);

    // }
    // }


    private boolean ballCollision(Ball ball, Brick brick) { // chatgpt helped me with this
        float ballLeft = ball.x - ball.size / 2;
        float ballRight = ball.x + ball.size / 2;
        float ballTop = ball.y - ball.size / 2;
        float ballBottom = ball.y + ball.size / 2;

        float brickLeft = brick.x;
        float brickRight = brick.x + 100;
        float brickTop = brick.y;
        float brickBottom = brick.y + 50;

        if (ballRight > brickLeft && ballLeft < brickRight &&
                ballBottom > brickTop && ballTop < brickBottom) {
           
            
            return true;

        }
    return false;
    }

    private void paddleCollision(Ball ball, Paddle paddle) { // modified the chatgt code from above
        float ballLeft = first.x - first.size / 2;
        float ballRight = first.x + first.size / 2;
        float ballTop = first.y - first.size / 2;
        float ballBottom = first.y + first.size / 2;

        float paddleLeft = paddle.px;
        float paddleRight = paddle.px + 130; // 90
        float paddleTop = paddle.py;
        float paddleBottom = paddle.py + 30;

        if (ballRight > paddleLeft && ballLeft < paddleRight &&
                ballBottom > paddleTop && ballTop < paddleBottom) {
            first.speedY = -abs(first.speedY); // chatgpt helped me with the absolute command
            score++;

        }

    }



    public void initializeGrid() {
        int columns = 6;
        int rows = 5;
        int height = 50;
        int width = 100;
        int startx = 80;
        int starty = 70;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int brickx = startx + column * (width + 10);
                int bricky = starty + row * (height + 10);
                Brick b = new Brick(brickx, bricky, this);
                brick.add(b);
                // rect(brickx, bricky, width, height);
            }
            // brick.add(board);
        }
    }

    public void lives() {
        if (first.y > 750) {
            lives--;
            //initializeGrid();
        }
    }
    // private void disappear(){
    //      for (int i = brick.size() - 1; i >= 0; i--) {
    //         Brick b = brick.get(i);
    //         if(ballCollision(first, b)){
    //             brick.remove(i);
    //             score += 10;
    //         }
    //     }
    // }
}