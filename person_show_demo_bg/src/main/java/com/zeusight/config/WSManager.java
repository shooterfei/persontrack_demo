package com.zeusight.config;

import io.micronaut.websocket.WebSocketSession;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/5 17:47
 * 管理已连接的websocket 连接
 */
@Singleton
public class WSManager {
    private Map<String, WebSocketSession> coll = new HashMap<>();

    public Map<String, WebSocketSession> getColl() {
        return coll;
    }

    public void setColl(Map<String, WebSocketSession> coll) {
        this.coll = coll;
    }

    @Override
    public String toString() {
        return "WSManager{" +
                "coll=" + coll +
                '}';
    }
}
