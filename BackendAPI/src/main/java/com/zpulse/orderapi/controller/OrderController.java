package com.zpulse.orderapi.controller;

import com.zpulse.orderapi.dto.OrdersDTO;
import com.zpulse.orderapi.model.Order;
import com.zpulse.orderapi.model.OrderItem;
import com.zpulse.orderapi.model.Product;
import com.zpulse.orderapi.service.OrderItemService;
import com.zpulse.orderapi.service.OrderService;
import com.zpulse.orderapi.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // creating a logger
    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final ProductService productService;

    /**
     * @Constructor
     * @UpdatedBy: Anson Ling Guang Cheng
     * @param orderService
     * @param orderItemService
     * @param productService
     */
    public OrderController(OrderService orderService, OrderItemService orderItemService, ProductService productService) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.productService = productService;
    }

    // post method that allow user to place an order
    @PostMapping("/save-order")
    public ResponseEntity<String> saveOrders(
            @RequestBody OrdersDTO ordersDTO
    ) {
        // find product by id
        Optional<Product> product = productService.findProductByID(ordersDTO.getOrderItemDTO().getProduct_id());

        // logging debug for product
        logger.warn("Product ID: " + ordersDTO.getOrderItemDTO().getProduct_id());

        // check if product is empty then return not found http status
        if (product.isEmpty())
            return new ResponseEntity<>("Product did not found!", HttpStatus.NOT_FOUND);

        // save the order to order table in database
        Order order = orderService.saveOrder(ordersDTO.getOrder());

        // method for passing the object data to order item object
        OrderItem orderItem = passingObjectData(ordersDTO, order, product.get());

        // save order item to order_item table in database
        OrderItem orderitem = orderItemService.saveOrderItem(orderItem);

        // if order or order item is null then return bad request
        // otherwise return OK http status
        if (order == null || orderitem == null)
            return new ResponseEntity<>("Ops...something went wrong...", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("Order has been place!", HttpStatus.OK);
    }

    public OrderItem passingObjectData(OrdersDTO ordersDTO, Order order, Product product) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setWeight_kg(ordersDTO.getOrderItemDTO().getWeight_kg());
        orderItem.setTotal_price(ordersDTO.getOrder().getTotal_price());
        return orderItem;
    }
}
