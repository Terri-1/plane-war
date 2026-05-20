package com.sxt.obj;

import com.sxt.Game1;

import java.awt.*;

public class ShellObj extends GameObj {
    public ShellObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y-=speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    public ShellObj() {
        super();
    }

    public ShellObj(Image img, int width, int height, int x, int y, double speed, Game1 frame) {
        super(img, width, height, x, y, speed, frame);
    }
}
