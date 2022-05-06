package com.zeusight.entity;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/6 14:04
 */
public class Poss {
    private long tm;
    private long x;
    private long y;
    private long z;

    public long getTm() {
        return tm;
    }

    public void setTm(long tm) {
        this.tm = tm;
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

    public long getZ() {
        return z;
    }

    public void setZ(long z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Poss{" +
                "tm=" + tm +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
