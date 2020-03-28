package com.se.wcp.forum.persistence.repository;

import com.se.wcp.forum.persistence.entities.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
}
