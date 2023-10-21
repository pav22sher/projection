package com.example.projection.dao;

import com.example.projection.model.Address;
import com.example.projection.model.Man;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
