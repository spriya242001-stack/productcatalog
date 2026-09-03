package com.example.productcatalog.repository;

import com.example.productcatalog.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // This satisfies the assignment requirement to fetch items by category
    List<ProductEntity> findByCategory(String category);
}