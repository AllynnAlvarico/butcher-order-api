package com.zpulse.orderapi.service;

import com.zpulse.orderapi.model.Customer;
import com.zpulse.orderapi.repository.CustomerRepository;
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
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 */
@Service
public class CustomerService {
//    private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
//        LOG.info("Initializing CustomerService");
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
//        LOG.info("Creating customer with email: {}", customer.getEmail());
        return customerRepository.save(customer);
    }
    public Optional<Customer> findByEmail(String email) {
//        LOG.info("Finding customer by email: {}", email);
        return customerRepository.findByEmail(email);
    }

    public List<Customer> getAll() {
//        LOG.info("Retrieving all customers");
        return customerRepository.findAll();
    }

    public Optional<Customer> getById(Long id) {
//        LOG.info("Retrieving customer by ID: {}", id);
        return customerRepository.findById(id);
    }

    public void delete(Long id) {
//        LOG.info("Deleting customer by ID: {}", id);
        customerRepository.deleteById(id);
    }
}
