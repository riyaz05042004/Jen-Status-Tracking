package com.example.status.service;

import com.example.status.dao.OrderStateHistoryDao;
import com.example.status.entity.OrderStateHistoryEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderStatusService {

    private final OrderStateHistoryDao orderStateHistoryDao;

    public OrderStatusService(OrderStateHistoryDao orderStateHistoryDao) {
        this.orderStateHistoryDao = orderStateHistoryDao;
    }

    public Optional<OrderStateHistoryEntity> getLatestOrderStatus(String orderId) {
        return orderStateHistoryDao.findTopByOrderIdOrderByEventTimeDesc(orderId);
    }
}
