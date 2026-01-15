package com.hanifomar.procurement_app.supplier.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "suppliers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String contactEmail;

    @Column
    private String phone;

    @Column
    private String address;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
