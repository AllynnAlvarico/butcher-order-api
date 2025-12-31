package com.zpulse.orderapi.repository;

import com.zpulse.orderapi.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Product entity.
 * Extends JpaRepository to provide CRUD operations and more.
 * @Description:
 * @- Provides methods to interact with the Products table in the database.
 * @Annotation:
 * @- @Repository (inherited from JpaRepository)
 * @Comments:
 * @- This interface allows for easy data access and manipulation of Product records.
 * @Explanations:
 * This is to facilitate database operations related to Product entities.
 * @Methods:
 * @- Inherited methods from JpaRepository such as save, findById, findAll, deleteById, etc.
 * @author Allynn Alvarico
 * @CreatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 23/12/2025
 * @By: Allynn Alvarico
 * @UpdatedOn
 * @Date: 31/12/2025
 * @By: Anson Ling Guang Cheng
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // get a limit number of products
    @Query("FROM Product product LIMIT 6")
    public List<Product> limitProducts();


    // method for update the product images
    @Modifying
    @Transactional
    @Query(value = "UPDATE Product SET product_image = :product_image WHERE product_id = :id")
    public void addProductImageById(
            @Param("id") int id,
            @Param("product_image") String product_image
    );

}
