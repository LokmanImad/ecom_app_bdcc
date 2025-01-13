package org.example.customerservice.repository;

import org.example.customerservice.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
}
