package com.gr.elevator.db.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Floor extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long buildingID;
    private String name;
    private String description;
    private String status;
    private Integer floorNumber;
    private boolean access;
}
