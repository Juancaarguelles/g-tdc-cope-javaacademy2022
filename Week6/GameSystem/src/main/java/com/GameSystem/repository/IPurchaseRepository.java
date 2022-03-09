package com.GameSystem.repository;

import com.GameSystem.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPurchaseRepository extends JpaRepository<Purchase, Integer> {
}
