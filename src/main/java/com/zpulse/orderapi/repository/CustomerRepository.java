package com.zpulse.orderapi.repository;

import com.zpulse.orderapi.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {}