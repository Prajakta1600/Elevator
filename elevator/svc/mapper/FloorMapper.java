package com.gr.elevator.svc.mapper;

import com.gr.elevator.db.domain.Floor;
import com.gr.elevator.rest.model.FloorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorMapper implements BaseMapper<FloorDto, Floor> {

    /*
    private Long id;
    private BuildingDto buildingDto;
    private String name;
    private String description;
    private String status;
    private Integer floorNumber;
    private boolean access;
    */

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public FloorDto toDTO(Floor floor) {
        FloorDto floorDto = new FloorDto();

        floorDto.setBuildingID(floor.getBuildingID());
        floorDto.setId(floor.getId());
        floorDto.setName(floor.getName());
        floorDto.setDescription(floor.getDescription());
        floorDto.setStatus(floor.getStatus());
        floorDto.setFloorNumber(floor.getFloorNumber());
        floorDto.setAccess(floor.isAccess());

        return floorDto;
    }

    @Override
    public Floor toDomain(FloorDto floorDto) {
        Floor floor = new Floor();

        floor.setId(floorDto.getId());
        floor.setBuildingID(floorDto.getBuildingID());
        floor.setName(floorDto.getName());
        floor.setDescription(floorDto.getDescription());
        floor.setStatus(floorDto.getStatus());
        floor.setFloorNumber(floorDto.getFloorNumber());
        floor.setAccess(floorDto.isAccess());

        return floor;
    }

}
