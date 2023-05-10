package com.jc.message.server.handler;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author Administrator
 */

@Component
public class WebSocketInterceptor implements HandshakeInterceptor {
    private static final Logger log= LogManager.getLogger(WebSocketInterceptor.class);

    /**
     * 握手前
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // 获得请求参数
        String uid = request.getURI().getPath().split("/")[request.getURI().getPath().split("/").length - 1];
        if (StrUtil.isNotBlank(uid)) {
            // 放入属性域
            attributes.put("uid", uid);
//            log.warn("用户 uid " + uid + " 握手成功！");
            return true;
        }
        System.out.println("用户登录已失效");
        return false;
    }

    /**
     * 握手后
     *
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
//        System.out.println("握手完成");
    }



    /**
     * 方法 1：使用 FileWriter 写文件
     * @param filepath 文件目录
     * @param content  待写入内容
     * @throws IOException
     */
    public static void fileWriterMethod(String filepath, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.append(content);
        }
    }

    }
