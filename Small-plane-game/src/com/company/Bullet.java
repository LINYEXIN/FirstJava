package com.company;

/**
 * Created by qq1127996233 on 2017/7/21.
 */
public class Bullet extends FlyingObject{
    private int speed=3;//移动速度

    /**初始化数据
     *
     */
    public Bullet(int x,int y){
        this.x=x;
        this.y=y;
        this.image=ShootGame.bullet;
    }

    /**移动
     */
    public void step(){
        y-=speed;
    }
    /**越界处理
     *
     */
    public boolean outOfBounds(){
        return y<-height;
    }

}
