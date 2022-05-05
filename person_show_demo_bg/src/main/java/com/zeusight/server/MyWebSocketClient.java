package com.zeusight.server;

import io.micronaut.http.HttpRequest;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.ClientWebSocket;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/5 15:25
 */
@ClientWebSocket("/chat/{topic}/{username}")
public abstract class MyWebSocketClient implements AutoCloseable {
    private WebSocketSession session;
    private HttpRequest request;
    private String topic;
    private String username;
    private Collection<String> replies = new ConcurrentLinkedQueue<>();

    @OnOpen
    public void onOpen(String topic, String username, WebSocketSession session, HttpRequest request) {
        this.topic = topic;
        this.username = username;
        this.session = session;
        this.request = request;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public String getTopic() {
        return topic;
    }

    public String getUsername() {
        return username;
    }

    public Collection<String> getReplies() {
        return replies;
    }

    public abstract java.util.concurrent.Future<String> sendAsync(String message);

    @OnMessage
    public void onMessage(String message) {
        replies.add(message);
    }

}
