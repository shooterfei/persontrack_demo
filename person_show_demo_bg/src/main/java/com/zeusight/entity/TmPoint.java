package com.zeusight.entity;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/6 14:45
 */
public class TmPoint extends Point {
    public TmPoint() {
    }

    public TmPoint(long x, long y) {
        super(x, y);
    }

    public TmPoint(long x, long y, long tm) {
        super(x, y);
        this.tm = tm;
    }

    private long tm;

    @Override
    public String toString() {
        return "TmPoint{" + "tm=" + tm + "} " + super.toString();
    }

    public long getTm() {
        return tm;
    }

    public void setTm(long tm) {
        this.tm = tm;
    }
}
