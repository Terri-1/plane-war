package com.sxt.obj;

import com.sxt.Game1;

import java.awt.*;

public class GameObj {
    //元素图片
    Image img;
    int width;
    int height;
   public int x;
   public int y;
    double speed;
    int HP;
Game1 frame;

    public GameObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GameObj(Image img, int x, int y, double speed) {
        this.img=img;
        this.x=x;
        this.y=y;
        this.speed=speed;
    }

    public GameObj(Image img, int width, int height, int x, int y, double speed, int HP, Game1 frame) {
        this.img = img;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.HP = HP;
        this.frame = frame;
    }

    //绘制元素
    public  void paintSelf(Graphics g){
        g.drawImage(img,x,y,null);
    }

public Rectangle getRec(){
        return  new Rectangle(x,y,width,height);

}
    public GameObj() {
    }

    public GameObj(Image img, int width, int height, int x, int y, double speed, Game1 frame) {
        this.img = img;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.frame = frame;
    }

    /**
     * 获取
     * @return img
     */
    public Image getImg() {
        return img;
    }

    /**
     * 设置
     * @param img
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     * 获取
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * 设置
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 获取
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * 设置
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获取
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * 设置
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 获取
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * 设置
     * @param speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * 获取
     * @return frame
     */
    public Game1 getFrame() {
        return frame;
    }

    /**
     * 设置
     * @param frame
     */
    public void setFrame(Game1 frame) {
        this.frame = frame;
    }


    /**
     * 获取
     * @return HP
     */
    public int getHP() {
        return HP;
    }

    /**
     * 设置
     * @param HP
     */
    public void setHP(int HP) {
        this.HP = HP;
    }


}
