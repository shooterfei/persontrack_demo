package com.zeusight.entity;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/6 10:38
 */
public class ConvertInformation {

    private Point initialPoint;
    private Point endPoint;
    private long width;
    private long height;

    public ConvertInformation() {
    }

    public ConvertInformation(Point initialPoint, Point endPoint, long width, long height) {
        this.initialPoint = initialPoint;
        this.endPoint = endPoint;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "ConvertInformation{" +
                "initialPoint=" + initialPoint +
                ", endPoint=" + endPoint +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public Point getInitialPoint() {
        return initialPoint;
    }

    public void setInitialPoint(Point initialPoint) {
        this.initialPoint = initialPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }
}
