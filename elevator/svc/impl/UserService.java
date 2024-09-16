package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.User;
import com.gr.elevator.db.repo.UserRepo;
import com.gr.elevator.svc.Service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {
    private UserRepo userRepo;

    @Override
    public User create(User user) {
        System.out.println("Creating a new user in service");
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        System.out.println("Updating user in service");
        return userRepo.save(user);
    }

    @Override
    public User findById(Long id) {
        System.out.println("Finding user in service");
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        } else {
            throw new EntityNotFoundException("User not found with id " + id);
        }

    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting user in service");
        userRepo.deleteById(id);
        return id;
    }

    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting users in service");
        userRepo.deleteAll();
        return null;
    }

    @Override
    public List<User> findAll() {
        System.out.println("Finding users in service");
        Iterable<User> users = userRepo.findAll();
        return new ArrayList<>((Collection) users);
    }
}
