package com.jc.message.server.contoller;

import com.jc.message.server.entity.DO.MessageDO;
import com.jc.message.server.entity.VO.MessageVo;
import com.jc.message.server.handler.WebSocketHandler;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: A
 * @Author: wangjiale
 * @Date: 2023-02-23
 * @Version 1.0
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    public final WebSocketHandler webSocketHandler;

//    public final MessageMapstruct messageMapstruct;

    public MessageController(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;

    }

    @PostMapping("/sendMessage")
    private String getPurchaseMarketTarget(@RequestBody MessageVo mes){
        webSocketHandler.sendMessageToAll(mes);
        return "";
    }
}
