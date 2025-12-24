package com.zpulse.orderapi.service;

import com.zpulse.orderapi.model.Customer;
import com.zpulse.orderapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
 * @-createCustomer: Saves a new customer to the database.
 * @-findByEmail: Retrieves a customer by their email address.
 * @-getAll: Retrieves all customers from the database.
 * @-getById: Retrieves a customer by their unique ID.
 * @-delete: Deletes a customer by their unique ID.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 24/12/2025
 * @By: Allynn Alvarico
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    /**
     * @Constructor
     * @UpdatedBy: Allynn Alvarico
     * @param customerRepository
     */
    public CustomerService(CustomerRepository customerRepository) {
        System.out.println(this.getClass().getName() + ": (Constructor) Initializing CustomerService");
        this.customerRepository = customerRepository;
    }

    /**
     * @Method: createCustomer
     * @UpdatedBy: Allynn Alvarico
     * @Return: List of Customer's Data
     */
    public Customer createCustomer(Customer customer) {
        System.out.println(this.getClass().getName() + ": (createCustomer) Creating customer: " + customer.toString());
        customer.setCreatedAt(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    /**
     * @Method: findByEmail
     * @UpdatedBy: Allynn Alvarico
     * @param email
     * @Return List of Customer's Data
     */
    public Optional<Customer> findByEmail(String email) {
        System.out.println(this.getClass().getName() + ": (findByEmail) Finding customer by email: " + email);
        return customerRepository.findByEmail(email);
    }

    /**
     * @Method: getAll
     * @UpdatedBy: Allynn Alvarico
     * @Return List of Customers
     */
    public List<Customer> getAll() {
        System.out.println(this.getClass().getName() + ": (getAll) Retrieving all customers");
        return customerRepository.findAll();
    }

    /**
     * @Method: getById
     * @UpdatedBy: Allynn Alvarico
     * @param id
     * @Return List of Customer's Data
     */
    public Optional<Customer> getById(Long id) {
        System.out.println(this.getClass().getName() + ": (getById) Retrieving customer by ID: " + id);
        return customerRepository.findById(id);
    }

    /**
     * @Method: delete
     * @UpdatedBy: Allynn Alvarico
     * @param id
     */
    public void delete(Long id) {
        System.out.println(this.getClass().getName() + ": (delete) Deleting customer by ID: " + id);
        customerRepository.deleteById(id);
    }
}
