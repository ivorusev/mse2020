package com.se.wcp.forum.mappers;

import com.se.wcp.forum.dtos.ReplyDto;
import com.se.wcp.forum.dtos.TopicDto;
import com.se.wcp.forum.persistence.entities.ReplyEntity;
import com.se.wcp.forum.persistence.entities.TopicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ReplyMapper {

    ReplyDto replyEntityToDto(ReplyEntity topic);

    ReplyEntity replyDtoToEntity(ReplyDto topic);
}
