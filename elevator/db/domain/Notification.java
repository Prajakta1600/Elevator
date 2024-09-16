package com.gr.elevator.db.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lift_id", nullable = false)
    private Lift lift;

    private Long destinationFloor;
    private Long currentFloor;
    private Double weight;
}
