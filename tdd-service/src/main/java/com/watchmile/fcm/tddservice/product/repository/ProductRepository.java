package com.watchmile.fcm.tddservice.product.repository;

import com.watchmile.fcm.tddservice.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
