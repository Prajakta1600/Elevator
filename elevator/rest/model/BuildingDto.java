package com.gr.elevator.rest.model;

import com.gr.elevator.db.domain.Address;
import com.gr.elevator.db.domain.Floor;
import com.gr.elevator.db.domain.Lift;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BuildingDto {

    private Long id;
    private String name;
    private String description;
    private String status;
    private AddressDto address;
    private List<LiftDto> lifts;
    private List<FloorDto> floors;

    private String createdByName;

    private String updatedByName;

    private Date createdDate;

    private Date updatedDate;

    public BuildingDto(Long id) {
        this.id = id;
    }
}