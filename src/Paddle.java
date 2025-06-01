import processing.core.PApplet;

public class Paddle {

    int px;
    int py;

    private PApplet canvas;
    
    public Paddle(int paddleX, int paddleY, PApplet c){
        canvas = c;
        px = paddleX;
        py = paddleY;
    }
    public void display(){
        canvas.fill(108, 89, 128);
          canvas.rect (px, py, 130, 30);

    }

public void move(int mX, int mY){
        px = mX;
        py = mY;
    }
    


    // public int x(){
    //     return px;
    // }
}