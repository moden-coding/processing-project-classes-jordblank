import processing.core.PApplet;

public class Brick {//setting up the class
private int x;
private int y;
private int height = 50;
private int width = 100;
private PApplet canvas;

public Brick(int bx, int by, PApplet c){//constructor
        x = bx;
        y = by;
        canvas = c;

}
public void display(){//displaying bricks at desired x, y, heigth, and width 
    canvas.rect(x(), y(), width(), height());
   

}

       
public boolean ballCollision(Ball ball) { // chatgpt helped me with this //checking to see if the ball is touching any of the bricks
        float ballLeft = ball.x() - ball.size() / 2;
        float ballRight = ball.x() + ball.size() / 2;
        float ballTop = ball.y() - ball.size() / 2;
        float ballBottom = ball.y() + ball.size() / 2;

        float brickLeft = x;
        float brickRight = x + width;
        float brickTop = y;
        float brickBottom = y + height;

        if (ballRight > brickLeft && ballLeft < brickRight &&
                ballBottom > brickTop && ballTop < brickBottom) {
            return true;
        }
    return false;
    }
    private int x(){
        return x;
    }
     private int y(){
        return y;
    }
     private int width(){
        return width;
    }
    private int height(){
        return height;
    }
}