package com.example.as4.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "guitars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guitar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String guitarName;

    @Column(nullable = false)
    private String guitarBrand;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private double price;
}
