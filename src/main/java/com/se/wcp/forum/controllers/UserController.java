package com.se.wcp.forum.controllers;

import com.se.wcp.forum.dtos.UserDto;
import com.se.wcp.forum.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

/**
 * REST controller for managing users in the forum.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Gets all existing users in the system.
     *
     * @return list of users
     */
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAll();
    }

    /**
     * Creates an user.
     *
     * @param userDto the user to be create
     * @return status code 200 if success.
     */
    @PostMapping
    public Long createUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    /**
     * Gets user by id
     *
     * @param id the user identifier
     * @return the user object
     */
    @GetMapping("/{id}/")
    public UserDto getUserById(@PathVariable(value = "id") Long id) {
        return userService.getUserById(id);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<String> handleException(Exception exception, WebRequest request) {
        ResponseEntity<String> objectResponseEntity = new ResponseEntity<>("User with this id already exists", HttpStatus.BAD_REQUEST);
        return objectResponseEntity;
    }
}
