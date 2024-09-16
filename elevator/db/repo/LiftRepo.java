package com.gr.elevator.db.repo;

import com.gr.elevator.db.domain.Direction;
import com.gr.elevator.db.domain.Lift;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// recommended for database
public interface LiftRepo extends CrudRepository<Lift,Long> {
    void deleteByBuildingID(Long id);
    List<Lift> findByBuildingID(Long buildingID);
    List<Lift> findByDirectionOrIdle(Direction direction, Boolean isIdle);
}
