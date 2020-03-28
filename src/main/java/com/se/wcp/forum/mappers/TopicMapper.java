package com.se.wcp.forum.mappers;

import com.se.wcp.forum.dtos.TopicDto;
import com.se.wcp.forum.dtos.UserDto;
import com.se.wcp.forum.persistence.entities.TopicEntity;
import com.se.wcp.forum.persistence.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TopicMapper {

    @Mapping(source = "user.id", target = "userId")
    TopicDto topicEntityToDto(TopicEntity topic);

    @Mapping(source = "userId", target = "user.id")
    TopicEntity topicDtoToEntity(TopicDto topic);
}
