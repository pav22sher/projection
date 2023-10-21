package com.example.projection.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "man")
public class Man {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="id_seq")
    @SequenceGenerator(name="id_seq", sequenceName="man_seq_gen", allocationSize=1)
    Long id;
    String firstName;
    String lastName;
    @OneToOne(cascade = CascadeType.PERSIST)
    Address address;
}
