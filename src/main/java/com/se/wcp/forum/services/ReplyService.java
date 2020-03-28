package com.se.wcp.forum.services;

import com.se.wcp.forum.dtos.ReplyDto;
import com.se.wcp.forum.mappers.ReplyMapper;
import com.se.wcp.forum.persistence.entities.ReplyEntity;
import com.se.wcp.forum.persistence.repository.ReplyRepository;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    private ReplyRepository repository;
    private ReplyMapper replyMapper;

    public ReplyService(ReplyRepository repository) {
        this.repository = repository;
    }

    public Long createReply(ReplyDto reply) {
        ReplyEntity replyEntity = replyMapper.replyDtoToEntity(reply);
        repository.save(replyEntity);
        return replyEntity.getId();
    }
}
