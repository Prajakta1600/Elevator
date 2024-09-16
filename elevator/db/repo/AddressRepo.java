package com.gr.elevator.db.repo;

import com.gr.elevator.db.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// recommended for database

public interface AddressRepo extends CrudRepository<Address,Long> {
    Address findByBuildingID(Long buildingID);

    void deleteByBuildingID(Long buildingID);
}
