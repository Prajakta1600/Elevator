package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.Floor;
import com.gr.elevator.rest.model.FloorDto;
import com.gr.elevator.svc.Service.IFloorService;
import com.gr.elevator.svc.mapper.FloorMapper;
import com.gr.elevator.svc.manager.IFloorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorManagerService implements IFloorManager {

    @Autowired
    private FloorMapper floorMapper;

    @Autowired
    private IFloorService floorService;

    @Override
    public FloorDto createFloor(FloorDto floorDto) {
        System.out.println("Creating a new floor in manager");
        Floor floor = floorMapper.toDomain(floorDto);
        return floorMapper.toDTO(floorService.create(floor));
    }

    @Override
    public FloorDto updateFloor(FloorDto floorDto) {
        System.out.println("Updating floor in manager");
        Floor floor = floorMapper.toDomain(floorDto);
        return floorMapper.toDTO(floorService.update(floor));
    }

    @Override
    public FloorDto findById(Long id) {
        System.out.println("Finding floor in manager");
        return floorMapper.toDTO(floorService.findById(id));
    }

    @Override
    public List<FloorDto> findAll() {
        System.out.println("Finding floors in manager");
        List<Floor> floorList  = floorService.findAll();
        return floorMapper.toDTO(floorList);
    }

    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting floors in manager");
        return floorService.deleteAll();
    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting floor in manager");
        return floorService.deleteById(id);
    }


    @Override
    public List<FloorDto> findByBuildingID(Long buildingID){
        List<FloorDto> floorDtos = floorMapper.toDTO(floorService.findByBuildingID(buildingID));
        return floorDtos;
    }

    @Override
    public void deleteByBuildingID(Long buildingID){
        floorService.deleteByBuildingID(buildingID);
    }
}


