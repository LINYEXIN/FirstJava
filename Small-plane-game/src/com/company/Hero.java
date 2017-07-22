package com.company;

import java.awt.image.BufferedImage;

/**
 * Created by qq1127996233 on 2017/7/21.
 */
public class Hero extends FlyingObject{

    private BufferedImage[] images ={};//英雄机的图片
    private int index =0;
    private int doubleFire;   //双倍火力
    private int life;//命

    /**初始化数据
     *
     */
    public Hero(){
        life=3;
        doubleFire=0;
        images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1}; //英雄机图片数组
        image = ShootGame.hero0;   //初始为hero0图片
        width=image.getWidth();
        height=image.getHeight();
        x=150;
        y=400;
    }

    /**生命增加或减少
     *
     */
    public void addLife(){
        life++;
    }
    public void subtractLife(){
        life--;
    }
    public int getLife(){
        return life;
    }
    /** 当前物体移动了一下，相对距离，x,y鼠标位置  */
    public void moveTo(int x,int y){
        this.x = x - width/2;
        this.y = y - height/2;
    }


    /**
     * 越界出路
     */
    public boolean outOfBounds(){
        return false;
    }

    /**
     * 碰撞算法
     */
    public boolean hit(FlyingObject other){
        int x1=other.x-this.width/2;
        int x2=other.x + this.width/2 + other.width;
        int y1=other.y-this.height/2;
        int y2=other.y+this.height/2+other.height;

        int herox= this.x+this.width/2;
        int heroy=this.y+this.height/2;

        return herox>x1 &&herox<x2&&heroy>y1 && heroy<y2;

    }
    /** 获取双倍火力 */
    public int isDoubleFire() {
        return doubleFire;
    }

    /** 设置双倍火力 */
    public void setDoubleFire(int doubleFire) {
        this.doubleFire = doubleFire;
    }

    /** 增加火力 */
    public void addDoubleFire(){
        doubleFire = 40;
    }


    /**移动
     *
     */
    public void step(){
        if (images.length > 0) {
            image = images[index++ / 10 % images.length];
        }
    }

    /**发射子弹
     */
    public Bullet[] shoot(){
        int xStep = width/4;
        int yStep=20;
        if (doubleFire>0){
            Bullet[] bullets=new Bullet[2];
            bullets[0]=new Bullet(x+xStep,y=yStep);
            bullets[1]=new Bullet(x+3*xStep,y-yStep);
            return bullets;
        }else{
            Bullet[] bullets=new Bullet[1];
            bullets[0]=new Bullet(x+2*xStep,y-yStep);
            return bullets;

        }
    }

}
