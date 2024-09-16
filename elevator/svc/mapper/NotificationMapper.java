package com.gr.elevator.svc.mapper;

import com.gr.elevator.db.domain.Notification;
import com.gr.elevator.rest.model.NotificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationMapper implements BaseMapper<NotificationDto,Notification> {

    @Autowired
    private LiftMapper liftMapper;

    @Override
    public NotificationDto toDTO(Notification notification) {
        NotificationDto notificationDto = new NotificationDto();

        notificationDto.setId(notification.getId());
        notificationDto.setWeight(notification.getWeight());
        notificationDto.setCurrentFloor(notification.getCurrentFloor());
        notificationDto.setDestinationFloor(notification.getDestinationFloor());
        notificationDto.setLiftDto(liftMapper.toDTO(notification.getLift()));

        return notificationDto;
    }

    @Override
    public Notification toDomain(NotificationDto notificationDto) {

        Notification notification = new Notification();

        notification.setId(notificationDto.getId());
        notification.setWeight(notificationDto.getWeight());
        notification.setCurrentFloor(notificationDto.getCurrentFloor());
        notification.setDestinationFloor(notificationDto.getDestinationFloor());
        notification.setLift(liftMapper.toDomain(notificationDto.getLiftDto()));

        return notification;
    }
}
