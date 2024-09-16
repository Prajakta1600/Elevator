package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.Notification;
import com.gr.elevator.db.repo.NotificationRepo;
import com.gr.elevator.svc.Service.INotificationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService implements INotificationService {
    @Autowired
    private NotificationRepo notificationRepo;


    @Override
    public Notification create(Notification notification) {
        System.out.println("Creating notification in service");
        return notificationRepo.save(notification);
    }

    @Override
    public Notification update(Notification notification) {
        System.out.println("Updating notification in service");
        return notificationRepo.save(notification);
    }

    @Override
    public Notification findById(Long id) {
        System.out.println("Finding notification by ID in service");
        Optional<Notification> optionalNotification = notificationRepo.findById(id);
        if (optionalNotification.isPresent()) {
            return optionalNotification.get();
        } else {
            throw new EntityNotFoundException("Notification not found with id " + id);
        }
    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting notification by ID in service");
        notificationRepo.deleteById(id);
        return id;
    }

    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting notifications in service");
        notificationRepo.deleteAll();
        return true;
    }

    @Override
    public List<Notification> findAll() {
        System.out.println("Finding notifications in service");
        return (ArrayList<Notification>)notificationRepo.findAll();
    }
}
