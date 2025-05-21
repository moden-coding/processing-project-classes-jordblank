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
       


public void moveToRandom() {
    x = (int) canvas.random(0, canvas.width - 100); // chat
    y = (int) canvas.random(0, canvas.height - 200); 
}
}