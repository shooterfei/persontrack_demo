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


    /**
     * 发送消息到指定topic 中
     *
     * @param topic topic 名称
     * @param message 要发送的消息
     */
    public void send2Topic(String topic, String message) {
        coll.values().stream().filter(s -> String.valueOf(topic).equals(s.getUriVariables().asMap().get("topic"))).forEach(s -> s.sendSync(message));
    }

    /**
     * 发送消息到指定topic 和 user 中
     *
     * @param topic topic 名称
     * @param username 用户名
     * @param message 要发送的消息
     */
    public void send2TopicAndUser(String topic, String username, String message) {
        coll.values().stream()
                .filter(s -> String.valueOf(topic).equals(s.getUriVariables().asMap().get("topic")) &&
                        String.valueOf(username).equals(s.getUriVariables().asMap().get("username")))
                .forEach(s -> s.sendSync(message));
    }

    /**
     * 发送消息给所有已连接的用户
     * @param message 要发送的消息
     */
    public void sendAll(String message) {
        coll.values().forEach(s -> s.sendSync(message));
    }

    @Override
    public String toString() {
        return "WSManager{" + "coll=" + coll + '}';
    }
}
