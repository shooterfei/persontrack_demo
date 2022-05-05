package com.zeusight.server;

import com.zeusight.config.WSManager;
import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import jakarta.inject.Inject;

import java.util.function.Predicate;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/5 15:12
 */
@ServerWebSocket("/chat/{topic}/{username}")
public class MyWebSocketServer {

    @Inject
    WSManager wsManager;

    private final WebSocketBroadcaster broadcaster;
    public MyWebSocketServer(WebSocketBroadcaster broadcaster){
        this.broadcaster = broadcaster;
    }

    @OnOpen
    public void onOpen(String topic, String username, WebSocketSession session) {
        String msg = "[" + username + "]";
        broadcaster.broadcastSync(msg, isValid(topic, session));
        if(wsManager.getColl().get(topic + "/" + username) != null){
            wsManager.getColl().put(topic + "/" + username, session);
        }
    }

    @OnMessage
    public void onMessage(String topic, String username, String message, WebSocketSession session) {
        String msg = "[" + username + "]" + message;System.out.println(msg);
        broadcaster.broadcastSync(msg, isValid(topic, session));

    }

    @OnClose
    public void onClose(String topic, String username, WebSocketSession session) {
        String msg = "[" + username + "] Disconnect!";
        broadcaster.broadcastSync(msg, isValid(topic, session));
        wsManager.getColl().remove(topic + "/" + username);
    }
    private Predicate<WebSocketSession> isValid(String topic, WebSocketSession session) {
        return s -> s != session &&
                topic.equalsIgnoreCase(s.getUriVariables().get("topic", String.class, null));
    }

}
