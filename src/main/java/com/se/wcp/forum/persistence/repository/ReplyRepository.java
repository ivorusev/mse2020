package com.se.wcp.forum.persistence.repository;

import com.se.wcp.forum.persistence.entities.ReplyEntity;
import com.se.wcp.forum.persistence.entities.TopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
}
