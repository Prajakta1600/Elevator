package com.gr.elevator.rest.controllers;

import com.gr.elevator.rest.model.AddressDto;
import com.gr.elevator.rest.model.BuildingDto;
import com.gr.elevator.rest.model.FloorDto;
import com.gr.elevator.rest.model.LiftDto;
import com.gr.elevator.svc.manager.IBuildingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")

public class BuildingController {

    @Autowired
    private IBuildingManager buildingManager;
    @Autowired
    private AddressController addressController;
    @Autowired
    private FloorController floorController;
    @Autowired
    private LiftController liftController;

    @GetMapping("/{id}")
    public ResponseEntity<BuildingDto> getBuilding(@PathVariable Long id) {
        System.out.println("Fetching building with ID : " + id);
        BuildingDto buildingDto =  buildingManager.findById(id);
        AddressDto addressDto = addressController.findByBuildingID(id);
        List<FloorDto> floorDto = floorController.findByBuildingID(id);
        List<LiftDto> liftDto = liftController.findByBuildingID(id);
        buildingDto.setAddress(addressDto);
        buildingDto.setFloors(floorDto);
        buildingDto.setLifts(liftDto);
        return new ResponseEntity<>(buildingDto, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<BuildingDto>> getBuilding() {
        System.out.println("Fetching the building");
        List<BuildingDto> buildingList = buildingManager.findAll();
        buildingList = buildingList.stream().map(buildingDto -> {
            Long id = buildingDto.getId();
            AddressDto addressDto = addressController.findByBuildingID(id);
            List<FloorDto> floorDto = floorController.findByBuildingID(id);
            List<LiftDto> liftDto = liftController.findByBuildingID(id);
            buildingDto.setAddress(addressDto);
            buildingDto.setFloors(floorDto);
            buildingDto.setLifts(liftDto);
            return buildingDto;
        }).toList();
        return new ResponseEntity<>(buildingList, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<BuildingDto> createBuilding(@RequestBody BuildingDto buildingDto) {
        AddressDto addressDto = buildingDto.getAddress();
        List<FloorDto> floorDto = buildingDto.getFloors();
        List<LiftDto> liftDto = buildingDto.getLifts();

        System.out.println("Creating a new building");
        BuildingDto buildingDto1 = buildingManager.createBuilding(buildingDto);

        addressDto.setBuildingID(buildingDto1.getId());
        addressController.createAddress(addressDto);

        floorDto = floorDto.stream().map(floorDto1 -> {
            floorDto1.setBuildingID(buildingDto1.getId());
            floorController.createFloor(floorDto1);
            return floorDto1;
        }).toList();

        liftDto = liftDto.stream().map(liftDto1 -> {
            liftDto1.setBuildingID(buildingDto1.getId());
            liftController.createLift(liftDto1);
            return liftDto1;
        }).toList();

        buildingDto1.setAddress(addressDto);
        buildingDto1.setFloors(floorDto);
        buildingDto1.setLifts(liftDto);

        return new ResponseEntity<>(buildingDto1, HttpStatus.CREATED);
    }

    @PutMapping("/{buildingId}")
    public ResponseEntity<String> updateBuildingAddress(@RequestBody BuildingDto buildingDto, @PathVariable Long buildingId ) {
        System.out.println("Updating building for building ID: " + buildingId);

        BuildingDto buildingDto1 =  buildingManager.findById(buildingId);
        if (buildingDto != null && buildingDto.getId().equals(buildingId)) {
            buildingManager.updateBuilding(buildingDto);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } else {
            System.out.println("No Building Found");
            return new ResponseEntity<>("Building not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping()
    public Boolean deleteBuilding() {
        System.out.println("Deleting all buildings");
        addressController.deleteAddress();
        floorController.deleteFloor();
        liftController.deleteLift();
        return buildingManager.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Long deleteBuilding(@PathVariable Long id) {
        System.out.println("Deleting building with id " + id);
        addressController.deleteByBuildingID(id);
        floorController.deleteByBuildingID(id);
        liftController.deleteByBuildingID(id);
        return buildingManager.deleteById(id);
    }
}