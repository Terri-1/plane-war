package com.sxt.obj;

import com.sxt.Game1;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class Boss3Obj extends GameObj {
    int helthy=15;

    public Boss3Obj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(x<=560){y+=speed/2;
        x+=speed;}
        else{
           if(x>0||x<270){ speed=-speed;x+=speed;}}
        for(ShellObj shellObj: GameUtils.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec()) && helthy > 0) {
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);
                helthy--;
            } else if (this.getRec().intersects(shellObj.getRec()) && helthy <= 0) {
                //碰撞之后爆炸
                ExplodeObj explodeObj = new ExplodeObj(x + 30, y + 150);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                System.out.println("boss3爆炸");
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);
                this.x = -100;
                this.y = -100;
                GameUtils.removeList.add(this);
                GameUtils.gameObjList.removeAll(GameUtils.removeList);
Game1.score+=150;
            }

        }}
    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    public Boss3Obj() {
        super();
    }

    public Boss3Obj(Image img, int width, int height, int x, int y, double speed, Game1 frame) {
        super(img, width, height, x, y, speed, frame);
    }
}
