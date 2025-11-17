package com.poly.rivo.service;

import com.poly.rivo.infrastructure.common.ResponseObject;
import com.poly.rivo.infrastructure.response.NotificationResponse;

import java.util.List;

public interface NotificationService {
    List<NotificationResponse> getByAccount(Long idAccount);
    ResponseObject updateType(Long id);
    void delete(Long idNotification);
    void deleteAllByAccount(Long idAccount);
}
