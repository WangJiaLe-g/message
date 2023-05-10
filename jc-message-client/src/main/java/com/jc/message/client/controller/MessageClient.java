package com.jc.message.client.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.jc.message.client.config.MessageServerConfig;
import com.jc.message.client.utils.OkHttpUtil;
import com.jc.message.client.vo.SendMessageVo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Description: MessageClient
 * @Author: wangjiale
 * @Date: 2023-02-22
 * @Version 1.0
 */
public class MessageClient implements Serializable {


    /**
     * 推送消息
     *
     */
     public static  void  sendMessage(MessageServerConfig messageServerConfig, SendMessageVo sendMessageVo){
         String urlPrefix = buildUrl(messageServerConfig);
         urlPrefix = urlPrefix+"/message/sendMessage";
         //todo 后续做权限验证
         //设置请求入参
         String s = OkHttpUtil.postJsonParams(urlPrefix, JSON.toJSONString(sendMessageVo));
         System.out.println(s);
     }

    /**
     * 封装消息服务前缀的url
     *
     */
    public static String buildUrl(MessageServerConfig messageServerConfig){
        return "http://" +messageServerConfig.getHost()+":"+messageServerConfig.getPort();
    }

    @Test
    public void doGetTestOne() {
        MessageServerConfig config = new MessageServerConfig();
        config.setHost("192.168.1.26");
        config.setPort("8092");
        SendMessageVo sendMessageVo = new SendMessageVo();
        sendMessageVo.setMessageDetail("你好消息");
        ArrayList<String> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        sendMessageVo.setUserIds(objects);
        sendMessageVo.setMessageExpirationTime(new Date());
        MessageClient.sendMessage(config,sendMessageVo);
    }

}
