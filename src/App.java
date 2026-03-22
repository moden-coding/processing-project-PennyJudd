import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    float rectx = 200;
    int speed = 7;
    float ballx = 225;
    float bally = 1;
    
    float recty = 400;
    float ballsize = 10;
    float ballspeed = 2;
    float rectxmid = rectx + 30;
    boolean downmove = false;
    boolean rectleft = false;
    boolean rectright = false;
    boolean rightmove = false;
    boolean ballxspeedright = false;
    boolean leftmove = false;
    boolean ballxspeedleft = false;
    boolean wallbounceright = false;
    boolean wallbounceleft = false;
    boolean wallbouncetop = false;
    
    boolean normal = false;
    boolean upmove = false;
    float ballxspeed = 3;
    float rectx2 = rectx + 60;
    int count = 0;
    int scene = 1;
    int score = 0;
    boolean touching = false;
    int speedlevel = 1;
    
   

    public void setup() {
        background(0);
  
    }

    public void settings() {
        size(500, 500);

    }

    public void draw() {
        background(0);
       
       
        
     // BallBounceTopThings();
        // if (count >= 2 && count < 10){
        //     ballspeed = 5;
        // }
       
        
     
        

        wallbouncetop = false;
        wallbounceright = false;
        wallbounceleft = false;
       
       
        if (scene ==1){
            textSize(40);
            fill(0,255,255);
           
            text("PRESS Z TO START", 100, 200);
            textSize(25);
            text("USE ARROW KEYS TO MOVE LEFT AND RIGHT", 15, 400);

        }
        else if (scene == 2){
       
        fill(255);
        increasingspeed(5);
        System.out.println(ballspeed);
        moveRectangle();
        rectHitWall();
        ballHitWall();
        ballPastWall();
        WallBounce();
     
        BallMovement();
        rect(rectx, recty, 60, 10);
        
        bally = bally + ballspeed;
        circle(ballx, bally, ballsize);
        fill(255,0,0);
        text("SCORE: " + (score/3), 25, 50);
       
        


        }
        else if (scene == 3){
            
            textSize(75);
            fill(255);
            text("GAME OVER", 70, 250);
            textSize(30);
            fill(250,0,0);
            text("CLICK SPACE TO TRY AGAIN", 85, 450);
            text("SCORE: " + (score/3), 185, 75);
           
        }                                              
        //  These are my scenes
        
       
       if (bally >= 500){
                scene = 3;
            }

        
        
        
        
        // if (midrectoverlap()) {
        //     bally = 395;
        
        //     ballspeed = -ballspeed;
        //     System.out.println("left");

        //     // ballxspeed = -ballxspeed;
    
        //     // ballxspeedleft = true;
        //     // ballxspeedright = false;
        //     rightmove = false;
        //     leftmove = true;
        //     downmove = false;

        // }

        // if (midrectright()) {
        //     ballspeed = -ballspeed;
        //       bally = 395;
        
          
        //     // ballxspeed = -ballxspeed;
        //     // System.out.println("right");
        //     rightmove = true;
        //     // ballxspeedright = true;
        //     // ballxspeedleft = false;
        //     leftmove = false;
        //     // rightmove = true;
        //     // normal = false;
        //     downmove = false;
          

        // }
        
        // if (midrectcenter()) {
        //     ballspeed = -ballspeed;
        //     System.out.println("center");
        //     bally = bally - ballspeed;
        // //     System.out.println("center");
        //     rightmove = false;
        // //     ballxspeedright = false;
        // //     ballxspeedleft = false;
        //     leftmove = false;
        // //     rightmove = false;
        // //     normal = false;
        // //     bally = bally + ballspeed;
        // //     upmove = true;
        // }
        // if (ballxspeedright == true) {
        //     ballx = ballx - ballxspeed;
        // }
        // if (ballxspeedleft == true) {
        //     ballx = ballx + ballxspeed;
        // }

// This is for when the circle touches the paddle

        if (circleoverlapsrect()){
            count = count + 1;
            count = count - 1;
        
        ballspeed = -ballspeed;
        bally = 394;
         score = score + 3;
         speedlevel = speedlevel + 3;
        
      
        
        
       
        
     
        if (count%2 == 0){
            //  bally = 395;
            leftmove = true;
            rightmove = false;
            
            
        }
        if (count%2 == 1){
            //  bally = 395;
            leftmove = false;
            rightmove = true;
            
        }
        
    
    
    }
        else if (ballspeed == 0) {
            ballspeed = -ballspeed;

        }
        // else if(ballx == 500){
        // rightmove = false;
        // }

        // else if (ballspeed > 0){
        // ballspeed++;

        // }

    }
    // public void highscore(int lastscore, int highest){
    //     if (lastscore >= 0 && scene == 3){
    //         highest = lastscore;
    //         System.out.println("working");
    //     int topscore = lastscore;
    //     text("HIGH SCORE: " + lastscore, 100,250);
    //     }
    //     else if (lastscore > highest){
    //         lastscore = highest;
    //         System.out.println(highest);
    //     }
    // }
   
    public void increasingspeed(int end){
       
    if (ballspeed <= end && bally <= 0){
        ballspeed = ballspeed - 1;
        System.out.println(ballspeed);
    } else if (ballspeed > end){
        ballspeed = end;
    }
// The speed increases to a set limit by a parameter every time it bounces off the top

    }
