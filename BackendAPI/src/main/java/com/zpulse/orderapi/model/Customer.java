package com.zpulse.orderapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entity class representing a Customer.
 * @Description:
 * @- Maps to the "butcher_database" table in the database.
 * @- Contains fields for employee details such as first name, last name, email, phone number, hire date, employment type, and role ID.
 * @Annotation:
 * @- @Entity, @Table, @Data, @Id, @GeneratedValue, @Column
 * @Comments:
 * @- So that when I come back to this code later, I can easily understand what each annotation does.
 * @Explanations:
 * This is to define the Employee entity and its mapping to the database table.
 * @Variables:
 * @-customerId: Unique identifier for the customer.
 * @-first_name: First name of the customer.
 * @-last_name: Last name of the customer.
 * @-phone: Phone number of the customer.
 * @-email: Email address of the customer.
 * @-created_at: Date when the customer was created.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 24/12/2025
 * @By: Allynn Alvarico
 */
@Entity
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
