package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.Lift;
import com.gr.elevator.rest.model.LiftDto;
import com.gr.elevator.svc.Service.ILiftService;
import com.gr.elevator.svc.mapper.LiftMapper;
import com.gr.elevator.svc.manager.ILiftManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiftManagerService implements ILiftManager {
    @Autowired
    private LiftMapper liftMapper;

    @Autowired
    private ILiftService liftService;

    @Override
    public LiftDto createLift(LiftDto liftDto) {
        System.out.println("Creating a new lift in manager");
        Lift lift = liftMapper.toDomain(liftDto);
        return liftMapper.toDTO(liftService.create(lift));
    }

    @Override
    public LiftDto updateLift(LiftDto liftDto) {
        System.out.println("Updating lift in manager");
        Lift lift = liftMapper.toDomain(liftDto);
        return liftMapper.toDTO(liftService.update(lift));
    }

    @Override
    public LiftDto findById(Long id) {
        System.out.println("Finding lift in manager");
        return liftMapper.toDTO(liftService.findById(id));
    }
    @Override
    public List<LiftDto> findAll() {
        System.out.println("Finding lifts in manager");
        List<Lift> liftsList =  liftService.findAll();
        return liftMapper.toDTO(liftsList);
    }

    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting lift in manager");
        return liftService.deleteAll();
    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting lifts in manager");
        return liftService.deleteById(id);
    }

    @Override
    public List<LiftDto> findByBuildingID(Long buildingID) {
        return liftMapper.toDTO(liftService.findByBuildingID(buildingID));
    }

    @Override
    public void deleteByBuildingID(Long buildingID) {
        liftService.deleteByBuildingID(buildingID);
    }

}
