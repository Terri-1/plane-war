package com.sxt.utils;

import com.sxt.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class   GameUtils {


    //绘制文字
    public  static void drawWord(Graphics gImage,String str,Color color,int size,int x,int y){
        gImage.setColor(color);
        gImage.setFont(new Font("仿宋",Font.BOLD,size));
        gImage.drawString(str,x,y);
    }

    //获取背景图片
    public static Image loadingImg=Toolkit.getDefaultToolkit().getImage("imgs\\bg1.jpg");
    public  static  Image bg1Img= Toolkit.getDefaultToolkit().getImage("imgs\\bg5.jpg");
    public  static  Image stopImg= Toolkit.getDefaultToolkit().getImage("imgs\\bg4.png");
    public  static  Image winImg= Toolkit.getDefaultToolkit().getImage("imgs\\bg3.png");
    public  static  Image failImg= Toolkit.getDefaultToolkit().getImage("imgs\\bg2.png");
    public  static  Image bgImg= Toolkit.getDefaultToolkit().getImage("imgs\\bg0.jpg");
    public  static  Image bossImg= Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    public  static  Image esplodeImg= Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
    public  static  Image planeImg= Toolkit.getDefaultToolkit().getImage("imgs\\主角飞机（完成）.png");
    public  static  Image enemy1Img= Toolkit.getDefaultToolkit().getImage("imgs\\小飞机.png");
    public  static  Image enemy2Img= Toolkit.getDefaultToolkit().getImage("imgs\\大飞机.png");
    public  static  Image Boss1Img= Toolkit.getDefaultToolkit().getImage("imgs\\Boss1.png");
    public  static  Image Boss2Img= Toolkit.getDefaultToolkit().getImage("imgs\\BOSS2.png");
    public  static  Image Boss3Img= Toolkit.getDefaultToolkit().getImage("imgs\\Boss3.png");
    public  static  Image BigbossImg= Toolkit.getDefaultToolkit().getImage("imgs\\BOSS.png");
    //子弹资源
    public  static  Image shellImg= Toolkit.getDefaultToolkit().getImage("imgs\\zidan1.png");
    public static Image enemy2BulletImg=Toolkit.getDefaultToolkit().getImage("imgs\\zidan2.png");
    public  static  Image BigbossBulletImg= Toolkit.getDefaultToolkit().getImage("imgs\\Boss子弹\\4.png");
    public  static  Image Boss1BulletImg= Toolkit.getDefaultToolkit().getImage("imgs\\Boss子弹\\1.png");
    public  static  Image Boss2BulletImg= Toolkit.getDefaultToolkit().getImage("imgs\\Boss子弹\\2.png");
    public  static  Image Boss3BulletImg= Toolkit.getDefaultToolkit().getImage("imgs\\Boss子弹\\3.png");
    //我方子弹集合
    public static List<ShellObj> shellObjList=new ArrayList<>();
    //敌方子弹集合
    public static List<Enemy2Bulletobj> enemy2BulletobjList=new ArrayList<>();
    public static List<BigbossBulletobj> bigbossBulletobjList=new ArrayList<>();
    public static List<Boss1Bulletobj> boss1BulletobjList=new ArrayList<>();
    public static List<Boss2Bulletobj> boss2BulletobjList=new ArrayList<>();
    public static List<Boss3Bulletobj> boss3BulletobjList=new ArrayList<>();
    //敌方飞机集合
    public static List<Enemy1Obj> enemy1ObjList=new ArrayList<>();
    public static List<Enemy2Obj> enemy2ObjList=new ArrayList<>();
    //所有元素集合
    public static List<GameObj> gameObjList=new ArrayList<>();
    //移除游戏元素集合
    public static List<GameObj> removeList=new ArrayList<>();
    //爆炸集合
    public static List<ExplodeObj> explodeObjList=new ArrayList<>();

}
