package com.example.demo.Service;

import com.example.demo.Entity.Presupuesto;

import java.util.List;
import java.util.Optional;

public interface IPresupuestoService {

    Optional<List<Presupuesto>> getAll(Long id);
}
