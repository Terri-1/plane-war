package com.sxt.obj;

import com.sxt.Game1;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class Boss2Obj extends GameObj{int helthy=10;
    public Boss2Obj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);

    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(y<200){
            y+=2;
        }else{
            x+=speed;
            if(x>600||x<10){
                speed=-speed;
            }
        }

        y+=speed;
        for(ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())&&helthy>0){
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);
                helthy--;
            }else if(this.getRec().intersects(shellObj.getRec())&&helthy<=0){
                //碰撞之后爆炸
                ExplodeObj explodeObj=new ExplodeObj(x+40,y+50);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                System.out.println("boss2爆炸");

                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);
                this.x=-100;
                this.y=-100;
                GameUtils.removeList.add(this);

            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    public Boss2Obj() {
        super();
    }

    public Boss2Obj(Image img, int width, int height, int x, int y, double speed, Game1 frame) {
        super(img, width, height, x, y, speed, frame);
    }
}
