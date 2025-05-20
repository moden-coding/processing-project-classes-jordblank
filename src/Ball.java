import processing.core.PApplet;

public class Ball {
    int size;
    int brick;
    private PApplet canvas;
    int x = 200;
    int y = 600;
    boolean start = false;
    int speedX;
    int speedY;
    int keyCode;
    int color;

    public Ball(int xPos, int yPos, int sx, int sy, PApplet c){
        
        x = xPos;
        y = yPos;
        speedX = sx;
        speedY = sy;
        size = 30;
        canvas = c;
        color = canvas.color(192, 178, 207);
        //canvas.circle(300, 300, size);

}

    public void display() {
        canvas.circle (x, y, size);

    }
   public void update(){
        x += speedX;
        y += speedY;

        if (x < 0 || x > 800){
            speedX *= -1;
        
        }
        if (y < 0 || y > 750){
            speedY *= -1;
        }        
    }

    public void ballTesting(int mX, int mY){
        x = mX;
        y = mY;
    }

    
}