package com.zeusight.entity;

import java.util.List;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/6 14:03
 */
public class Pos3D {

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
