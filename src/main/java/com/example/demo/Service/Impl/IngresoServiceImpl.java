package com.example.demo.Service.Impl;

import com.example.demo.Entity.Ingresos;
import com.example.demo.Repository.IIngresoRepository;
import com.example.demo.Service.IIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class IngresoServiceImpl implements IIngresoService {

    @Autowired
    private IIngresoRepository ingresoRepository;

    @Override
    public Optional<List<Ingresos>> getAll(Long id) {
        return ingresoRepository.findAllByIdIngreso(id);
    }

    @Override
    public Optional<List<Ingresos>> getByPresupuesto(Long id) {
        return ingresoRepository.findByPresupuestoIdPresupuesto(id);
    }

    @Override
    public void updateIngresoWithMap(Long id, Map<Object, Object> objectMap) {
        Ingresos ingreso = ingresoRepository.findByIdIngreso(id);
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Ingresos.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, ingreso, value);
        });
        ingresoRepository.save(ingreso);
    }
}
