package com.jc.message.client.config;


import java.io.Serializable;
import java.util.Objects;

/**
 * @Description: MessageServerConfig
 * @Author: wangjiale
 * @Date: 2023-02-22
 * @Version 1.0
 */
public class MessageServerConfig implements Serializable {


    /**
     * 消息服务端主机地址/ip地址
     */
    private String host;

    /**
     * 消息服务端端口号
     */
    private String port;

    /**
     * 消息服务认证标识 -用户名
     */
    private String  username;

    /**
     * 消息服务认证标识 -密码
     */
    private String  password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageServerConfig)) return false;
        MessageServerConfig that = (MessageServerConfig) o;
        return Objects.equals(getHost(), that.getHost()) && Objects.equals(getPort(), that.getPort()) && Objects.equals(getUsername(), that.getUsername()) && Objects.equals(getPassword(), that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHost(), getPort(), getUsername(), getPassword());
    }

    @Override
    public String toString() {
        return "MessageServerConfig{" +
                "host=" + host +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
