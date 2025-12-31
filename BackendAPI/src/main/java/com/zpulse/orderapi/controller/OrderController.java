package com.zpulse.orderapi.controller;

import com.zpulse.orderapi.model.Order;
import com.zpulse.orderapi.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * * Controller class for managing Order-related API endpoints.
 * @Description:
 * @- Handles HTTP requests related to Order entities.
 * @- Delegates business logic to the OrderService.
 * @- Maps API endpoints to service methods for Orders operations.
 * @Annotation:
 * @- @RestController
 * @- @RequestMapping
 * @- @GetMapping
 * @Comments:
 * @- RestController annotation is used to create RESTful web services in Spring.
 * @- RequestMapping annotation is used to map HTTP requests to handler methods.
 * @Explanations:
 * @- This class serves as the entry point for Customer-related API requests.
 * @- It receives HTTP requests, processes them, and returns appropriate responses.
 * @- It relies on the CustomerService to perform business logic and data operations.
 * @Variables:
 * @-Logger: Logger instance for logging information and errors.
 * @-CustomerService: Service class for Order business logic.
 * @Methods:
 * @-getLimitProducts: Retrieves limit number of products like 6 products.
 * @author Anson Ling Guang Cheng
 * @CreatedOn
 * @Date: 27/12/2025
 * @By: Anson Ling Guang Cheng
 * @UpdatedOn
 * @Date: 29/12/2025
 * @By: Anson Ling Guang Cheng
 */

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;

    /**
     * @Constructor
     * @UpdatedBy: Anson Ling Guang Cheng
     * @param orderService
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/orders")
    public List<Order> orders(@RequestParam int customerId) {
        return orderService.getAllOrdersById(customerId);
    }
}
