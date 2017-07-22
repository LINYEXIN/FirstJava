package com.company;
import java.awt.image.BufferedImage;


/**
 * Created by qq1127996233 on 2017/7/21.
 */
public abstract class FlyingObject {
    /**飞行物：子弹，英雄机，敌飞机
    */
    protected int x;//x坐标
    protected int y;//y坐标
    protected int width;    //宽
    protected int height;   //高
    protected BufferedImage image;   //图片

    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x=x;
    }
    public int getY(){
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setY(int y) {
        this.y = y;
    }
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**检查出界
     * @return true 出界与否
     */

    public abstract boolean outOfBounds();

    /**移动一步
     */
    public abstract void step();

    /**
     * 检查当前飞行物体是否被子弹(x,y)击(shoot)中

     * @return true表示被击中了
     */

    public boolean shootBy(Bullet bullet){
        int x=bullet.x;
        int y =bullet.y;
        return this.x<x && x<this.x+width && this.y<y && y<this.y+height;
    }


}
