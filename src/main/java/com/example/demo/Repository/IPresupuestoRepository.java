package com.example.demo.Repository;

import com.example.demo.Entity.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPresupuestoRepository extends JpaRepository<Presupuesto, Long> {

    Optional<List<Presupuesto>> findAllByIdPresupuesto(Long idPresupuesto);

    Presupuesto findByIdPresupuesto(Long id);

}
