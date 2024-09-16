package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.User;
import com.gr.elevator.rest.model.UserDto;
import com.gr.elevator.svc.mapper.UserMapper;
import com.gr.elevator.svc.Service.IBaseService;
import com.gr.elevator.svc.manager.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagerService implements IUserManager {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IBaseService<User> userService;

    @Override
    public UserDto createUser(UserDto userDto) {
        System.out.println("Creating a new user in manager");
        User user = userMapper.toDomain(userDto);
        return userMapper.toDTO(userService.create(user));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        System.out.println("Updating user in manager");
        User user = userMapper.toDomain(userDto);
        return userMapper.toDTO(userService.update(user));
    }

    @Override
    public UserDto findById(Long id) {
        System.out.println("Finding user in manager");
        return userMapper.toDTO(userService.findById(id));
    }
    @Override
    public List<UserDto> findAll() {
        System.out.println("Finding users in manager");
        List<User> usersList =  userService.findAll();
        return userMapper.toDTO(usersList);
    }
    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting users in manager");
        return userService.deleteAll();
    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting user in manager");
        return userService.deleteById(id);
    }
}
