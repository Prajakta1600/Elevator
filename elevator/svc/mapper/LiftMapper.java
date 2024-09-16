package com.gr.elevator.svc.mapper;

import com.gr.elevator.db.domain.Lift;
import com.gr.elevator.rest.model.LiftDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiftMapper implements BaseMapper<LiftDto, Lift> {

    /*
    private Long id;
    private Building building;
    private String name;
    private String description;
    private Direction direction;
    private String status;
    private boolean Enabled;
    private Boolean idle;
    private Boolean isFanOn;
    private Boolean isDoorOpen;
    private Long currentFloor;
    private List<Long> destinationFloors;
    private Double weight;
    */

    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public LiftDto toDTO(Lift lift) {
        LiftDto liftDto = new LiftDto();

        liftDto.setId(lift.getId());
        liftDto.setBuildingID(lift.getBuildingID());
        liftDto.setName(lift.getName());
        liftDto.setDescription(lift.getDescription());
        liftDto.setDirection(lift.getDirection());
        liftDto.setStatus(lift.getStatus());
        liftDto.setEnabled(lift.getEnabled());
        liftDto.setIdle(lift.getIdle());
        liftDto.setIsFanOn(lift.getIsFanOn());
        liftDto.setIsDoorOpen(lift.getIsDoorOpen());
        liftDto.setCurrentFloor(lift.getCurrentFloor());
        liftDto.setDestinationFloors(lift.getDestinationFloors());
        liftDto.setWeight(lift.getWeight());


        liftDto.setCurrentFloor(lift.getCurrentFloor());

        return liftDto;
    }

    @Override
    public Lift toDomain(LiftDto liftDto) {
        Lift lift = new Lift();

        lift.setId(liftDto.getId());
        lift.setBuildingID(liftDto.getBuildingID());
        lift.setName(liftDto.getName());
        lift.setDescription(liftDto.getDescription());
        lift.setDirection(liftDto.getDirection());
        lift.setStatus(liftDto.getStatus());
        lift.setEnabled(liftDto.getEnabled());
        lift.setIdle(liftDto.getIdle());
        lift.setIsFanOn(liftDto.getIsFanOn());
        lift.setIsDoorOpen(liftDto.getIsDoorOpen());
        lift.setCurrentFloor(liftDto.getCurrentFloor());
        lift.setDestinationFloors(liftDto.getDestinationFloors());
        lift.setWeight(liftDto.getWeight());

        return lift;
    }

}
