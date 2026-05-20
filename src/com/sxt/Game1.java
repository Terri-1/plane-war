package com.sxt;

import com.sxt.obj.*;
import com.sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class Game1 extends JFrame {
    public static int state=0;
public static  int score=0;
    Bgobj bgObj;
    PlaneObj planeObj;
    ShellObj shellObj;
    Boss1Obj boss1Obj;
    Boss2Obj boss2Obj;
    Boss3Obj boss3Obj;
    BigbossObj bigbossObj;
    private BufferedImage bufferImage;
    private Graphics bufferGraphics;
    int count=1;

    //定义一个变量记录我方飞机索引
    public  static int plalneindex=0;
    public Game1() {
        initGame();


        // 模拟加载过程
        Timer loadingTimer = new Timer(3000, e -> {
            state = 1; // 假设加载需要3秒钟

            repaint();
        });
        loadingTimer.setRepeats(false);
        loadingTimer.start();
        //背景
        bgObj = new Bgobj(GameUtils.bgImg, 0, -6000, 2);
        //飞机
        planeObj = new PlaneObj(GameUtils.planeImg, 92, 84, 290, 550,10, 100, this);

       // shellObj = new ShellObj(GameUtils.shellImg, 41,73,planeObj.getX(),planeObj.getY(),5,this);
        bufferImage = new BufferedImage(600, 910, BufferedImage.TYPE_INT_ARGB);
        //添加boss
         boss1Obj=new Boss1Obj(GameUtils.Boss1Img,100,70,-200,50,1,this);
         boss2Obj=new Boss2Obj(GameUtils.Boss2Img,90,90,300-90,-130,2,this);
         boss3Obj=new Boss3Obj(GameUtils.Boss3Img,80,84,0,400,2,this);
         bigbossObj=new BigbossObj(GameUtils.BigbossImg,150,113,0,0,3,this);
        //所有元素放入集合
        GameUtils.gameObjList.add(bgObj);
       GameUtils.gameObjList.add(planeObj);
    plalneindex=GameUtils.gameObjList.indexOf(planeObj);//获取我方飞机索引
        bufferGraphics = bufferImage.getGraphics();
        int delay = 25; // 每帧的延迟时间，单位为毫秒
        Timer timer = new Timer(delay, e -> {
            if (state != 0 ||state!=3||state!=4) {
                // 更新游戏逻辑
                bgObj.move();
                createObj();
                System.out.println("状态：" + state);
                planeObj.paintself(bufferGraphics);

                repaint();
            } else {
                // 停止定时器，因为游戏已失败或胜利
                ((Timer)e.getSource()).stop();
            }
        });
        timer.start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 停止定时器
                timer.stop();
                // 释放资源
                bufferGraphics.dispose();
                bufferImage.flush();
                // 终止程序
                System.exit(0);
            }
        });
    }

    private void initGame() {
        this.setSize(600, 910);
        this.setLocationRelativeTo(null);
        setTitle("飞机大战1.0");
        setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
this.addMouseListener(new MouseListener() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==1){
            if(state==1){
                state=2;
            }else if(state==2){
                state=1;
            }
            else if(state==3||state==4){
               resetGame();

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
});
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        //将爆炸集合添加到所有元素集合中

        bufferGraphics.clearRect(0, 0, getWidth(), getHeight());
        GameUtils.gameObjList.addAll( GameUtils.explodeObjList);
        if (state == 0) {
            // 绘制加载界面的背景图片
            bufferGraphics.drawImage(GameUtils.loadingImg, 0, 0, this.getWidth(), this.getHeight(), this);
            GameUtils.drawWord(bufferGraphics, "正在加载...", Color.WHITE, 30, 400, 900);

        }
        else if(state==1)
       {
           for(int i=0;i<GameUtils.gameObjList.size();i++){
            GameUtils.gameObjList.get(i).paintSelf(bufferGraphics);
        }//将要移除的元素从所有元素列表中删除
           //血条
           bufferGraphics.setColor(Color.WHITE);
           bufferGraphics.fillRect(200, 40, 200, 10);
           bufferGraphics.setColor(Color.RED);
           bufferGraphics.fillRect(200, 40, planeObj.getHP() * 200 / 100, 10);
           GameUtils.gameObjList.removeAll(GameUtils.removeList);


        count++;}
        else if(state==2){

           bufferGraphics.drawImage(GameUtils.stopImg,0,0,null);
            GameUtils.drawWord(bufferGraphics,"游戏暂停",Color.YELLOW,30,230,300);
        }
        else if(state==3){
            bufferGraphics.drawImage(GameUtils.failImg,0,0,null);
            GameUtils.drawWord(bufferGraphics,"游戏失败",Color.RED,30,210,300);
            GameUtils.drawWord(bufferGraphics,"点击鼠标左键重新开始游戏",Color.GREEN,30,200,900);
        }
       else  if(state==4){
            bufferGraphics.drawImage(GameUtils.winImg,0,0,null);
            GameUtils.drawWord(bufferGraphics,"游戏胜利",Color.GREEN,30,230,300);
            GameUtils.drawWord(bufferGraphics,"点击鼠标左键重新开始游戏",Color.GREEN,30,200,900);

        } GameUtils.drawWord(bufferGraphics,score+"分",Color.yellow,40,40,100);
       g.drawImage(bufferImage, 0, 0, this);

    }
    public void resetGame() {
        // 重置游戏状态
        state = 1;

        // 重置分数
        score = 0;

        // 重置我方飞机生命值
        planeObj.setHP(100);

        // 清空游戏对象列表和移除列表
        GameUtils.gameObjList.clear();
        GameUtils.removeList.clear();
        GameUtils.explodeObjList.clear();
        GameUtils.shellObjList.clear();
        GameUtils.enemy1ObjList.clear();
        GameUtils.enemy2ObjList.clear();
        GameUtils.enemy2BulletobjList.clear();
        GameUtils.boss1BulletobjList.clear();
        GameUtils.boss2BulletobjList.clear();
        GameUtils.boss3BulletobjList.clear();
        GameUtils.bigbossBulletobjList.clear();

        // 重新添加背景和飞机对象
        bgObj = new Bgobj(GameUtils.bgImg, 0, -1800, 2);
        planeObj = new PlaneObj(GameUtils.planeImg, 92, 84, 290, 550, 10, 100, this);
        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);

        // 重置计数器
        count = 0;

        // 重绘界面
        repaint();
    }

    void createObj() {
        //子弹产生速度
        if (count % 10 == 0) {
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, 21, 42, planeObj.getX() + 37, planeObj.getY() - 50, 5, this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }

        //敌方飞机产生速度
        //小飞机
        if (count % 50 == 0) {
            int a = (int) (Math.random() * 10) * 60;
            GameUtils.enemy1ObjList.add(new Enemy1Obj(GameUtils.enemy1Img, 60, 43, a, 10, 5, this));
            GameUtils.gameObjList.add(GameUtils.enemy1ObjList.get(GameUtils.enemy1ObjList.size() - 1));
            System.out.println("敌机1出现");
        }
        //大飞机
        if (count % 25 == 0) {
            if (count % 100 == 0) {
                int a = (int) (Math.random() * 10) * 40;
                GameUtils.enemy2ObjList.add(new Enemy2Obj(GameUtils.enemy2Img, 100, 26, a, 10, 3, this));
                GameUtils.gameObjList.add(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size() - 1));
                System.out.println("敌机2出现");
            }
            if (GameUtils.enemy2ObjList.size() > 0) {
                //获取敌方飞机的位置
                int x = (GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size() - 1)).getX();
                int y = (GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size() - 1)).getY();
                GameUtils.enemy2BulletobjList.add(new Enemy2Bulletobj(GameUtils.enemy2BulletImg, 26, 33, x + 35, y + 55, 4, this));
                GameUtils.gameObjList.add(GameUtils.enemy2BulletobjList.get(GameUtils.enemy2BulletobjList.size() - 1));
            }

        }
