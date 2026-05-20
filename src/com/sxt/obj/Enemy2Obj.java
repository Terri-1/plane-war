package com.sxt.obj;

import com.sxt.Game1;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class Enemy2Obj extends  GameObj{
    int helthy=3;
    public Enemy2Obj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y+=speed;
        //我方飞机子弹和敌方大飞机碰撞
        for(ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())&&helthy>0){
shellObj.setX(-100);
shellObj.setY(-100);
GameUtils.removeList.add(shellObj);
helthy--;
            }else if(this.getRec().intersects(shellObj.getRec())&&helthy<=0){
                ExplodeObj explodeObj=new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);
                this.x=-100;
                this.y=-100;
                GameUtils.removeList.add(this);
                Game1.score+=20;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    public Enemy2Obj() {
        super();
    }

    public Enemy2Obj(Image img, int width, int height, int x, int y, double speed, Game1 frame) {
        super(img, width, height, x, y, speed, frame);
    }
}
