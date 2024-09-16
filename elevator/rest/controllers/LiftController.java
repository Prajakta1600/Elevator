package com.gr.elevator.rest.controllers;

import com.gr.elevator.rest.model.LiftDto;
import com.gr.elevator.svc.manager.ILiftManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Lift")

public class LiftController {

    @Autowired
    private ILiftManager liftManager;

    @GetMapping("/{id}")
    public ResponseEntity<LiftDto> getLift(@PathVariable Long id) {
        System.out.println("Fetching Lifts with ID : " + id);
        LiftDto liftDto =  liftManager.findById(id);
        return new ResponseEntity<>(liftDto, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<LiftDto>> getLift() {
        System.out.println("Fetching all Lifts");
        List<LiftDto> liftDtos = liftManager.findAll();
        return new ResponseEntity<>(liftDtos, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<LiftDto> createLift(@RequestBody LiftDto liftDto) {
        System.out.println("Creating a new lift");
        return new ResponseEntity<>(liftManager.createLift(liftDto), HttpStatus.CREATED);
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
    public Boolean deleteLift() {
        System.out.println("Deleting all lifts");
        return liftManager.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Long deleteLift(@PathVariable Long id) {
        System.out.println("Deleting lift with id " + id);
        return liftManager.deleteById(id);
    }

    public List<LiftDto> findByBuildingID(Long buildingID){
        List<LiftDto> liftDtos = liftManager.findByBuildingID(buildingID);
        return liftDtos;
    }

    public void deleteByBuildingID(Long buildingID){
        liftManager.deleteByBuildingID(buildingID);
    }
}