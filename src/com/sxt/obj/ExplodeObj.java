package com.sxt.obj;

import com.sxt.utils.GameUtils;

import java.awt.*;

public class ExplodeObj extends GameObj{
    //爆炸图片集合
    static Image[] explodePic=new Image[16];
    int explodeCount=0;
    //静态代码块将爆炸图片放到数组中
    static {
        for (int i = 0; i <explodePic.length ; i++) {
            explodePic[i]=Toolkit.getDefaultToolkit().getImage("imgs\\explode\\e"+(i+1)+".gif");
        }
    }
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if(explodeCount<16){
            super .img=explodePic[explodeCount];
            explodeCount++;
        }else {
            GameUtils.explodeObjList.remove(this); // 从爆炸效果列表中移除当前爆炸对象
        }


        //System.out.println(explodeCount);
    }
    public ExplodeObj(int x,int y){
        super(x,y);
    }
}
