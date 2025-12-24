package com.zpulse.orderapi.repository;

import com.zpulse.orderapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Order entity.
 * Extends JpaRepository to provide CRUD operations and more.
 * @Description:
 * @- Provides methods to interact with the Orders table in the database.
 * @Annotation:
 * @- @Repository (inherited from JpaRepository)
 * @Comments:
 * @- This interface allows for easy data access and manipulation of Order records.
 * @Explanations:
 * This is to facilitate database operations related to Order entities.
 * @Methods:
 * @- Inherited methods from JpaRepository such as save, findById, findAll, deleteById, etc.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
