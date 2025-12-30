package com.zpulse.orderapi.controller;

import com.zpulse.orderapi.repository.AdminRepository;
import com.zpulse.orderapi.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    /**
     * @Constructor
     * @UpdatedBy: Allynn Alvarico
     * @param adminService
     */
    public AdminController(AdminService adminService) {
        System.out.println(this.getClass().getName() + ": (Constructor) Initializing AdminController");
        this.adminService = adminService;
    }

    /**
     * @Method: isVerified
     * @UpdatedBy: Allynn Alvarico
     * @Return: Boolean - true if the admin exists, false otherwise.
     */
    @GetMapping("/dashboard")
    public Boolean isVerified(@RequestParam("adminUsername") String adminUsername,
                              @RequestParam("adminPassword") String adminPassword) {
        System.out.println(this.getClass().getName() + ": Verifying admin: " + adminUsername);
        return adminService.isVerified(adminUsername, adminPassword);
    }
}
