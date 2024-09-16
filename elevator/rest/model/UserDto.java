package com.gr.elevator.rest.model;

import com.gr.elevator.db.domain.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String status;
    private String password;
    private Role role;
}

