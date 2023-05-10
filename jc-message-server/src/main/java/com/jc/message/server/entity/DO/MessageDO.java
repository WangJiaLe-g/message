package com.jc.message.server.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description: MessageDO
 * @Author: wangjiale
 * @Date: 2023-03-01 
 * @Version 1.0
 */
@TableName(value = "jc_message.message")
public class MessageDO implements Serializable {
    /**
     * 消息id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 推送消息类型 1消息提醒 2 代办事项
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 消息主体
     */
    @TableField(value = "detail")
    private String detail;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 终端类型 
     */
    @TableField(value = "terminal_type")
    private String terminalType;

    /**
     * 已读类型  1已读或未读 2代办或已办
     */
    @TableField(value = "read_type")
    private Integer readType;

    /**
     * 消息过期时间
     */
    @TableField(value = "expiration_time")
    private Date expirationTime;

    /**
     * 0 未读/代办 1已读/已办
     */
    @TableField(value = "is_read")
    private Integer isRead;

    /**
     * 模板id 
     */
    @TableField(value = "template_id")
    private Integer templateId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取消息id
     *
     * @return id - 消息id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置消息id
     *
     * @param id 消息id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取推送消息类型 1消息提醒 2 代办事项
     *
     * @return type - 推送消息类型 1消息提醒 2 代办事项
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置推送消息类型 1消息提醒 2 代办事项
     *
     * @param type 推送消息类型 1消息提醒 2 代办事项
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取消息主体
     *
     * @return detail - 消息主体
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置消息主体
     *
     * @param detail 消息主体
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * 获取用户ids 
     *
     * @return user_ids - 用户id
     */
    public String getUserIds() {
        return userId;
    }

    /**
     * 设置用户ids 
     *
     * @param userId 用户id
     */
    public void setUserIds(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取终端类型 
     *
     * @return terminal_type - 终端类型 
     */
    public String getTerminalType() {
        return terminalType;
    }

    /**
     * 设置终端类型 
     *
     * @param terminalType 终端类型 
     */
    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType == null ? null : terminalType.trim();
    }

    /**
     * 获取已读类型  1已读或未读 2代办或已办
     *
     * @return read_type - 已读类型  1已读或未读 2代办或已办
     */
    public Integer getReadType() {
        return readType;
    }

    /**
     * 设置已读类型  1已读或未读 2代办或已办
     *
     * @param readType 已读类型  1已读或未读 2代办或已办
     */
    public void setReadType(Integer readType) {
        this.readType = readType;
    }

    /**
     * 获取消息过期时间 单位毫秒
     *
     * @return expiration_time - 消息过期时间 单位毫秒
     */
    public Date getExpirationTime() {
        return expirationTime;
    }

    /**
     * 设置消息过期时间 单位毫秒
     *
     * @param expirationTime 消息过期时间 单位毫秒
     */
    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    /**
     * 获取0 未读/代办 1已读/已办
     *
     * @return is_read - 0 未读/代办 1已读/已办
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * 设置0 未读/代办 1已读/已办
     *
     * @param isRead 0 未读/代办 1已读/已办
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * 获取模板id 
     *
     * @return template_id - 模板id 
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * 设置模板id 
     *
     * @param templateId 模板id 
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
}