//Boss1
        if(count==600&& (!GameUtils.gameObjList.contains(boss1Obj))){
            GameUtils.gameObjList.add(boss1Obj);
        }
        if(count==800&& (!GameUtils.gameObjList.contains(boss2Obj))){
            GameUtils.gameObjList.add(boss2Obj);
        }
        if(count==1200&& (!GameUtils.gameObjList.contains(boss3Obj))){
            GameUtils.gameObjList.add(boss3Obj);
        }
        if(count%40==0){
            if(GameUtils.gameObjList.contains(boss1Obj))
            {GameUtils.boss1BulletobjList.add(new Boss1Bulletobj(GameUtils.Boss1BulletImg,10,35,boss1Obj.getX()+40,boss1Obj.getY()+65,5,this));
        GameUtils.gameObjList.add(GameUtils.boss1BulletobjList.get(GameUtils.boss1BulletobjList.size()-1));}
        }
        if(count%40==0){
            if(GameUtils.gameObjList.contains(boss2Obj))
            {GameUtils.boss2BulletobjList.add(new Boss2Bulletobj(GameUtils.Boss2BulletImg,20,34,boss2Obj.getX()+30,boss2Obj.getY()+100,3,this));
            GameUtils.gameObjList.add(GameUtils.boss2BulletobjList.get(GameUtils.boss2BulletobjList.size()-1));}
        }
        if(count%25==0){
            if(GameUtils.gameObjList.contains(boss3Obj))
            {GameUtils.boss3BulletobjList.add(new Boss3Bulletobj(GameUtils.Boss3BulletImg,20,33,boss3Obj.getX()+30,boss3Obj.getY()+100,3,this));
                GameUtils.gameObjList.add(GameUtils.boss3BulletobjList.get(GameUtils.boss3BulletobjList.size()-1));}
        }
        if(count==1500&&(!GameUtils.gameObjList.contains(bigbossObj))){
            GameUtils.gameObjList.add(bigbossObj);
        }
        if(count%40==0){
            if(GameUtils.gameObjList.contains(bigbossObj))
            {GameUtils.bigbossBulletobjList.add(new BigbossBulletobj(GameUtils.BigbossBulletImg,30,50,bigbossObj.getX()+50,bigbossObj.getY()+100,3,this));
                GameUtils.gameObjList.add(GameUtils.bigbossBulletobjList.get(GameUtils.bigbossBulletobjList.size()-1));}
        }
    }
}