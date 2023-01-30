package com.example.checkout;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table(name = "CHECKOUT_TABLE")
@Entity
public class CheckOutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
