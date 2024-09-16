package com.gr.elevator.db.repo;

import com.gr.elevator.db.domain.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// recommended for database

public interface BuildingRepo extends CrudRepository <Building,Long>{

}
