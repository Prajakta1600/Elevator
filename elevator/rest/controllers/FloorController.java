package com.gr.elevator.rest.controllers;

import com.gr.elevator.rest.model.FloorDto;
import com.gr.elevator.svc.manager.IFloorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floor")

public class FloorController {

    @Autowired
    private IFloorManager floorManager;

    @GetMapping("/{id}")
    public ResponseEntity<FloorDto> getFloor(@PathVariable Long id) {
        System.out.println("Fetching Floors with ID : " + id);
        FloorDto floorDto =  floorManager.findById(id);
        return new ResponseEntity<>(floorDto, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<FloorDto>> getFloor() {
        System.out.println("Fetching all Floors");
        List<FloorDto> floorList = floorManager.findAll();
        return new ResponseEntity<>(floorList, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<FloorDto> createFloor(@RequestBody FloorDto floorDto) {
        System.out.println("Creating a new floor");
        return new ResponseEntity<>(floorManager.createFloor(floorDto), HttpStatus.CREATED);
    }

    @PutMapping("/{floorID}")
    public ResponseEntity<String> updateBuildingAddress(@RequestBody FloorDto floorDto, @PathVariable Long floorId) {
        System.out.println("Updating floor for floor ID: " + floorId);

        FloorDto floorDto1 =  floorManager.findById(floorId);
        if (floorDto1 != null && floorDto1.getId().equals(floorId)) {
            floorManager.updateFloor(floorDto);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } else {
            System.out.println("No Building Found");
            return new ResponseEntity<>("Building not found", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping()
    public Boolean deleteFloor() {
        System.out.println("Deleting all floors");
        return floorManager.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Long deleteFloor(@PathVariable Long id) {
        System.out.println("Deleting floor with id " + id);
        return floorManager.deleteById(id);
    }

    public List<FloorDto> findByBuildingID(Long buildingID){
        List<FloorDto> floorDto = floorManager.findByBuildingID(buildingID);
        return floorDto;
    }

    public Boolean deleteByBuildingID(Long buildingID){
        floorManager.deleteByBuildingID(buildingID);
        return true;
    }

}