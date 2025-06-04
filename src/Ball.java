import processing.core.PApplet;

public class Ball { //setting up the class
    private int size;
    private int brick;
    private PApplet canvas;
    private int x = 200;
    private int y = 600;
    private boolean start = false;
    private int speedX;
    private int speedY;
    private int keyCode;
    private int color;

    public Ball(int xPos, int yPos, int sx, int sy, PApplet c){ //setting up the constructor
        
        x = xPos;
        y = yPos;
        speedX = sx;
        speedY = sy;
        size = 30;
        canvas = c;
        color = canvas.color(192, 178, 207);

}

    public void display() {//displaying the ball at its starting point
        canvas.circle (x(), y(), size());

    }

    public int size(){
        return size;
    }
   public void update(){//updating the balls speed
        x += speedX;
        y += speedY;

        if (x < 0 || x > 800){
            speedX *= -1;
        
        }
        if (y < 0 || y > 750){
            speedY *= -1;
        }        
    }

    // private void ballTesting(int mX, int mY){
    //     x = mX;
    //     y = mY;
    // }

    public int x() {
       return x;
    }

    public int y() {
        return y;
    }
    public int keyCode() {
        return keyCode;
    }
    public int color() {
        return color;
    }
    public boolean start() {
        return start;
    }
    public int brick() {
        return brick;
    }
    
   
    
     public void paddleCollision(Paddle paddle) { //checking to see if the ball and paddle are touching and if so it will send the ball in the other direction
        float ballLeft = x - size / 2;
        float ballRight = x + size / 2;
        float ballTop = y - size / 2;
        float ballBottom = y + size / 2;

        float paddleLeft = paddle.px();
        float paddleRight = paddle.px() + 130; // 90
        float paddleTop = paddle.py();
        float paddleBottom = paddle.py() + 30;

        if (ballRight > paddleLeft && ballLeft < paddleRight &&
                ballBottom > paddleTop && ballTop < paddleBottom) {
            speedY = -Math.abs(speedY);
        }
    }

    
}