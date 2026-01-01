package com.zpulse.orderapi.service;

import com.zpulse.orderapi.model.Product;
import com.zpulse.orderapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing Customer entities.
 * @Description:
 * @- Provides methods to create, retrieve, and delete customers.
 * @- Interacts with the CustomerRepository for database operations.
 * @- Encapsulates business logic related to Customer management.
 * @Annotation:
 * @- @Service
 * @- @Autowired
 * @Comments:
 * @- Service annotation is used to create a service layer component in Spring.
 * @- so that it can be use for dependency injection like in Controller layer.
 * @Explanations:
 * @- This class acts as an intermediary between the controller layer and the repository layer.
 * @- It contains business logic for handling Customer-related operations.
 * @Variables:
 * @-CustomerRepository: Repository interface for Customer entity operations.
 * @-Logger: Logger instance for logging information and errors.
 * @Methods:
 * @-limitProducts: a method that only retrieve limit number of products specific requirement
 * @author Anson Ling Guang Cheng
 * @CreatedOn
 * @Date: 27/12/2025
 * @By: Anson Ling Guang Cheng
 */

@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * @Constructor
     * @UpdatedBy: Anson Ling Guang Cheng
     * @param productRepository
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * @Method: limitProducts
     * @UpdatedBy: Anson Ling Guang Cheng
     * @Return: List of Products Data
     */
    public List<Product> limitProducts() {
        return productRepository.limitProducts();
    }

    /**
     * @Method: updateImageById
     * @UpdatedBy: Anson Ling Guang Cheng
     * @Non-Return: update product image
     */
    public void updateImageById(int id, MultipartFile multipartFile) throws IOException {
        String uploadDirection = "src/main/resources/static/uploads/products_images/";
        String originalName = multipartFile.getOriginalFilename();
        String newFileName = UUID.randomUUID() + "_" + originalName;
        Path filePath = Paths.get(uploadDirection + newFileName);
        Files.createDirectories((filePath.getParent()));
        Files.write(filePath, multipartFile.getBytes());
        productRepository.addProductImageById(id, newFileName);
    }

    /**
     * @Method: findProductByID
     * @UpdatedBy: Anson Ling Guang Cheng
     * @Return: Find the specific type of product by id
     */
    public Optional<Product> findProductByID(int id) {
        return productRepository.findById(id);
    }
}
