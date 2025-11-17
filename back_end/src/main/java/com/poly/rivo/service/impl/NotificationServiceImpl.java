package com.poly.rivo.service.impl;


import com.poly.rivo.entity.Notification;
import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.constant.NotificationType;
import com.poly.rivo.infrastructure.response.NotificationResponse;
import com.poly.rivo.repository.INotificationRepository;
import com.poly.rivo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private INotificationRepository notificationRepository;

    @Override
    public List<NotificationResponse> getByAccount(Long idAccount) {
        return notificationRepository.getByAccount(idAccount);
    }

    @Override
    public ResponseObject updateType(Long id) {
        Notification notification = notificationRepository.findById(id).get();
        notification.setType(NotificationType.DA_DOC);
        return new ResponseObject(notificationRepository.save(notification));
    }

    @Override
    public void delete(Long idNotification) {
        notificationRepository.deleteById(idNotification);
    }

    @Override
    public void deleteAllByAccount(Long idAccount) {
        notificationRepository.deleteAll(notificationRepository.findByAccountId(idAccount));
    }
}

