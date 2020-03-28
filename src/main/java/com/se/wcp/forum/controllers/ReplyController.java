package com.se.wcp.forum.controllers;

import com.se.wcp.forum.dtos.ReplyDto;
import com.se.wcp.forum.dtos.TopicDto;
import com.se.wcp.forum.services.ReplyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/replies")
public class ReplyController {

    private ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @PostMapping
    public Long createReply(@RequestBody ReplyDto reply) {
        return replyService.createReply(reply);
    }

    @GetMapping("/{id}/")
    public ReplyDto getReply(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping
    public List<ReplyDto> getAllRepliesByTopic() {
        return null;
    }

    @PutMapping(path = "/{id}/")
    public void updateReply(@PathVariable Long id, @RequestBody TopicDto topic) {

    }
}
