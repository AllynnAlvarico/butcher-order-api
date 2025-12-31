package com.zpulse.orderapi.service;

import com.zpulse.orderapi.model.Order;
import com.zpulse.orderapi.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Customer entities.
 * @Description:
 * @- Provides methods to create, retrieve, and delete customers.
 * @- Interacts with the CustomerRepository for database operations.
 * @- Encapsulates business logic related to Customer management.
 * @Annotation:
 * @- @Service
 * @- @Autowired
 * @Comments:
 * @- Service annotation is used to create a service layer component in Spring.
 * @- so that it can be use for dependency injection like in Controller layer.
 * @Explanations:
 * @- This class acts as an intermediary between the controller layer and the repository layer.
 * @- It contains business logic for handling Customer-related operations.
 * @Variables:
 * @-CustomerRepository: Repository interface for Customer entity operations.
 * @-Logger: Logger instance for logging information and errors.
 * @Methods:
 * @-limitProducts: a method that only retrieve limit number of products specific requirement
 * @author Anson Ling Guang Cheng
 * @CreatedOn
 * @Date: 27/12/2025
 * @By: Anson Ling Guang Cheng
 */

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    /**
     * @Constructor
     * @UpdatedBy: Anson Ling Guang Cheng
     * @param orderRepository
     */
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrdersById(int id) {
        return orderRepository.getAllOrdersByID(id);
    }
}
