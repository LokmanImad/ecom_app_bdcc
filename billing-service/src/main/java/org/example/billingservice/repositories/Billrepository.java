package org.example.billingservice.repositories;

import org.example.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
;

public interface Billrepository extends JpaRepository<Bill, Long> {
}
