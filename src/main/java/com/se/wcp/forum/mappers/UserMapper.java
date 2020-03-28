package com.se.wcp.forum.mappers;

import com.se.wcp.forum.dtos.UserDto;
import com.se.wcp.forum.persistence.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    UserDto userEntityToUserDto(UserEntity user);

    UserEntity userDtoToUserEntity(UserDto user);
}
