package com.se.wcp.forum.controllers;

import com.google.gson.Gson;
import com.se.wcp.forum.dtos.UserDto;
import com.se.wcp.forum.persistence.entities.Role;
import com.se.wcp.forum.services.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private UserService userService;

    private Long userId;

    @BeforeAll
    public static void init() {
    }

    @Test
    @Order(1)
    public void getAllUsers() throws Exception {
        UserDto user = UserDto
                .builder()
                .username("ivo")
                .password("123")
                .firstName("Ivo")
                .lastName("Rusev")
                .build();
        userService.save(user);
        mvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].username").value("ivo"))
                .andExpect(jsonPath("$[0].firstName").value("Ivo"))
                .andExpect(jsonPath("$[0].lastName").value("Rusev"));
    }

    @Test
    @Order(3)
    public void testGetUser() throws Exception {
        mvc.perform(get("/api/users/" + userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].username").value("ivo"))
                .andExpect(jsonPath("$[0].firstName").value("Ivo"))
                .andExpect(jsonPath("$[0].lastName").value("Rusev"));
    }

    @Test
    @Order(2)
    public void testCreateUser() throws Exception {
        UserDto user = UserDto
                .builder()
                .username("kiro-created")
                .password("123")
                .firstName("Ivo")
                .lastName("Rusev")
                .build();

        Gson gson = new Gson();
        String json = gson.toJson(user);

        MvcResult mvcResult = mvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        userId = Long.parseLong(content);

        UserDto userDto =  userService.getUserById(1);
        assertTrue(userDto != null);

    }

    @Test
    public void testUpdateUser() {

    }

    @Test
    public void testDeleteUser() {

    }

}
