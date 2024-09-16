package com.gr.elevator.db.repo;

import com.gr.elevator.db.domain.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepo extends CrudRepository<Notification,Long> {
}
