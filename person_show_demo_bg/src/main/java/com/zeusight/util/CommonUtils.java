package com.zeusight.util;

import com.google.gson.Gson;
import com.zeusight.entity.ConvertInformation;
import com.zeusight.entity.Point;
import com.zeusight.entity.Pos3dData;
import com.zeusight.entity.TmPoint;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {


    static Gson gson = new Gson();

    /**
     * 坐标转换
     *
     * @param convertInformation 坐标范围信息
     * @param point              要转化的坐标点
     * @return 转化后的坐标点
     */
    public static TmPoint coordinateTransformation(ConvertInformation convertInformation, TmPoint point) {
        if (point.getX() > convertInformation.getWidth() || point.getY() > convertInformation.getHeight()) {
            System.out.println("转化矩阵范围比实际要小");
            return null;
        }
        BigDecimal px = new BigDecimal(point.getX());
        BigDecimal py = new BigDecimal(point.getY());
        BigDecimal width = new BigDecimal(convertInformation.getWidth());
        BigDecimal height = new BigDecimal(convertInformation.getHeight());
        BigDecimal init_x = new BigDecimal(convertInformation.getInitialPoint().getX());
        BigDecimal init_y = new BigDecimal(convertInformation.getInitialPoint().getY());
        BigDecimal end_x = new BigDecimal(convertInformation.getEndPoint().getX());
        BigDecimal end_y = new BigDecimal(convertInformation.getEndPoint().getY());
        long x = (px.divide(width)).multiply(end_x.subtract(init_x)).add(init_x).longValue();
        long y = (px.divide(width)).multiply(end_y.subtract(init_y)).add(init_y).longValue();
        return new TmPoint(x, y, point.getTm());
    }


    /**
     * pos3d 上送数据处理
     *
     * @param pos3dData          上送的数据
     * @param convertInformation 坐标范围信息
     * @return 处理后的数据
     */
    public static String pos3DataProcessing(Pos3dData pos3dData, ConvertInformation convertInformation) {
        List<TmPoint> pList = new ArrayList<>();
        pos3dData.getPos3d().forEach(pos3d -> {
            pos3d.getPoss().forEach(poss -> {
                pList.add(coordinateTransformation(convertInformation, new TmPoint(poss.getX(), poss.getY(), poss.getTm())));
            });
        });
        return gson.toJson(pList);
    }
}
