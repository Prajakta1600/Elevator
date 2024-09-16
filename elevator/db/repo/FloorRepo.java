package com.gr.elevator.db.repo;

import com.gr.elevator.db.domain.Floor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// recommended for database
public interface FloorRepo extends CrudRepository<Floor,Long> {
    void deleteByBuildingID(Long id);
    List<Floor> findByBuildingID(Long id);
}
