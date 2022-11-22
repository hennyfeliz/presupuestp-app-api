package com.example.demo.Service;

import com.example.demo.Entity.Ingresos;
import com.example.demo.Entity.Presupuesto;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IPresupuestoService {

    Optional<List<Presupuesto>> getAll(Long id);

    Presupuesto getPresupuesto(Long id);

    void updatePresupuestoWithMap(Long id, Map<Object, Object> objectMap);
}