// The rectangle does not go through the walls and stops when it reaches them
    public void rectHitWall(){
          if (rectright == true) {
            

            rectx = (rectx + speed);
            rectx2 = (rectx2 + speed);
            rectxmid = rectxmid + speed;
          }

        if (rectleft == true) {
           
           
            rectx = rectx - speed;
            rectx2 = rectx2 - speed;
            rectxmid = rectxmid - speed;
        }}
        public void ballPastWall(){
            if (bally <= 0) {
          
            wallbouncetop = true;
            rightmove = false;
            wallbounceleft = false;
            wallbounceright = false;
            leftmove = false;
            
            
            if (bally >= 0) {
                normal = false;
            }
            

        }
        if (ballx >= 500) {
            ballx = 500;
            wallbounceright = true;
            rightmove = false;
            ballspeed = -ballspeed;
            
            wallbounceleft = false;
            wallbouncetop = false;
            normal = false;

        }
        if (ballx <= 0) {
           

            
            ballx = 1;
            wallbounceright = false;
            wallbounceleft = true;
            leftmove = false;
            ballspeed = -ballspeed;
            wallbouncetop = false;
            normal = false;

        }
        }
    
// This is how the rectangle moves 
    public void moveRectangle() {
        if (rectx <= 0) {
            rectx = 0;
           
            rectx2 = 50;
            ballxspeedleft = true;
            
        }
        if (rectx2 >= 500) {
            rectx = 450;
            
            rectx2 = 500;
            ballxspeedright = true;
        }
    }

// This is how the ball moves
    public void BallMovement(){
        if (rightmove == true) {
            bally = bally + 1;
            ballx = ballx + ballxspeed;
            ballx = ballx - ballspeed;
            // ballxspeed = -ballxspeed;

            
            // System.out.println("rightmove");
        }
        if (leftmove == true) {
            bally = bally + 1;
            // ballxspeed = -ballxspeed;
            ballx = ballx - ballxspeed;
            bally = bally + ballspeed;
            
            // System.out.println("leftmove");

        }
        if (downmove == true) {
            ballspeed = -ballspeed;
            bally = bally - ballspeed;
            ballxspeed = -ballxspeed;
        }
        // if (upmove == true) {

        //     bally = bally + ballspeed;
        // }

    }

