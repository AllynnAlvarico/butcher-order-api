package com.zpulse.orderapi.model;


import jakarta.persistence.*;
import lombok.Data;


/** Admin entity representing the admin_database table.
 * Contains fields for id, username, and password of the admin.
 * @Description:
 * @- Maps to the "admin_database" table in the database.
 * @- Contains fields for admin details such as username and password.
 * @Comments:
 * @- This entity is used to store and manage admin credentials.
 * @Variables:
 * @-id: Unique identifier for the admin.
 * @-username: Username of the admin.
 * @-password: Password of the admin.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 30/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 30/12/2025
 * @By: Allynn Alvarico
 */
@Entity
@Table(name = "admin_database")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "adminUsername")
    private String adminUsername;

    @Column(name = "adminPassword")
    private String adminPassword;


}
