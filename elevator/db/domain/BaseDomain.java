package com.gr.elevator.db.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@MappedSuperclass

public class BaseDomain {

    private String createdByName;

    private String updatedByName;

    private Date createdDate;

    private Date updatedDate;

    @PrePersist
    public void onCreate(){
        this.setCreatedByName("SYSTEM");
        this.setUpdatedByName("SYSTEM");
        this.setCreatedDate(new Date());
        this.setUpdatedDate(new Date());
    }

    @PreUpdate
    public void onUpdate(){
        this.setUpdatedByName("SYSTEM");
        this.setUpdatedDate(new Date());
    }
}

