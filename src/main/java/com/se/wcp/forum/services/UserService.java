package com.se.wcp.forum.services;

import com.se.wcp.forum.dtos.UserDto;
import com.se.wcp.forum.mappers.UserMapper;
import com.se.wcp.forum.persistence.entities.Role;
import com.se.wcp.forum.persistence.entities.UserEntity;
import com.se.wcp.forum.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    private UserMapper mapper;

    public UserService(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public Long save(UserDto user) {
        UserEntity userEntity = mapper.userDtoToUserEntity(user);
        userRepository.save(userEntity);
        return userEntity.getId();
    }

    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(mapper::userEntityToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        if (!byId.isPresent()) {
            throw new IllegalArgumentException("No such user");
        }
        return mapper.userEntityToUserDto(byId.get());
    }
}
