package com.zpulse.orderapi.repository;

import com.zpulse.orderapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Customer entity.
 * Extends JpaRepository to provide CRUD operations and more.
 * @Description:
 * @- Provides methods to interact with the Customers table in the database.
 * @Annotation:
 * @- @Repository (inherited from JpaRepository)
 * @Comments:
 * @- This interface allows for easy data access and manipulation of Customer records.
 * @Explanations:
 * This is to facilitate database operations related to Customer entities.
 * @Methods:
 * @- Inherited methods from JpaRepository such as save, findById, findAll, deleteById, etc.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 26/12/2025
 * @By: Allynn Alvarico
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);

    // @UpdatedOn
    // @Date: 27/12/2025
    // @By: Anson Ling Guang Cheng
    // I'm changing the string lastName to last_name as I was getting an error here
    // The error previously I get is due to the Customer model have a string variable name last_name
    // And the method here are looking for the method name something end with last_name instead of lastName

    // added List findByLastName method to find customers by their last name
    List<Customer> findCustomerByLastName(String last_name);
}