package com.gr.elevator.svc.manager;

import com.gr.elevator.rest.model.NotificationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface INotificationManager {

    NotificationDto createNotification(NotificationDto notificationDto);

    NotificationDto updateNotification(NotificationDto notificationDto);

    NotificationDto findById(Long id);

    List<NotificationDto> findAll();

    Boolean deleteAll();

    Long deleteById(Long id);
}
