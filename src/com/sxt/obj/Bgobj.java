package com.sxt.obj;

import com.sxt.Game1;

import java.awt.*;

public class Bgobj extends GameObj {
    public Bgobj() {
        super();
    }

    public Bgobj(Image img, int width, int height, int x, int y, double speed, Game1 frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public Bgobj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y+=speed;
        if(y>=0){
            y=-6000;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
    public void move(){
        y+=speed;
        if(y>=0){
            y=-1800;
        }
    }

}
