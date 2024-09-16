package com.gr.elevator.rest.model;

import com.gr.elevator.db.domain.Building;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class FloorDto {

    private Long id;
    private Long buildingID;
    private String name;
    private String description;
    private String status;
    private Integer floorNumber;
    private boolean access;
}