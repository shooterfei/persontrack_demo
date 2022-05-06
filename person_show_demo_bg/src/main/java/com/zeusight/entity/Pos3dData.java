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



