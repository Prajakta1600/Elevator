package com.gr.elevator.rest.controllers;

import com.gr.elevator.rest.model.UserDto;
import com.gr.elevator.svc.manager.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private IUserManager userManager;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        System.out.println("Fetching Users with ID : " + id);
        UserDto userDto = userManager.findById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getUser() {
        System.out.println("Fetching all Users");
        List<UserDto> userDtoList = userManager.findAll();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        System.out.println("Creating a new user");
        return new ResponseEntity<>(userManager.createUser(userDto), HttpStatus.CREATED);
    }

    /*
    @PatchMapping("/address/{buildingId}")
    public ResponseEntity<String> updateBuildingAddress(@RequestBody Address address, @PathVariable Long buildingId) {
        System.out.println("Updating address for building ID: " + buildingId);
        if (building != null && building.getId().equals(buildingId)) {
            building.setAddress(address);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } else {
            System.out.println("No Building Found");
            return new ResponseEntity<>("Building not found", HttpStatus.NOT_FOUND);
        }
    }
    */

    @DeleteMapping()
    public Boolean deleteUser() {
        System.out.println("Deleting all Users");
        return userManager.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Long deleteUser(@PathVariable Long id) {
        System.out.println("Deleting user with id " + id);
        return userManager.deleteById(id);
    }
}