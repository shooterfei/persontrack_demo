package com.zeusight.controller;

import com.google.gson.Gson;
import com.zeusight.entity.Pos3dData;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import java.util.Map;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/4/11 11:41
 */

@Controller("/api")
public class ApiController {

    private final Gson gson = new Gson();
    @Post(value = "/personTrack", processes = MediaType.APPLICATION_FORM_URLENCODED)
    public String personTrackCollect(@Body Map<String, Object> request) {
        String eventType = request.get("eventType").toString();
        if (!"pos3dUp".equals(request.get("eventType"))) {
            request.forEach((key, value) -> {
                System.out.printf("key: %s\n", key);
            });
        } else {
//            System.out.println("id: " + request.get("id").toString());
//            System.out.println("keyId: " + request.get("keyId").toString());
//            System.out.println("eventType: " + request.get("eventType").toString());
//            System.out.println("videoCalculId: " + request.get("videoCalculId").toString());
//            System.out.println("taskDefKey: " + request.get("taskDefKey").toString());
//            System.out.println("analyseDate: " + request.get("analyseDate").toString());
//            System.out.println("calculResult: " + request.get("calculResult").toString());
//            System.out.println("data: " + request.get("data").toString());

//            Pos3dData data = gson.fromJson(request.get("data").toString(), Pos3dData.class);
//            System.out.println(request.get("data").toString());
//            System.out.println(data.toString());
        }
        return "success:\n" + request;
    }
}
