import processing.core.PApplet;

public class Paddle { //setting up the class

   private  int px;
   private int py;

    private PApplet canvas;
    
    public Paddle(int paddleX, int paddleY, PApplet c){ //constructor
        canvas = c;
        px = paddleX;
        py = paddleY;
    }
    public void display(){//setting up the paddle
        canvas.fill(108, 89, 128);
          canvas.rect (px(), py(), 130, 30);

    }

public void move(int mX, int mY){ //setting it so the paddle x and y coordinates are equal to the mouse x and y coordinates
        px = mX;
        py = mY;
    }
public int px(){
    return px;
}
public int py(){
    return py;
}
    

}