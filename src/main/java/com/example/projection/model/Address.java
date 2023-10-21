package com.example.projection.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String state;
    String city;
    String street;
    String zipCode;
    @OneToOne(mappedBy = "address")
    Man man;
}