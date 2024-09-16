package com.gr.elevator.db.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class Building extends BaseDomain{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String status = "NA";

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // @Transient
    // private List<Floor> floors;

    // @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
    // @Transient
    // private List<Lift> lifts;

}
