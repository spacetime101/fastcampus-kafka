package com.example.shipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentCheckOutRepository extends JpaRepository<ShipmentCheckOutEntity, Long> {
}
