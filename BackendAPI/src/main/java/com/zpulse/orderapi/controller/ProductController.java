package com.zpulse.orderapi.controller;

import com.zpulse.orderapi.model.Product;
import com.zpulse.orderapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * * Controller class for managing Product-related API endpoints.
 * @Description:
 * @- Handles HTTP requests related to Products entities.
 * @- Delegates business logic to the ProductsService.
 * @- Maps API endpoints to service methods for Products operations.
 * @Annotation:
 * @- @RestController
 * @- @RequestMapping
 * @- @GetMapping
 * @Comments:
 * @- RestController annotation is used to create RESTful web services in Spring.
 * @- RequestMapping annotation is used to map HTTP requests to handler methods.
 * @Explanations:
 * @- This class serves as the entry point for Customer-related API requests.
 * @- It receives HTTP requests, processes them, and returns appropriate responses.
 * @- It relies on the CustomerService to perform business logic and data operations.
 * @Variables:
 * @-Logger: Logger instance for logging information and errors.
 * @-CustomerService: Service class for Customer business logic.
 * @Methods:
 * @-getLimitProducts: Retrieves limit number of products like 6 products.
 * @author Anson Ling Guang Cheng
 * @CreatedOn
 * @Date: 27/12/2025
 * @By: Anson Ling Guang Cheng
 */

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    /**
     * @param productService
     * @Constructor
     * @UpdatedBy: Anson Ling Guang Cheng
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * @Method: limitProducts
     * @UpdatedBy: Anson Ling Guang Cheng
     * @Return: A list of products data
     */
    @GetMapping("/limit-products")
    public List<Product> limitProducts() {
        return productService.limitProducts();
    }

    /**
     * @Method: allow user update the product images
     * @UpdatedBy: Anson Ling Guang Cheng
     * @Return: Http status & specific product data
     */
    @PutMapping("/update-product-image")
    public ResponseEntity<Product> updateProductImageById(
            @RequestParam int id,
            @RequestPart("product_image") MultipartFile product_image
    ) throws IOException {

        // Only Accepted File Type
        String[] fileType = {"png", "jpeg", "jpg", "gif", "webp"};

        // Get the original file name
        String fileName = product_image.getOriginalFilename();

        // check if is the accepted file type
        if(!isFileTypeAcceptable(fileType, fileName) || product_image.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        else
            productService.updateImageById(id, product_image);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public boolean isFileTypeAcceptable(String[] fileType, String fileName) {
        assert fileName != null;
        for (String s : fileType) {
            if (fileName.contains(s)) {
                return true;
            }
        }
        return false;
    }
}
