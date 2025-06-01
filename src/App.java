import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

import processing.core.*;

public class App extends PApplet {
    ArrayList<Brick> brick = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Ball first;
    Paddle paddle;
    Brick board;
    int score = 0;
    String highscore;
    int x = (int) random(500);
    int y = (int) random(700);
    int lives = 3;
    int scene;
    boolean start;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        // for (int i = 0 && first.x += 110){
        // rect(x, y, 100, 50);
        // }
        first = new Ball(400, 650, 10, 20, this);
        paddle = new Paddle(340, 670, this);
        board = new Brick(250, 150, this);
        if (scene == 1) {
            initializeGrid();
        }
    }

    public void settings() {
        size(800, 750);

    }

    public void draw() {
        background(192, 178, 207);

        if (scene == 0) {
            showStart();
        }
        if (scene == 1) {
            gameStart();
        }
        if (scene == 2) {
            gamePlay();
        }
        if (lives == 0) {
            scene = 3;
            showEnd();
            highScore();
        }

    }

    public void keyPressed() {
        if (keyCode == UP) {
            scene = 1;
            initializeGrid();

        }
        if (keyCode == DOWN) {
            scene = 2;
        }

    }

    private void paddleCollision(Ball ball, Paddle paddle) {
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
            first.speedY = -abs(first.speedY);
            score++;
        }
    }

    private void initializeGrid() {
        int columns = 6;
        int rows = 5;
        int height = 50;
        int width = 100;
        int startx = 80;
        int starty = 70;
        for (int row = 0; row < rows; row++) { // chat gpt helped with this line
            for (int column = 0; column < columns; column++) { // chat gpt helped with this line
                int brickx = startx + column * (width + 10); // chat gpt helped with this line
                int bricky = starty + row * (height + 10);
                Brick b = new Brick(brickx, bricky, this);
                brick.add(b);
            }
        }

    }

    private void lives() {
        if (first.y > 750) {
            lives--;
            // initializeGrid();
        }
    }

    private void showStart() {
        lives = 3;
        background(192, 178, 207);
        textSize(50);
        fill(108, 89, 128);
        text("Block Breaker", 260, 280);
        textSize(30);
        fill(159, 138, 181);
        rect(290, 300, 230, 70);
        fill(108, 89, 128);
        textSize(20);
        text("High Score: " + highscore, 630, 40);
        text("Click up key to intialize", 308, 330);
        text("then down key to start!", 308, 355);
        text("Instructions:", 360, 400);
        textSize(15);
        text("1. Use mouse to move paddle", 318, 420);
        text("2. Goal is to move paddle in ", 325, 445);
        text("order to catch the ball", 340, 460);
        text("3. You have three lives :)", 330, 480);

    }

    private void showEnd() {
        background(192, 178, 207);
        fill(108, 89, 128);
        textSize(50);
        text("Game Over", 290, 290);
        textSize(20);
        text(" Click to restart", 340, 322);
        text("Score: " + score, 367, 350);
        text("High Score: " + highscore, 340, 380);

    }

    private void gameStart() {
        fill(192, 178, 207);
        if (scene == 1) {
            lives();
            first.display();
            paddle.display();
            board.ballCollision(first);
            paddleCollision(first, paddle);
            fill(108, 89, 128);
            textSize(30);
            text("Lives: " + lives, 550, 40);

            for (int i = brick.size() - 1; i >= 0; i--) {
                Brick b = brick.get(i);
                b.display();

                if (b.ballCollision(first)) {
                    brick.remove(i);
                    score += 10;
                    // first.speedY -= first.speedY;
                }
                if (brick.size() == 0) {
                    initializeGrid();
                }

            }
        }
    }

    private void gamePlay() {
        fill(192, 178, 207);
        if (scene == 2) {
            lives();
            first.update();
            first.display();
            paddle.display();
            paddle.move(mouseX, 670);
            board.ballCollision(first);
            paddleCollision(first, paddle);
            fill(108, 89, 128);
            textSize(30);
            text("Score: " + score, 650, 40);
            text("Lives: " + lives, 550, 40);

            for (int i = brick.size() - 1; i >= 0; i--) {
                Brick b = brick.get(i);
                b.display();

                if (b.ballCollision(first)) {
                    brick.remove(i);
                    score += 10;
                    // first.speedY -= first.speedY;
                }
                if (brick.size() == 0) {
                    initializeGrid();
                }

            }
        }

    }

    public void mousePressed() {
        if (scene == 1) {
            gameStart();
        }
        if (scene == 2) {
            gamePlay();
        }
        if (scene == 3) {
            scene = 1;
            lives = 3;
            score = 0;
            first = new Ball(400, 650, 10, 20, this);
            paddle = new Paddle(340, 670, this);
            initializeGrid();

        }
    }

 private void highScore(){
    try (Scanner scanner = new Scanner(Paths.get("score.txt"))) {
            while(scanner.hasNextLine()){
                String highscore = scanner.nextLine();
                System.out.println(highscore);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        if (scene == 3){
            if(score > highscore){
                highscore = score;
            }
        }
 }
}