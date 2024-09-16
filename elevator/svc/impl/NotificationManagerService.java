package com.gr.elevator.svc.impl;

import com.gr.elevator.db.domain.Notification;
import com.gr.elevator.rest.model.NotificationDto;
import com.gr.elevator.svc.Service.INotificationService;
import com.gr.elevator.svc.mapper.NotificationMapper;
import com.gr.elevator.svc.manager.INotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationManagerService implements INotificationManager {

    @Autowired
    private NotificationMapper notificationMapper;

    @Autowired
    private INotificationService notificationService;

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto) {
        System.out.println("Creating a new notification in manager");
        Notification notification = notificationMapper.toDomain(notificationDto);
        return notificationMapper.toDTO(notificationService.create(notification));
    }

    @Override
    public NotificationDto updateNotification(NotificationDto notificationDto) {
        System.out.println("Updating notification in manager");
        Notification notification = notificationMapper.toDomain(notificationDto);
        return notificationMapper.toDTO(notificationService.update(notification));
    }

    @Override
    public NotificationDto findById(Long id) {
        System.out.println("Finding notification in manager");
        return notificationMapper.toDTO(notificationService.findById(id));
    }

    @Override
    public List<NotificationDto> findAll() {
        System.out.println("Finding notifications in manager");
        List<Notification> notificationsList = notificationService.findAll();
        return notificationMapper.toDTO(notificationsList);
    }

    @Override
    public Boolean deleteAll() {
        System.out.println("Deleting all notifications in manager");
        return notificationService.deleteAll();
    }

    @Override
    public Long deleteById(Long id) {
        System.out.println("Deleting notification by ID in manager");
        return notificationService.deleteById(id);
    }
}
