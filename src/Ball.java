import processing.core.PApplet;

public class Ball {
    int size;
    int brick;
    private PApplet canvas;
    int x = 100;
    int y = 200;
    int mouseX;
    int mouseY;
    boolean start = false;
    int key;
    int speed;
    int keyCode;

    public Ball(int xPos, int yPos, PApplet c){
        if (start == true){
        x = xPos;
        y = yPos;
        speed = 3;
        size = 30;
        canvas = c;
        color = canvas.color(192, 178, 207);
        canvas.circle(300, 300, mouseX);

    }
}

    public void display() {
        canvas.circle (x, y, size);

    }
   public void update(){
        x -= speed;
        y -= speed;
    }

    
}