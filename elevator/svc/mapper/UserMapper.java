package com.gr.elevator.svc.mapper;

import com.gr.elevator.db.domain.User;
import com.gr.elevator.rest.model.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements BaseMapper<UserDto,User> {
    /*
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String status;
    private String password;
    private Role role;
    */

    @Override
    public UserDto toDTO(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setStatus(user.getStatus());
        userDto.setPassword(user.getPassword());
        userDto.setRole(user.getRole());

        return userDto;
    }

    @Override
    public User toDomain(UserDto userDto) {
        User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setStatus(userDto.getStatus());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        return user;
    }
}
