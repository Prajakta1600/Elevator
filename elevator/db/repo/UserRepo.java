package com.gr.elevator.db.repo;

import com.gr.elevator.db.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// recommended for database
public interface UserRepo extends CrudRepository<User,Long> {
}
