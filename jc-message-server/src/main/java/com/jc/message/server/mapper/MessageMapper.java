package com.jc.message.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.message.server.entity.DO.MessageDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: MessageDOMapper
 * @Author: wangjiale
 * @Date: 2023-03-01 
 * @Version 1.0
 */
@Mapper
public interface MessageMapper extends BaseMapper<MessageDO> {
    int updateBatch(List<MessageDO> list);

    int batchInsert(@Param("list") List<MessageDO> list);

    int insertOrUpdate(MessageDO record);

    int insertOrUpdateSelective(MessageDO record);
}