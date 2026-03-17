import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    float rectx = 225;
    int speed = 5;
    float ballx = 225;
    float bally = 1;
    int cspeed = 0;
    float recty = 400;
    float ballsize = 10;
    float ballspeed = 3;
    float rectxmid = 250;
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
    int round = 0;
    int random = round % 2;
    boolean normal = false;
    boolean upmove = false;
    float ballxspeed = 3;

    int rectx2 = 275;

    public void setup() {
        background(200);
    }

    public void settings() {
        size(500, 500);

    }

    public void draw() {
        background(200);
        rect(rectx, recty, 50, 10);

        bally = bally + ballspeed;

        System.out.println(ballspeed);
        moveRectangle();

        if (bally == 500) {
            bally = 500;
            normal = false;
            ballspeed = 0;
        }
        if (rectright == true) {
            normal = false;

            rectx = (rectx + speed);
            rectx2 = (rectx2 + speed);
            rectxmid = rectxmid + speed;
        }

        if (rectleft == true) {
            normal = false;
            rectx = rectx - speed;
            rectx2 = (rectx2 - speed);
            rectxmid = rectxmid - speed;
        }
        if (bally < 0) {
            ballspeed = -ballspeed;
            bally = 0;
            normal = false;
            wallbounceright = false;
            wallbounceleft = false;

        }
        if (bally <= 0) {
            normal = false;
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
            ballx = 0;
            wallbounceright = false;
            wallbounceleft = true;
            leftmove = false;
            ballspeed = -ballspeed;
            wallbouncetop = false;
            normal = false;

        }
        if (wallbounceright == true) {
            bally = bally + 5;
            ballx = ballx - 5;
            ballxspeed = -ballxspeed;
            ballspeed = -ballspeed;

            normal = false;
            round = round + 1;
            leftmove = true;
            System.out.println("rightbounce");

        }
        if (wallbounceleft == true) {
            bally = bally - ballspeed;
            ballx = ballx - ballxspeed;
            ballxspeed = -ballxspeed;

            rightmove = true;
            System.out.println("leftbounce");

        }
        if (wallbouncetop == true) {
            bally = bally + 5;
            downmove = true;
            ballxspeed = -ballxspeed;
            ballspeed = -ballspeed;

        }
        // if (wallbouncetop == true){
        // downmove = true;
        // rightmove = false;
        // wallbounceleft = false;
        // wallbounceright = false;
        // leftmove = false;
        // ballspeed = -ballspeed;
        // ballx = 0;
        // bally = bally + ballspeed;
        // ballx = ballx - ballspeed;
        // normal = false;
        // round++;
        // System.out.println(round%2);

        // if (round%2 == 1){
        // downmove = true;
        // bally = bally + ballspeed;
        // // ballx = ballx + 2;
        // System.out.println("0");
        // System.out.println(ballx);

        // }
        // else if (round%2 <= 0){
        // downmove = true;
        // bally = bally + ballspeed;
        // // ballx = ballx - ballspeed;
        // System.out.println("1");

        // }

        wallbouncetop = false;
        wallbounceright = false;
        wallbounceleft = false;

        // }
        // wallbouncetop = false;
        // if (wallbouncetop = false){
        // normal = true;
        // }
        // if (normal = true){
        // System.out.println(normal);
        // bally = bally + 1;
        // // ballx = ballx + ballspeed;

        // }

        if (rightmove == true) {
            // bally = bally + 1;
            ballx = ballx + ballxspeed;
            ballx = ballx - ballspeed;
            // ballxspeed = -ballxspeed;

            normal = false;
            System.out.println("rightmove");
        }
        if (leftmove == true) {
            // bally = bally + 1;
            // ballxspeed = -ballxspeed;
            ballx = ballx - ballxspeed;
            bally = bally - ballspeed;
            normal = false;
            System.out.println("leftmove");

        }
        if (downmove == true) {
            // ballspeed = -ballspeed;
            bally = bally - ballspeed;
            // ballxspeed = -ballxspeed;
        }
        if (upmove == true) {

            bally = bally + ballspeed;
        }

        circle(ballx, bally, ballsize);

        if (midrectoverlap()) {
            ;
            ballspeed = -ballspeed;
            ballxspeed = -ballxspeed;
            normal = false;
            ballxspeedleft = true;
            ballxspeedright = false;
            rightmove = false;
            leftmove = true;
            downmove = false;

        }

        if (midrectright()) {
            ballspeed = -ballspeed;
            ballxspeed = -ballxspeed;
            System.out.println("right");
            rightmove = true;
            ballxspeedright = true;
            ballxspeedleft = false;
            leftmove = false;
            rightmove = true;
            normal = false;
            downmove = false;

        }
        if (midrectcenter()) {
            ballspeed = -ballspeed;
            System.out.println("center");
            rightmove = false;
            ballxspeedright = false;
            ballxspeedleft = false;
            leftmove = false;
            rightmove = false;
            normal = false;
            bally = bally + ballspeed;
            upmove = true;
        }
        if (ballxspeedright == true) {
            ballx = ballx - ballxspeed;
        }
        if (ballxspeedleft == true) {
            ballx = ballx + ballxspeed;
        }

        // if (circleoverlapsrect()){
        // ballspeed = -ballspeed;}
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

    public void moveRectangle() {
        if (rectx <= 0) {
            rectx = 0;
            normal = false;
            rectx2 = 50;
            ballxspeedleft = true;
        }
        if (rectx2 >= 500) {
            rectx = 450;
            normal = false;
            rectx2 = 500;
            ballxspeedright = true;
        }
    }

    public void keyPressed() {
        if (keyCode == ' ') {
            normal = false;
            bally = 0;
            ballx = 250;
            ballxspeed = -ballxspeed;
            wallbounceright = false;
            wallbounceleft = false;
            wallbouncetop = false;
            ballxspeedright = false;
            ballxspeedleft = false;
        }
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

    public boolean circleoverlapsrect() {
        float closestxonrect = constrain(ballx, rectx, rectx2);
        float closestyonrect = constrain(bally + 3, recty, recty + 10);

        if (dist(closestxonrect, closestyonrect, ballx, bally + 3) < ballsize / 2) {

            return true;
        } else {
            return false;
        }
    }

    public boolean midrectoverlap() {
        float midrect = constrain(ballx, rectx, rectxmid);
        float closestyonrect = constrain(bally + 5, recty, recty + 15);
        if (dist(midrect, closestyonrect, ballx, bally + 5) < ballsize / 2) {

            return true;
        } else {
            return false;
        }

    }

    public boolean midrectright() {
        float rightrect = constrain(ballx, rectxmid, rectx2);
        float closestyonrect = constrain(bally + 5, recty, recty + 15);
        if (dist(rightrect, closestyonrect, ballx, bally + 5) < ballsize / 2) {

            return true;
        } else {
            return false;
        }

    }

    public boolean midrectcenter() {
        float rightrect = constrain(ballx, rectx + 5, rectx - 5);
        float closestyonrect = constrain(bally + 5, recty, recty + 15);
        if (dist(rightrect, closestyonrect, ballx, bally + 5) < ballsize / 2) {

            return true;
        } else {
            return false;
        }

    }

}
