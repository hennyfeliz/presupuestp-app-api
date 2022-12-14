package com.example.demo.Service;

import com.example.demo.Entity.Egresos;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IEgresoService {

    Optional<List<Egresos>> getAll(Long id);

    void updateEgresoWithMap(Long id, Map<Object, Object> objectMap);

    Optional<List<Egresos>> getAllByPresupuesto(Long id);
}
