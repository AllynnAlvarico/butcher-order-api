package com.zpulse.orderapi.repository;

import com.zpulse.orderapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
