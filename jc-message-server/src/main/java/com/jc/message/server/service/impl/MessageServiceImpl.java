package com.jc.message.server.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jc.message.server.mapper.MessageMapper;
import com.jc.message.server.entity.DO.MessageDO;
import com.jc.message.server.service.MessageService;
/**
 * @Description: MessageDOServiceImpl
 * @Author: wangjiale
 * @Date: 2023-03-01 
 * @Version 1.0
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, MessageDO> implements MessageService {

    @Override
    public int updateBatch(List<MessageDO> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<MessageDO> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(MessageDO record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(MessageDO record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
