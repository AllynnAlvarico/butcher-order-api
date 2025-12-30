package com.zpulse.orderapi.repository;

import com.zpulse.orderapi.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Admin entity.
 * Extends JpaRepository to provide CRUD operations for Admin.
 * @Description:
 * @- Provides methods to interact with the Admins table in the database.
 * @Methods:
 * @- isVerified: Checks if an admin with the given username and password is correct.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 30/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 30/12/2025
 * @By: Allynn Alvarico
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    /**
     * Checks if an admin with the given username and password exists.
     * @Method: isVerified
     * @param adminUsername
     * @param adminPassword
     * @return Boolean - true if the admin exists, false otherwise.
     * @Author: Allynn Alvarico
     */
    Boolean existsByAdminUsernameAndAdminPassword(String adminUsername, String adminPassword);

}
