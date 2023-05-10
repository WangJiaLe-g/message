package com.jc.message.client.vo;

import com.jc.message.client.constant.TerminalType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Description: SendMessageVo
 * @Author: wangjiale
 * @Date: 2023-02-23
 * @Version 1.0
 */
public class SendMessageVo implements Serializable {

    /**
     * 推送目标-用户id
     */
    private List<String> userIds;


    /**
     * 推送终端
     * 默认 所有端推送
     */
    private String terminalType = TerminalType.ALL;


    /**
     * 推送主体
     */
    private String messageDetail ;


    /**
     * 推送消息类型
     *
     */
    private String messageType;

    /**
     * 消息过期时间
     *
     */
    private Date messageExpirationTime;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Date getMessageExpirationTime() {
        return messageExpirationTime;
    }

    public void setMessageExpirationTime(Date messageExpirationTime) {
        this.messageExpirationTime = messageExpirationTime;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SendMessageVo)) return false;
        SendMessageVo that = (SendMessageVo) o;
        return Objects.equals(getUserIds(), that.getUserIds()) && Objects.equals(getTerminalType(), that.getTerminalType()) && Objects.equals(getMessageDetail(), that.getMessageDetail()) && Objects.equals(getMessageType(), that.getMessageType()) && Objects.equals(getMessageExpirationTime(), that.getMessageExpirationTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserIds(), getTerminalType(), getMessageDetail(), getMessageType(), getMessageExpirationTime());
    }

    @Override
    public String toString() {
        return "SendMessageVo{" +
                "userIds=" + userIds +
                ", terminalType='" + terminalType + '\'' +
                ", messageDetail='" + messageDetail + '\'' +
                ", messageType='" + messageType + '\'' +
                ", messageExpirationTime='" + messageExpirationTime + '\'' +
                '}';
    }
}
