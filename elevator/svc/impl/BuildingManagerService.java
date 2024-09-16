package com.gr.elevator.svc.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gr.elevator.db.domain.Building;
import com.gr.elevator.db.domain.Floor;
import com.gr.elevator.db.domain.Lift;
import com.gr.elevator.rest.model.AddressDto;
import com.gr.elevator.rest.model.BuildingDto;
import com.gr.elevator.rest.model.FloorDto;
import com.gr.elevator.rest.model.LiftDto;
import com.gr.elevator.svc.Service.IAddressService;
import com.gr.elevator.svc.Service.IBuildingService;
import com.gr.elevator.svc.Service.IFloorService;
import com.gr.elevator.svc.Service.ILiftService;
import com.gr.elevator.svc.manager.IBuildingManager;
import com.gr.elevator.svc.mapper.AddressMapper;
import com.gr.elevator.svc.mapper.BuildingMapper;

import com.gr.elevator.svc.mapper.FloorMapper;
import com.gr.elevator.svc.mapper.LiftMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuildingManagerService implements IBuildingManager {

    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private FloorMapper floorMapper;

    @Autowired
    private IFloorService floorService;

    @Autowired
    private LiftMapper liftMapper;

    @Autowired
    private ILiftService liftService;

    @Override
    public BuildingDto createBuilding(BuildingDto buildingDto) {
        log.info("Going to create building with {}", buildingDto);

        //create building
        return buildingMapper.toDTO(buildingService.create(buildingMapper.toDomain(buildingDto)));

    }

    @Override
    public BuildingDto updateBuilding(BuildingDto buildingDto) {
        log.info("Going to update building with {}", buildingDto);
        return buildingMapper.toDTO(buildingService.update(buildingMapper.toDomain(buildingDto)));
    }


    @Override
    public BuildingDto findById(Long id) {
        System.out.println("Finding building in manager");
        Building building = buildingService.findById(id);
        BuildingDto buildingDto = buildingMapper.toDTO(building);
        return buildingDto;
    }

    @Override
    public List<BuildingDto> findAll() {
        System.out.println("Finding buildings in manager");
        List<BuildingDto> buildingList = buildingService.findAll().stream().map(building -> {
            BuildingDto buildingDto = buildingMapper.toDTO(building);
            return buildingDto;
        }).collect(Collectors.toList());
        return buildingList;
    }


    // building cannot be deleted before address, address cannot be deleted before building
    // infinity paradox

    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting building in manager");
        buildingService.deleteAll();
        return true;
    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting building in manager");
        buildingService.deleteById(id);
        return id;
    }

    @Override
    public BuildingDto addFloor(List<Floor> floors) {
        return null;
    }

    @Override
    public BuildingDto addLifts(List<Lift> lifts) {
        System.out.println("Adding lifts in building in manager");
        return null;
    }
}
