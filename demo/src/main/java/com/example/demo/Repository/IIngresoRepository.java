package com.example.demo.Repository;

import com.example.demo.Entity.Ingresos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IIngresoRepository extends JpaRepository<Ingresos, Long> {

    Optional<List<Ingresos>> findAllById(Long id);

}
