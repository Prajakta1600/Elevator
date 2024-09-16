package com.gr.elevator.svc.manager;

import com.gr.elevator.rest.model.LiftDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILiftManager {

    LiftDto createLift(LiftDto liftDto);

    LiftDto updateLift(LiftDto liftDto);

    LiftDto findById(Long id);

    List<LiftDto> findAll();

    Boolean deleteAll();

    Long deleteById(Long id);

    List<LiftDto> findByBuildingID(Long buildingID);

    void deleteByBuildingID(Long buildingID);
}
