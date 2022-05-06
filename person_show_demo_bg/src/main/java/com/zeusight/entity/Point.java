package com.zeusight.entity;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/6 10:32
 */
public class Point {

    private long x;
    private long y;

    public Point() {
    }

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
}
