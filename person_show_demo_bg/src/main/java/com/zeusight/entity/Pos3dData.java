package com.zeusight.entity;


import java.util.List;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/5 13:42
 */
public class Pos3dData {

    private List<String> persons;
    private List<Pos3D> pos3d;

    @Override
    public String toString() {
        return "Pos3dData{" +
                "persons=" + persons +
                ", pos3d=" + pos3d +
                '}';
    }

    public List<String> getPersons() {
        return persons;
    }

    public void setPersons(List<String> persons) {
        this.persons = persons;
    }

    public List<Pos3D> getPos3d() {
        return pos3d;
    }

    public void setPos3d(List<Pos3D> pos3d) {
        this.pos3d = pos3d;
    }
}

class Pos3D {
    private List<Poss> poss;
    private long trkId;


    @Override
    public String toString() {
        return "Pos3D{" +
                "poss=" + poss +
                ", trkId=" + trkId +
                '}';
    }

    public List<Poss> getPoss() {
        return poss;
    }

    public void setPoss(List<Poss> poss) {
        this.poss = poss;
    }

    public long getTrkId() {
        return trkId;
    }

    public void setTrkId(long trkId) {
        this.trkId = trkId;
    }
}

class Poss {
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

