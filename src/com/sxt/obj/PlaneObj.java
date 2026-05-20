package com.sxt.obj;

import com.sxt.Game1;
import com.sxt.utils.GameUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlaneObj extends GameObj {
Boss1Obj boss1Obj=new Boss1Obj();
Boss2Obj boss2Obj=new Boss2Obj();

    public PlaneObj(Image img, int width, int height, int x, int y, double speed,int HP, Game1 frame) {
        super(img, width, height, x, y, speed,HP, frame);
        this.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveRight();
                        break;
                    case KeyEvent.VK_UP:
                        moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        moveDown();
                        break;
                    default:
                        break;
                }

            }
        });

        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }

    private void moveLeft() {

        x -= speed;
        System.out.println("left"+x);
        if (x < 0) {
            x = 0;
        }

    }

    private void moveRight() {
        x += speed;
        System.out.println("right");
        if (x > frame.getWidth() - width) {
            x = frame.getWidth() - width;
        }
    }

    private void moveUp() {
        y -= speed;
        System.out.println("up");
        if (y < 0) {
            y = 0;
        }
    }

    private void moveDown() {
        y += speed;
        System.out.println("down");
        if (y > frame.getHeight() - height) {
            y = frame.getHeight() - height;
        }
    }


    public void paintself(Graphics g) {
        super.paintSelf(g);

        //进行碰撞检测
 //我方飞机和小飞机碰撞
        if(HP<=0){
           Game1. state=3;
        }
        for (Enemy1Obj enemy1Obj : GameUtils.enemy1ObjList) {
            if (this.getRec().intersects(enemy1Obj.getRec())) {
                //碰撞之后爆炸
                ExplodeObj explodeObj=new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                enemy1Obj.setX(-100);
                enemy1Obj.setY(-100);
               HP--;
                GameUtils.removeList.add(enemy1Obj);
            }
        }

        // 我方飞机和大飞机碰撞
        for (Enemy2Obj enemy2Obj : GameUtils.enemy2ObjList) {
            if (this.getRec().intersects(enemy2Obj.getRec())) {
                //碰撞之后爆炸
                ExplodeObj explodeObj=new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                enemy2Obj.setX(-100);
                enemy2Obj.setY(-100);
              HP -= 2;
                GameUtils.removeList.add(enemy2Obj);
            }
        }

        // 我方飞机与敌方大飞机子弹碰撞
        for (Enemy2Bulletobj enemy2Bulletobj : GameUtils.enemy2BulletobjList) {
            if (this.getRec().intersects(enemy2Bulletobj.getRec())) {
                enemy2Bulletobj.setX(-100);
                enemy2Bulletobj.setY(-100);
                HP -= 1;
                GameUtils.removeList.add(enemy2Bulletobj);
            }
        }
        //与Boss碰撞


        if(this.getRec().intersects(boss1Obj.getRec())){
            //碰撞之后爆炸
            ExplodeObj explodeObj=new ExplodeObj(x,y);
            GameUtils.explodeObjList.add(explodeObj);
            GameUtils.removeList.add(explodeObj);
            System.out.println("与boss1碰撞");
            boss1Obj.setX(-100);
            boss1Obj.setY(-100);

            GameUtils.removeList.add(this);
            HP-=10;
        }
        if(this.getRec().intersects(boss2Obj.getRec())){
            //碰撞之后爆炸
            ExplodeObj explodeObj=new ExplodeObj(x,y);
            GameUtils.explodeObjList.add(explodeObj);
            GameUtils.removeList.add(explodeObj);
            boss2Obj.setX(-100);
            boss2Obj.setY(-100);
            HP-=10;
        }
        //与boss子弹碰撞
        for (Boss1Bulletobj boss1Bulletobj : GameUtils.boss1BulletobjList) {
            if (this.getRec().intersects(boss1Bulletobj.getRec())) {
                //碰撞之后爆炸
                ExplodeObj explodeObj=new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                boss1Bulletobj.setX(-100);
                boss1Bulletobj.setY(-100);
                HP-=2;
                GameUtils.removeList.add(boss1Bulletobj);
            }
        }
        for (Boss2Bulletobj boss2Bulletobj : GameUtils.boss2BulletobjList) {
            if (this.getRec().intersects(boss2Bulletobj.getRec())) {
                //碰撞之后爆炸
                ExplodeObj explodeObj=new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                boss2Bulletobj.setX(-100);
                boss2Bulletobj.setY(-100);
                HP-=2;
                GameUtils.removeList.add(boss2Bulletobj);
            }
        }
        for (Boss3Bulletobj boss3Bulletobj : GameUtils.boss3BulletobjList) {
            if (this.getRec().intersects(boss3Bulletobj.getRec())) {
                //碰撞之后爆炸
                ExplodeObj explodeObj=new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                boss3Bulletobj.setX(-100);
                boss3Bulletobj.setY(-100);
                HP-=2;
                GameUtils.removeList.add(boss3Bulletobj);
            }
        }
        for (BigbossBulletobj bigbossBulletobj : GameUtils.bigbossBulletobjList) {
            if (this.getRec().intersects(bigbossBulletobj.getRec())) {
                //碰撞之后爆炸
                ExplodeObj explodeObj=new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                bigbossBulletobj.setX(-100);
                bigbossBulletobj.setY(-100);
                HP-=2;
                GameUtils.removeList.add(bigbossBulletobj);
            }
        }

    }


    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}