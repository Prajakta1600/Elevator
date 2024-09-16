package com.gr.elevator.rest.controllers;

import com.gr.elevator.rest.model.NotificationDto;
import com.gr.elevator.svc.manager.INotificationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private INotificationManager notificationManager;

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDto> getNotification(@PathVariable Long id) {
        System.out.println("Fetching notification with ID: " + id);
        NotificationDto notificationDto = notificationManager.findById(id);
        return new ResponseEntity<>(notificationDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<NotificationDto>> getAllNotifications() {
        System.out.println("Fetching all notifications");
        List<NotificationDto> notificationDtoList = notificationManager.findAll();
        return new ResponseEntity<>(notificationDtoList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<NotificationDto> createNotification(@RequestBody NotificationDto notificationDto) {
        System.out.println("Creating a new notification");
        return new ResponseEntity<>(notificationManager.createNotification(notificationDto), HttpStatus.CREATED);
    }

    /*
    @PutMapping("/{notificationId}")
    public ResponseEntity<String> updateNotification(@RequestBody NotificationDto notificationDto, @PathVariable Long notificationId) {
        System.out.println("Updating notification with ID: " + notificationId);

        NotificationDto existingNotification = notificationManager.findById(notificationId);
        if (existingNotification != null && existingNotification.getId().equals(notificationId)) {
            notificationManager.updateNotification(notificationDto);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } else {
            System.out.println("Notification not found");
            return new ResponseEntity<>("Notification not found", HttpStatus.NOT_FOUND);
        }
    }
    */

    @DeleteMapping()
    public Boolean deleteAllNotifications() {
        System.out.println("Deleting all notifications");
        return notificationManager.deleteAll();
    }

    @DeleteMapping("/{id}")
    public Long deleteNotification(@PathVariable Long id) {
        System.out.println("Deleting notification with ID: " + id);
        return notificationManager.deleteById(id);
    }
}
