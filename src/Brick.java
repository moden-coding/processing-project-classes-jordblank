import processing.core.PApplet;

public class Brick {
int x;
int y;
int height = 50;
int width = 100;
private PApplet canvas;

public Brick(int bx, int by, PApplet c){
        x = bx;
        y = by;
        canvas = c;

}
public void display(){
    canvas.rect(x, y, width, height);
   

}

       
public boolean ballCollision(Ball ball) { // chatgpt helped me with this
        float ballLeft = ball.x - ball.size / 2;
        float ballRight = ball.x + ball.size / 2;
        float ballTop = ball.y - ball.size / 2;
        float ballBottom = ball.y + ball.size / 2;

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
}