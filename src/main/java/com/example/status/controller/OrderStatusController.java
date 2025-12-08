package com.example.status.controller;

import com.example.status.entity.OrderStateHistoryEntity;
import com.example.status.service.OrderStatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//http://localhost:8080/api/orders/4f836855-03f0-4cb1-abf8-147a8de9b405/status
@RestController
@RequestMapping("/api/orders")
public class OrderStatusController {

    private final OrderStatusService orderStatusService;

    public OrderStatusController(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    @GetMapping("/{orderId}/status")
    public ResponseEntity<OrderStateHistoryEntity> getOrderStatus(@PathVariable String orderId) {
        return orderStatusService.getLatestOrderStatus(orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
