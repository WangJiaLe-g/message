package com.jc.message.server.service;

import java.util.List;
import com.jc.message.server.entity.DO.MessageDO;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @Description: MessageDOService
 * @Author: wangjiale
 * @Date: 2023-03-01 
 * @Version 1.0
 */
public interface MessageService extends IService<MessageDO>{


    int updateBatch(List<MessageDO> list);

    int batchInsert(List<MessageDO> list);

    int insertOrUpdate(MessageDO record);

    int insertOrUpdateSelective(MessageDO record);

}
