package com.jc.message.server.config.websocket;

import com.jc.message.server.handler.WebSocketHandler;
import com.jc.message.server.handler.WebSocketInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Description: WebSocketConfig
 * @Author: wangjiale
 * @Date: 2023-02-21
 * @Version 1.0
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketHandler myWebSocketHandler;

    private final WebSocketInterceptor myInterceptor;

    public WebSocketConfig(WebSocketHandler myWebSocketHandler, WebSocketInterceptor myInterceptor) {
        this.myWebSocketHandler = myWebSocketHandler;
        this.myInterceptor = myInterceptor;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler, "/websocket/*")
                .addInterceptors(myInterceptor)
                .setAllowedOrigins("*");
    }
}
