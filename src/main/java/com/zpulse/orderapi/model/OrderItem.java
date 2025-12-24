package com.zpulse.orderapi.model;

import jakarta.persistence.*;
import lombok.Data;

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
 */
@Entity
@Table(name = "Orders_Items")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String order_item_id;

    @Column(name = "order_id", nullable = false)
    private String order_id;

    @Column(name = "product_id", nullable = false)
    private String product_id;

    @Column(name = "weight_kg")
    private Double weight_kg;

    @Column(name = "total_price")
    private Double total_price;
}
