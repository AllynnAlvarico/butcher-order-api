package com.zpulse.orderapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Entity class representing an Order.
 * @Description:
 * @- Maps to the "Orders" table in the database.
 * @- Contains fields for order details such as customer ID, order status, total price, creation date, and update date.
 * @Purpose:
 * @- To define the Order entity and its mapping to the database table.
 * @Variables:
 * @-order_id: Unique identifier for the order.
 * @-customer_id: Identifier for the customer who placed the order.
 * @-order_status: Status of the order (e.g., pending, completed).
 * @-total_price: Total price of the order.
 * @-created_at: Date when the order was created.
 * @-updated_at: Date when the order was last updated.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdateOn
 * @Date: 29/12/2025
 * @By: Anson Ling Guang Cheng
 */
@Entity
@Table(name = "Orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String order_id;

    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "order_status")
    private String order_status;

    @Column(name = "total_price")
    private Double total_price;

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

    /**
     * @OneToMany annotation for define the relationship
     * @UpdatedBy: Anson Ling Guang Cheng
     */
    @OneToMany(
            mappedBy = "order",
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH
                    }
    )
    @JsonIgnore
    public List<OrderItem> orderItems;
}
