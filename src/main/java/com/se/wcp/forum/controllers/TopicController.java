package com.se.wcp.forum.controllers;

import com.se.wcp.forum.dtos.TopicDto;
import com.se.wcp.forum.services.TopicService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/topics")
@RolesAllowed(value = {"MODERATOR", "ADMIN", "USER"})
public class TopicController {

    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public Long createTopic(@RequestBody TopicDto topic) {
        return topicService.createTopic(topic);
    }

    @GetMapping("/{id}/")
    public TopicDto getTopic(@PathVariable("id") Long id) {
        return topicService.getTopic(id);
    }

    @GetMapping
    public List<TopicDto> getAllTopics() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getDetails();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        return topicService.getAllTopics();
    }

    @PutMapping(path = "/{id}/")
    public void updateTopic(@PathVariable Long id, @RequestBody TopicDto topic) {
        topicService.updateTopic(id, topic);
    }
}
