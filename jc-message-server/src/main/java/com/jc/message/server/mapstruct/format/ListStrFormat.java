package com.jc.message.server.mapstruct.format;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: ListStrFormat
 * @Author: wangjiale
 * @Date: 2023-03-02
 * @Version 1.0
 */
@Component
public class ListStrFormat {

    public String toStr(List<String> userIds) {
        if (CollectionUtil.isEmpty(userIds)) {
            return "";
        } else {
            return String.join(",", userIds);
        }
    }
    public List<String> toBoolean(String str) {
        if (StrUtil.isEmpty(str)) {
            return new ArrayList<>();
        } else {
            return Arrays.stream(str.split(",")).collect(Collectors.toList());
        }
    }

}
