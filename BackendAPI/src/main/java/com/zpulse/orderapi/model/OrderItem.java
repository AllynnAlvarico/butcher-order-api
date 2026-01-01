package com.zpulse.orderapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Entity class representing an Order Item.
 * @Description:
 * @- Maps to the "Orders_Items" table in the database.
 * - Contains fields for order item details such as order ID, product ID, weight in kg, and total price.
 * @Purpose:
 * @- To define the OrderItem entity and its mapping to the database table.
 * @Variables:
 * @-order_item_id: Unique identifier for the order item.
 * @-order_id: Identifier for the order to which this item belongs.
 * @-product_id: Identifier for the product in the order item.
 * @-weight_kg: Weight of the product in kilograms.
 * @-total_price: Total price for this order item.
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
@Table(name = "Orders_Items")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_item_id;

    /**
     * @UpdatedBy: Anson Ling Guang Cheng
     * @Reason:
     *  - Because I need to use join method for SQL Query
     *  - So I need to link this to another object that is connected with
     *  - And define the relation using the @OneToMany or @ManyToOne annotation
     *  - To map that relationship in our database
     *  - Future Explanation & Source: https://www.baeldung.com/jpa-joincolumn-vs-mappedby
     */
//    @Column(name = "order_id", nullable = false)
//    private String order_id;
//
//    @Column(name = "product_id", nullable = false)
//    private String product_id;

    @Column(name = "weight_kg")
    private Double weight_kg;

    @Column(name = "total_price")
    private Double total_price;

    /**
     * @ManyToOne annotation for define the relationship
     * @UpdatedBy: Anson Ling Guang Cheng
     */
    @ManyToOne(
            cascade = { CascadeType.ALL }
    )
    @JoinColumn(name = "order_id")
    public Order order;

    /**
     * @ManyToOne annotation for define the relationship
     * @UpdatedBy: Anson Ling Guang Cheng
     */
    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            }
    )
    @JoinColumn(name = "product_id")
    public Product product;

}
