import processing.core.*;

public class App extends PApplet{
    public static void main(String[] args)  {
        PApplet.main("App");
    }
    float rectx = 225;
    int speed = 3;
    float ballx = 225;
    float bally = 1;
    int cspeed = 0;
    float recty = 400;
    float ballsize = 10;
    float ballspeed = 1;

    
    int rectx2 = 275;


    public void setup(){
        background(200);
    }

    public void settings(){
        size(500,500);
        
    }

    public void draw(){
        background(200);
        rect(rectx,recty,50,10);
        bally = bally + ballspeed;
        if (rectx <= 0){
            rectx = 0;
            rectx2 = 50;
        }
        if (rectx2 >= 500){
            rectx = 450;
            rectx2 = 500;
        }
        if (keyCode == RIGHT){
            rectx = (rectx + speed);
            rectx2 = (rectx2 + speed);
            
        }
         if (keyCode == LEFT){
            rectx = rectx - speed;
            rectx2 = (rectx2 - speed);
        }
        circle (ballx, bally, ballsize);
         
     
        println(constrain(ballx , rectx, rectx2));
        if (circleoverlapsrect()){
            ballspeed = -ballspeed;


        } else{
             ballspeed++;
        }
        
       

        
        


    }
    public boolean circleoverlapsrect(){
        float closestxonrect = constrain(ballx, rectx, rectx2);
        float closestyonrect = constrain(bally + 3, recty, recty + 10);
        if (dist(closestxonrect, closestyonrect, ballx, bally + 3) < ballsize/2){
            return true;
        } else{
            return false;
        }
    }
    
        
    }

