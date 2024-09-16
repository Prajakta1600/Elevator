package com.gr.elevator.svc.manager;

import com.gr.elevator.rest.model.AddressDto;
import com.gr.elevator.rest.model.FloorDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFloorManager {

    FloorDto createFloor (FloorDto floorDto);

    FloorDto updateFloor(FloorDto floorDto);

    FloorDto findById(Long id);

    List<FloorDto> findAll();

    Boolean deleteAll();

    Long deleteById(Long id);

    List<FloorDto> findByBuildingID(Long buildingID);

    void deleteByBuildingID(Long buildingID);
}
