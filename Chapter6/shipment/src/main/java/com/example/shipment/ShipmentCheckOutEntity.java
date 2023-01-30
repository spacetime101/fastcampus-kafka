package com.example.shipment;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table(name = "SHIPMENT_CHECKOUT_TABLE")
@Entity
public class ShipmentCheckOutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shipmentId;

    @Column(name = "checkOutId")
    private Long checkOutId;

    @Column(name = "memberId")
    private Long memberId;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "shippingAddress")
    private String shippingAddress;

    @CreationTimestamp
    @Column(name = "createdAt")
    private Timestamp createdAt;
}
