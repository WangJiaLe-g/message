package com.jc.message.server.entity.VO;

import java.util.Date;
import java.util.List;

import com.jc.message.server.constant.TerminalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统全局-系统消息表
 * </p>
 *
 * @author wangjiale
 * @since 2020-09-29
 */
public class  MessageVo{

    private static final long serialVersionUID = 1L;
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
}
