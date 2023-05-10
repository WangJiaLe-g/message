//package com.jc.message.server.mapstruct.mapper;
//
//import com.jc.message.server.entity.DO.MessageDO;
//import com.jc.message.server.entity.VO.MessageVo;
//import com.jc.message.server.mapstruct.format.ListStrFormat;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//import org.mapstruct.ReportingPolicy;
//
///**
// * @Description: MessageMapper
// * @Author: wangjiale
// * @Date: 2023-03-02
// * @Version 1.0
// */
//@Mapper(
//        componentModel = "spring",
//        unmappedTargetPolicy = ReportingPolicy.IGNORE
//        )
//public interface MessageMapstruct {
//    @Mappings({
//            @Mapping(source = "detail",target = "messageDetail"),
//            @Mapping(source = "type",target = "messageType"),
//            @Mapping(source = "expirationTime",target = "messageExpirationTime")
//    })
//    MessageVo toMessageVo(MessageDO message);
//
//    @Mappings({
//            @Mapping(source = "messageDetail",target = "detail"),
//            @Mapping(source = "messageType",target = "type"),
//            @Mapping(source = "messageExpirationTime",target = "expirationTime")
//    })
//    MessageDO toMessageDO(MessageVo dto);
//}
