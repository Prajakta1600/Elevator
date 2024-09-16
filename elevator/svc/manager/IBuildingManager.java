package com.gr.elevator.svc.manager;


import com.gr.elevator.db.domain.Floor;
import com.gr.elevator.db.domain.Lift;
import com.gr.elevator.rest.model.BuildingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBuildingManager {

    BuildingDto createBuilding(BuildingDto buildingDto);

    BuildingDto addFloor(List<Floor> floors);

    BuildingDto addLifts(List<Lift> lifts);

    BuildingDto findById(Long id);

    List<BuildingDto> findAll();

    Boolean deleteAll();

    Long deleteById(Long id);

    BuildingDto updateBuilding(BuildingDto buildingDto);





//updateLiftSatus, updateFloorStatus, updateMode,
}
