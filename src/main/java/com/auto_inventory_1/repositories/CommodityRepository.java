package com.auto_inventory_1.repositories;

import com.auto_inventory_1.models.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommodityRepository extends JpaRepository <Commodity, Long> {
    Optional<Commodity> findByProductName (String productName);
    List<Commodity> findByUserNexos (String userNexos);
}
