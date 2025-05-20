import processing.core.PApplet;

public class Brick {
int x;
int y;
private PApplet canvas;

public Brick(int bx, int by, PApplet c){
        x = bx;
        y = by;
        canvas = c;

}
public void display(){
    canvas.rect(x, y, 100, 50);
   

}
       
}

