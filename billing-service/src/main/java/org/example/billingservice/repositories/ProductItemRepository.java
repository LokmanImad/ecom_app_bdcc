package org.example.billingservice.repositories;

import org.example.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem , Long> {
}
