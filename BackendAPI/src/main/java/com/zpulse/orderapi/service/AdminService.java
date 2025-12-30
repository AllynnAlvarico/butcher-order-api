package com.zpulse.orderapi.service;

import com.zpulse.orderapi.repository.AdminRepository;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Admin entities.
 * @Description:
 * @- Provides methods to verify admin credentials.
 * @- Interacts with the AdminRepository for database operations.
 * @- Encapsulates business logic related to Admin management.
 * @Annotation:
 * @- @Service
 * @Comments:
 * @- Service annotation is used to create a service layer component in Spring.
 * @- so that it can be use for dependency injection like in Controller layer.
 * @Explanations:
 * @- This class acts as an intermediary between the controller layer and the repository layer.
 * @- It contains business logic for handling Admin-related operations.
 * @Variables:
 * @-AdminRepository: Repository interface for Admin entity operations.
 * @Methods:
 * @-isVerified: Verifies admin credentials.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 30/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 30/12/2025
 * @By: Allynn Alvarico
 */
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        System.out.println(this.getClass().getName() + ": (Constructor) Initializing AdminService");
        this.adminRepository = adminRepository;
    }

    public Boolean isVerified(String adminUsername, String adminPassword) {
        System.out.println(this.getClass().getName() + ": (isVerified) Verifying admin with username: " + adminUsername);
        return adminRepository.existsByAdminUsernameAndAdminPassword(adminUsername, adminPassword);
    }

}
