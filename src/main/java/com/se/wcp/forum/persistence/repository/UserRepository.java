package com.se.wcp.forum.persistence.repository;

import com.se.wcp.forum.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
