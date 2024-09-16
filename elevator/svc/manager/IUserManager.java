package com.gr.elevator.svc.manager;

import com.gr.elevator.rest.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserManager {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    UserDto findById(Long id);

    List<UserDto> findAll();

    Boolean deleteAll();

    Long deleteById(Long id);
}
