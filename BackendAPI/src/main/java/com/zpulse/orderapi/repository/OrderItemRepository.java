package com.zpulse.orderapi.repository;

import com.zpulse.orderapi.dto.OrderItemDTO;
import com.zpulse.orderapi.model.OrderItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for OrderItem entity.
 * Extends JpaRepository to provide CRUD operations and more.
 * @Description:
 * @- Provides methods to interact with the OrderItems table in the database.
 * @Annotation:
 * @- @Repository (inherited from JpaRepository)
 * @Comments:
 * @- This interface allows for easy data access and manipulation of OrderItem records.
 * @Explanations:
 * This is to facilitate database operations related to OrderItem entities.
 * @Methods:
 * @- Inherited methods from JpaRepository such as save, findById, findAll, deleteById, etc.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 01/01/2026
 * @By: Anson Ling Guang Cheng
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    @Query(
            "from OrderItem oi " +
                    "join Order o on o.order_id = oi.order.order_id " +
                    "left join Product p on p.product_id = oi.product.product_id " +
                    "where o.customer_id= :customerId"
    )
    Optional<OrderItem> getAllOrdersByID(@Param("customerId") int customerId);

}
