package com.se.wcp.forum.services;

import com.se.wcp.forum.dtos.TopicDto;
import com.se.wcp.forum.mappers.TopicMapper;
import com.se.wcp.forum.persistence.entities.TopicEntity;
import com.se.wcp.forum.persistence.entities.UserEntity;
import com.se.wcp.forum.persistence.repository.TopicRepository;
import com.se.wcp.forum.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    private TopicRepository topicRepository;
    private UserRepository userRepository;
    private TopicMapper topicMapper;

    public TopicService(TopicRepository topicRepository, UserRepository userRepository, TopicMapper topicMapper) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.topicMapper = topicMapper;
    }

    public Long createTopic(TopicDto topic) {
        Optional<UserEntity> user = userRepository.findById(topic.getUserId());
        if (!user.isPresent()) {
            throw new IllegalArgumentException("User with following id not found: " + topic.getUserId());
        }

        TopicEntity topicEntity = topicMapper.topicDtoToEntity(topic);
        topicEntity.setUser(user.get());

        TopicEntity savedEntity = topicRepository.save(topicEntity);

        return savedEntity.getId();
    }

    public TopicDto getTopic(Long id) {
        Optional<TopicEntity> topic = topicRepository.findById(id);
        if (!topic.isPresent()) {
            throw new IllegalArgumentException("There is no topic with id" + id);
        }
        return topicMapper.topicEntityToDto(topic.get());
    }

    public List<TopicDto> getAllTopics() {
        return topicRepository
                .findAll()
                .stream()
                .map(topicMapper::topicEntityToDto)
                .collect(Collectors.toList());
    }

    public void updateTopic(Long id, TopicDto topic) {
        Optional<TopicEntity> existingTopic = topicRepository.findById(id);
        if (!existingTopic.isPresent()) {
            throw new IllegalArgumentException("Topic with id: " + id);
        }
        TopicEntity topicEntity = existingTopic.get();
        topicEntity.setTitle(topic.getTitle());
        topicRepository.save(topicEntity);
    }
}
