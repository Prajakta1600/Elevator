package com.gr.elevator.rest.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class NotificationDto {
    private Long id;
    private LiftDto liftDto;
    private Long destinationFloor;
    private Long currentFloor;
    private Double weight;
}
