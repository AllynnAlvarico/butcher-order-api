package com.zpulse.orderapi.service;

import com.zpulse.orderapi.dto.OrderItemDTO;
import com.zpulse.orderapi.model.OrderItem;
import com.zpulse.orderapi.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    /**
     * @Constructor
     * @UpdatedBy: Anson Ling Guang Cheng
     * @param orderItemRepository
     */
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    // A method for OrderItem controller for getting a list of order data by id
    public Optional<OrderItem> getAllOrderById(int id) {
        return orderItemRepository.getAllOrdersByID(id);
    }

    // save order item to database
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // delete order from database
    @Modifying
    @Transactional
    public void deleteOrderById(int id) {
        orderItemRepository.deleteById(id);
    }
}