// These next methods ensures the ball bounces off the walls in a different direction
    public void ballHitWall(){
        if (bally == 500) {
            bally = 500;
            normal = false;
            ballspeed = 0;
        }
       
        if (bally <= 0) {
            ballspeed = -ballspeed;
            bally = 0;
            bally = bally + ballspeed;
          
        }
    }
    public void WallBounce(){
           
        if (wallbounceright == true) {
            bally = bally + ballspeed;
            ballx = ballx - 5;
            ballxspeed = -ballxspeed;
            ballspeed = -ballspeed;

            // normal = false;
            // round = round + 1;
            leftmove = true;
            
            // wallbouncetop = false;
            // ballx = ballx + 1;
           
            // bally = bally + ballspeed;
            // ballx = ballx + ballxspeed;
            // ballxspeed = -ballxspeed;

            // rightmove = true;

        }
        if (wallbounceleft == true) {
            wallbouncetop = false;
            ballx = ballx + 1;
           
            bally = bally - ballspeed;
            ballx = ballx - ballxspeed;
            ballxspeed = -ballxspeed;

            rightmove = true;
          

        }
        if (ballx <= 1){
            wallbounceleft = true;
            
            downmove = false;
       
     rightmove = true;
     ballxspeedright = false;
     leftmove = false;
     ballxspeedleft = false;
     wallbounceright = false;
     
     wallbouncetop = false;
     
     
     upmove = false;
     ballxspeed = 3;
     rectx2 = rectx + 50;
    }
        if (wallbouncetop == true) {
            bally = bally + 5;
            
            downmove = true;
            ballxspeed = -ballxspeed;
            ballspeed = -ballspeed;

        }
    }
    // public void BallBounceTopThings(){
    //     if (wallbouncetop == true){
    //     downmove = true;
    //     rightmove = false;
    //     wallbounceleft = false;
    //     wallbounceright = false;
    //     leftmove = false;
    //     ballspeed = -ballspeed;
    //     ballx = 0;
    //     bally = bally + ballspeed;
    //     ballx = ballx - ballspeed;
    //     normal = false;
    //     round++;
    //     // System.out.println(round%2);

    //     if (round%2 == 1){
    //     downmove = true;
    //     bally = bally + ballspeed;
    //     // ballx = ballx + 2;
    //     // System.out.println("0");
    //     // System.out.println(ballx);

    //     }
    //     else if (round%2 <= 0){
    //     downmove = true;
    //     bally = bally + ballspeed;
    //     // ballx = ballx - ballspeed;
       

    //     }}
    // }


    public void keyPressed() {

    // This is the reset button
        if (keyCode == ' ') {
    count = 0;
     rectx = 225;
     speed = 7;
     ballx = 225;
     bally = 1;
     recty = 400;
     ballsize = 10;
    ballspeed = 2;
     rectxmid = rectx + 25;
     downmove = false;
     rectleft = false;
     rectright = false;
     rightmove = false;
     ballxspeedright = false;
     leftmove = false;
     ballxspeedleft = false;
     wallbounceright = false;
     wallbounceleft = false;
     wallbouncetop = false;
     
     normal = false;
     upmove = false;
     ballxspeed = 3;
     rectx2 = rectx + 50;
     scene = 2;
     score = 0;
     speedlevel = 1;
        }
        if (key == 'z'){
            scene++;
        }

    // This moves the rectangle
        if (keyCode == LEFT) {
            rectleft = true;

        }
        if (keyCode == RIGHT) {
            rectright = true;

        }
    }

    public void keyReleased() {
        if (keyCode == LEFT) {
            rectleft = false;
            wallbounceright = false;
        }
        if (keyCode == RIGHT) {
            rectright = false;
            wallbounceright = false;
        }
    }
// These are for the circle and rectangle overlapping
    public boolean circleoverlapsrect() {
        float closestxonrect = constrain(ballx, rectx, rectx2);
        float closestyonrect = constrain(bally + 3, recty + 1, recty + 10);

        if (dist(closestxonrect, closestyonrect, ballx, bally + 3) < ballsize / 2) {
            count++;

            return true;
        } else {
            return false;
        }
    }}

    // These are the commented out code for when I wanted the side of the paddle that the ball hit to affect the direction

    // public boolean midrectoverlap() {
    //     float midrect = constrain(ballx, rectx, rectxmid);
    //     float closestyonrect = constrain(bally + 5, recty, recty + 15);
    //     if (dist(midrect, closestyonrect, ballx, bally + 5) < ballsize / 2) {
    //             // System.out.println(midrect);

    //     if (rectx == 500 && dist(midrect, closestyonrect, ballx, bally + 5) < ballsize / 2){
            
    //         return true;
    //     }
    //     if (ballx >= 1 && ballx <= 10 && dist(midrect, closestyonrect, ballx, bally + 5) < ballsize / 2){
    //         // System.out.println("It works");
    //         return true;
            
    //     }
        
    //         return true;
           
    //     } else {
               
    //         return false;
    //     }

    // }

//     public boolean midrectright() {
//         float rightrect = constrain(ballx, rectxmid, rectx2);
//         float closestyonrect = constrain(bally + 5, recty, recty + 15);
//         if (dist(rightrect, closestyonrect, ballx, bally + 5) < ballsize / 2) {
//             // System.out.println(rectright);
//         if (ballx >= 0 && ballx <= 10){
//             return false;
//         }

            
//             return true;
//         }
        
           
        
//         else {
            
//             return false;
       
           
//         }

//     }

//     public boolean midrectcenter() {
//         float centerrect = constrain(ballx, rectx + 5, rectx - 5);
//         float closestyonrect = constrain(bally + 5, recty, recty + 15);
//         if (dist(centerrect, closestyonrect, ballx, bally + 5) < ballsize / 2) {
            

//             return true;
//         } else {
//             return false;
//         }

//     }

// }
