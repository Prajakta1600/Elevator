package com.gr.elevator.rest.model;

import com.gr.elevator.db.domain.Building;
import com.gr.elevator.db.domain.Direction;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class LiftDto {

    private Long id;
    private Long buildingID;
    private String name;
    private String description;


    private Direction direction;
    private String status;
    private Boolean Enabled;
    private Boolean idle;
    private Boolean isFanOn;
    private Long currentFloor;
    private List<Long> destinationFloors;
    private Double weight;
    private Boolean isDoorOpen;

}
