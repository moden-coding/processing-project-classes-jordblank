import processing.core.PApplet;

public class Paddle {

    int px;
    int py;

    private PApplet canvas;
    
    public Paddle(int paddleX, int paddleY, PApplet c){
        px = paddleX;
        py = paddleY;
    }
    public void location(){
          canvas.rect (px, py, 100, 50);

    }

public void paddleTesting(int mX, int mY){
        px = mX;
        py = mY;
    }
}