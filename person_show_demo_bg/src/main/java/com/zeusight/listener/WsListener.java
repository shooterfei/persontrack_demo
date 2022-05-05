package com.zeusight.listener;

import org.testcontainers.shaded.okhttp3.Response;
import org.testcontainers.shaded.okhttp3.WebSocket;
import org.testcontainers.shaded.okhttp3.WebSocketListener;
import org.testcontainers.shaded.okio.ByteString;

/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/5 17:20
 */
public class WsListener extends WebSocketListener {
    public WsListener() {
        super();
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        super.onMessage(webSocket, text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        super.onMessage(webSocket, bytes);
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        super.onClosing(webSocket, code, reason);
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        super.onClosed(webSocket, code, reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        super.onFailure(webSocket, t, response);
    }
}
