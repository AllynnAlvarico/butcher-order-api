package com.zpulse.orderapi.repository;

import com.zpulse.orderapi.model.Order;
import com.zpulse.orderapi.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(
            "from Order o " +
                    "join OrderItem oi on oi.order.order_id = o.order_id " +
                    "left join Product p on p.product_id = oi.product.product_id " +
                    "where o.customer_id = :customerId"
    )
    public List<Order> getAllOrdersByID(@Param("customerId") int customerId);


}
