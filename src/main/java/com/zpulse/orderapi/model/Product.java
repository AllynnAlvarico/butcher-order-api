package com.zpulse.orderapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * Entity class representing a Product.
 * @Description:
 * @- Maps to the "Products" table in the database.
 * @- Contains fields for product details such as name, category, price per kg, availability, creation date, and update date.
 * @Purpose:
 * @- To define the Product entity and its mapping to the database table.
 * @Variables:
 * @-product_id: Unique identifier for the product.
 * @-product_name: Name of the product.
 * @-product_category: Category of the product.
 * @-price_per_kg: Price of the product per kilogram.
 * @-is_available: Availability status of the product.
 * @-created_at: Date when the product was created.
 * @-updated_at: Date when the product was last updated.
 * @author Allynn Alvarico
 */

@Entity
@Table(name = "Products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String product_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_category")
    private String product_category;

    @Column(name = "price_per_kg")
    private Double price_per_kg;

    @Column(name = "available")
    private Boolean is_available;

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

}
