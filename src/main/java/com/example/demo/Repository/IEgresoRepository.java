package com.example.demo.Repository;

import com.example.demo.Entity.Egresos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEgresoRepository extends JpaRepository<Egresos, Long> {

    Optional<List<Egresos>> findAllById(Long id);

    Optional<List<Egresos>> findByPresupuestoId(Long id);

}
