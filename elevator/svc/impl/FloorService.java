package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.Floor;
import com.gr.elevator.db.repo.FloorRepo;
import com.gr.elevator.svc.Service.IFloorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class FloorService implements IFloorService {
    @Autowired
    private FloorRepo floorRepo;

    @Override
    public Floor create(Floor floor) {
        System.out.println("Creating a new floor in service");
        return floorRepo.save(floor);
    }

    @Override
    public Floor update(Floor floor) {
        System.out.println("Updating floor in service");
        return floorRepo.save(floor);
    }

    @Override
    public Floor findById(Long id) {
        System.out.println("Finding floor in service");
        Optional<Floor> optionalFloor = floorRepo.findById(id);
        if (optionalFloor.isPresent()) {
            return optionalFloor.get();
        } else {
            throw new EntityNotFoundException("Floor not found with id " + id);
        }
    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting floor in service");
        floorRepo.deleteById(id);
        return id;
    }

    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting floors in service");
        floorRepo.deleteAll();
        return null;
    }

    @Override
    public List<Floor> findAll() {
        System.out.println("Finding floors in service");
        Iterable<Floor> floors = floorRepo.findAll();
        return new ArrayList<>((Collection) floors);
    }

    @Override
    public List<Floor> findByBuildingID(Long buildingID) {
        System.out.println("Finding floor by building ID in service");
        return floorRepo.findByBuildingID(buildingID);
    }

    @Override
    @Transactional
    public void deleteByBuildingID(Long id) {
        System.out.println("Deleting floor by building ID in service");
        floorRepo.deleteByBuildingID(id);
    }
}
