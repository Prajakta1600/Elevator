package com.gr.elevator.svc.mapper;

import com.gr.elevator.db.domain.Building;
import com.gr.elevator.rest.model.BuildingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingMapper implements BaseMapper<BuildingDto, Building> {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public BuildingDto toDTO(Building building) {

        BuildingDto buildingDto = new BuildingDto();

        buildingDto.setId(building.getId());
        buildingDto.setDescription(building.getDescription());
        buildingDto.setStatus(building.getStatus());
        buildingDto.setName(building.getName());
        buildingDto.setCreatedByName(building.getCreatedByName());
        buildingDto.setUpdatedByName(building.getUpdatedByName());
        buildingDto.setCreatedDate(building.getCreatedDate());
        buildingDto.setUpdatedDate(building.getUpdatedDate());

        return buildingDto;
    }

    @Override
    public Building toDomain(BuildingDto buildingDto) {
        Building building = new Building();

        building.setDescription(buildingDto.getDescription());
        building.setStatus(buildingDto.getStatus());
        building.setName(buildingDto.getName());
        building.setId(buildingDto.getId());
        building.setCreatedByName(buildingDto.getCreatedByName());
        building.setUpdatedByName(buildingDto.getUpdatedByName());
        building.setCreatedDate(buildingDto.getCreatedDate());
        building.setUpdatedDate(buildingDto.getUpdatedDate());

        return building;
    }
}
