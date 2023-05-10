package com.jc.message.server.handler;


import cn.hutool.core.collection.CollectionUtil;
import com.jc.message.server.entity.VO.MessageVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description: WebSocketHandler
 * @Author: wangjiale
 * @Date: 2023-02-21
 * @Version 1.0
 */
@Component
public class WebSocketHandler extends TextWebSocketHandler  {

    private static final Logger log= LogManager.getLogger(WebSocketInterceptor.class);
    /**
     * socket 建立成功事件
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Object uid = session.getAttributes().get("uid");
        log.warn("连接成功"+uid);
        if (uid != null) {
            // 用户连接成功，放入在线用户缓存
            WsSessionManager.add(uid.toString(), session);

        } else {
            throw new RuntimeException("用户登录已经失效!");
        }
    }
    /**
     * 接收消息事件
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 获得客户端传来的消息
        String payload = message.getPayload();
        Object uid = session.getAttributes().get("uid");
//        System.out.println("server 接收到 " + uid + " 发送的 " + payload);
        session.sendMessage(new TextMessage("server 发送给 " + uid + " 消息 " + payload + " " + LocalDateTime.now().toString()));
    }

    /**
     * socket 断开连接时
     *
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Object token = session.getAttributes().get("uid");
        if (token != null) {
            // 用户退出，移除缓存
            WsSessionManager.remove(token.toString());
            log.warn("连接断开"+token);
        }
    }

    /**
     * 广播信息
     * @param mes
     */
    public void sendMessageToAll(MessageVo mes) {
        WsSessionManager.get().forEach((k,v) ->{
            try {
                handleTextMessage(v,new TextMessage(mes.getMessageDetail().getBytes()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * 发送信息给指定用户
     * @param userIds
     * @param message
     * @return
     */
    public boolean sendToUser(MessageVo message, List<String> userIds) {
        if (CollectionUtil.isEmpty(userIds)){
            return false;
        }
        try {
            for(String userId: userIds){
                if (Objects.nonNull(WsSessionManager.get(userId))) {
                    handleTextMessage(WsSessionManager.get(userId),new TextMessage(message.getMessageDetail().getBytes()));
                }else {
                    //如果用户不在线，消息保存在数据库
                    
                }
            }
        }catch (IOException e){
            //e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }



}
