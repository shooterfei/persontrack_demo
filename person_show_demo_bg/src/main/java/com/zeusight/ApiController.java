package com.zeusight;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.RequestBean;
import io.micronaut.json.tree.JsonObject;

import java.util.Iterator;
import java.util.Map;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/4/11 11:41
 */

@Controller("/api")
public class ApiController {

    @Post(value = "/personTrack", processes = MediaType.APPLICATION_FORM_URLENCODED)
    public String personTrackCollect(@Body Map<String, Object> request) {
        System.out.println("id: " + request.get("id").toString());
        System.out.println("keyId: " + request.get("keyId").toString());
        System.out.println("eventType: " + request.get("eventType").toString());
        System.out.println("videoCalculId: " + request.get("videoCalculId").toString());
        System.out.println("taskDefKey: " + request.get("taskDefKey").toString());
        System.out.println("analyseDate: " + request.get("analyseDate").toString());
        System.out.println("calculResult: " + request.get("calculResult").toString());
        System.out.println("data: " + request.get("data").toString());
        return "success:\n" + request;
    }
}
