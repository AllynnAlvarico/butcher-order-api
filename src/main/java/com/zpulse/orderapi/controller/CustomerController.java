package com.zpulse.orderapi.controller;

import com.zpulse.orderapi.model.Customer;
import com.zpulse.orderapi.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * * Controller class for managing Customer-related API endpoints.
 * @Description:
 * @- Handles HTTP requests related to Customer entities.
 * @- Delegates business logic to the CustomerService.
 * @- Maps API endpoints to service methods for Customer operations.
 * @Annotation:
 * @- @RestController
 * @- @RequestMapping
 * @- @RequiredArgsConstructor
 * @- @GetMapping
 * @- @PostMapping
 * @- @DeleteMapping
 * @- @PathVariable
 * @- @RequestBody
 * @- @ResponseEntity
 * @Comments:
 * @- RestController annotation is used to create RESTful web services in Spring.
 * @- RequestMapping annotation is used to map HTTP requests to handler methods.
 * @Explanations:
 * @- This class serves as the entry point for Customer-related API requests.
 * @- It receives HTTP requests, processes them, and returns appropriate responses.
 * @- It relies on the CustomerService to perform business logic and data operations.
 * @Variables:
 * @-Logger: Logger instance for logging information and errors.
 * @-CustomerService: Service class for Customer business logic.
 * @Methods:
 * @-getAllCustomers: Retrieves all customers.
 * @-getCustomer: Retrieves a customer by ID.
 * @-createCustomer: Creates a new customer.
 * @-deleteCustomer: Deletes a customer by ID.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 24/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 24/12/2025
 * @By: Allynn Alvarico
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        System.out.println(this.getClass().getName() + ": (Constructor) Initializing CustomerController");
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        System.out.println(this.getClass().getName() + ": (getAllCustomers) Fetching all customers");
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        System.out.println(this.getClass().getName() + ": (getCustomer) Fetching customer with ID: " + id);
        return customerService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public Customer createCustomer(@RequestBody Customer customer) {
        System.out.println(this.getClass().getName() + ": (createCustomer) Creating new customer");
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        System.out.println(this.getClass().getName() + ": (deleteCustomer) Deleting customer with ID: " + id);
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
