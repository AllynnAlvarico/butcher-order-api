package com.zpulse.orderapi.controller;

import com.zpulse.orderapi.model.OrderItem;
import com.zpulse.orderapi.repository.OrderItemRepository;
import com.zpulse.orderapi.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/order_item")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // get list of orders by customer id
    @GetMapping("/orders")
    public ResponseEntity<Optional<OrderItem>> getAllOrders(
            @RequestParam int customerId
    ) {
        Optional<OrderItem> orderItems = orderItemService.getAllOrderById(customerId);
        if (orderItems.isEmpty())
            return new ResponseEntity<>(orderItems, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }

}
