package com.sxt.obj;

import com.sxt.Game1;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class Boss2Bulletobj extends GameObj{
    int helthy=2;
    public Boss2Bulletobj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
       //实现追踪功能
        this.y+=speed;
     this.x-= (  this.x- GameUtils.gameObjList.get(Game1.plalneindex).getX())/30;

        for(ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())&&helthy>0){
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);
                helthy--;
            }else if(this.getRec().intersects(shellObj.getRec())&&helthy<=0){
                //碰撞之后爆炸
                ExplodeObj explodeObj=new ExplodeObj(x+40,y+70);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                System.out.println("boss2子弹爆炸");

                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);
                this.x=-100;
                this.y=-100;
                GameUtils.removeList.add(this);
Game1.score+=5;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    public Boss2Bulletobj() {
        super();
    }

    public Boss2Bulletobj(Image img, int width, int height, int x, int y, double speed, Game1 frame) {
        super(img, width, height, x, y, speed, frame);
    }
}
