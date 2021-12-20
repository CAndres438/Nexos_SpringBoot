package com.auto_inventory_1.repositories;

import com.auto_inventory_1.models.Employments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentsRepository extends JpaRepository<Employments, String> {
}
