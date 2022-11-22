package com.example.demo.Service.Impl;

import com.example.demo.Entity.Egresos;
import com.example.demo.Repository.IEgresoRepository;
import com.example.demo.Service.IEgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EgresoServiceImpl implements IEgresoService {

    @Autowired
    private IEgresoRepository egresoRepository;

    @Override
    public Optional<List<Egresos>> getAll(Long id) {
        return egresoRepository.findAllByIdEgreso(id);
    }

    @Override
    public void updateEgresoWithMap(Long id, Map<Object, Object> objectMap) {
        Egresos egreso = egresoRepository.findByIdEgreso(id);
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Egresos.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, egreso, value);
        });
        egresoRepository.save(egreso);
    }

    @Override
    public Optional<List<Egresos>> getAllByPresupuesto(Long id) {
        return egresoRepository.findByPresupuestoIdPresupuesto(id);
    }

}
