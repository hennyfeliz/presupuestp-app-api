package com.example.demo.Service;

import com.example.demo.Entity.Ingresos;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IIngresoService {

    Optional<List<Ingresos>> getAll(Long id);

    Optional<List<Ingresos>> getByPresupuesto(Long id);

    void updateIngresoWithMap(Long id, Map<Object, Object> objectMap);
}
