package com.zeusight.server;

import com.github.dockerjava.transport.DockerHttpClient;
import com.zeusight.listener.WsListener;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.websocket.WebSocketClient;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.okhttp3.OkHttpClient;
import org.testcontainers.shaded.okhttp3.Request;
import org.testcontainers.shaded.okhttp3.WebSocket;

import java.util.concurrent.TimeUnit;


/**
 * @author shooterfei
 * @email shooterfei@163.com
 * @date 2022/5/5 15:41
 */
@MicronautTest
class MyWebSocketClientTest {

//    @Inject
//    @Client("http://localhost:8280")
//    WebSocketClient webSocketClient;

    @Test
    void testWebsocket() {
//        Publisher<MyWebSocketClient> connect = webSocketClient.connect(MyWebSocketClient.class, "/chat/test/test");

        String websocketUrl = "ws://localhost:8280/chat/test/test1";
        OkHttpClient myclient = new OkHttpClient.Builder()
                .pingInterval(10, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(websocketUrl)
                .build();
        WebSocket webSocket = myclient.newWebSocket(request, new WsListener());
        webSocket.send("hello 123");

    }
}