package com.se.wcp.forum.dtos;

import com.se.wcp.forum.persistence.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
}
