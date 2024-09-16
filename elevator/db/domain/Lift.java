package com.gr.elevator.db.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Lift extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
