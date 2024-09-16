package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.Building;
import com.gr.elevator.db.repo.BuildingRepo;
import com.gr.elevator.svc.Service.IBuildingService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepo buildingRepo;

    @Autowired
    private AddressService addressService;

    @Autowired
    private FloorService floorService;

    @Autowired
    private LiftService liftService;

    @Override
    public Building create(Building building) {
        System.out.println("Creating a new building in service");
        // throw new IllegalArgumentException("Address is a mandatory field");

        return buildingRepo.save(building);
    }

    @Override
    public Building update(Building building) {
        System.out.println("Updating building in service");
        return buildingRepo.save(building);
    }

    @Override
    public Building findById(Long id) {
        System.out.println("Finding building in service");

        return buildingRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Building not found with id " + id));
    }


    @Override
    @Transactional
    public Long deleteById(Long id) {
        System.out.println("Deleting building in service");
        if (!buildingRepo.existsById(id)) {
            throw new EntityNotFoundException("Building not found with id " + id);
        }
        floorService.deleteByBuildingID(id);
        liftService.deleteByBuildingID(id);
        buildingRepo.deleteById(id);
        return id;
    }

    @Override
    @Transactional
    public Boolean deleteAll() {
        System.out.println("Deleting all buildings in service");
        // Efficiently delete all associated entities
        addressService.deleteAll();
        floorService.deleteAll();
        liftService.deleteAll();
        buildingRepo.deleteAll();  // Bulk delete buildings
        return true;
    }

    @Override
    public List<Building> findAll() {
        System.out.println("Finding all buildings in service");
        ArrayList<Building> list = (ArrayList<Building>) buildingRepo.findAll();
        return list;
    }
}