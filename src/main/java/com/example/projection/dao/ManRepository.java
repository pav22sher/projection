package com.example.projection.dao;

import com.example.projection.model.Man;
import com.example.projection.projection.ManDTO;
import com.example.projection.projection.ManProjection;
import com.example.projection.projection.ManView;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManRepository extends JpaRepository<Man, Long> {
    @Query("SELECT m.id, m.lastName FROM man m")
    List<Object[]> getIdAndLastname1();

    @Query("SELECT m.id as id, m.lastName as lastname FROM man m")
    List<Tuple> getIdAndLastname2();

    @Query("SELECT new com.example.projection.projection.ManDTO(m.id, m.lastName) FROM man m")
    List<ManDTO> getIdAndLastname3();

    List<ManDTO> findAllByFirstName(String firstName);

    List<ManView> findAllByLastName(String lastName);

    <T> List<T> findAllByFirstName(String firstName, Class<T> type);
}
