package com.example.demo.Service.Impl;

import com.example.demo.Entity.Presupuesto;
import com.example.demo.Repository.IPresupuestoRepository;
import com.example.demo.Service.IPresupuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PresupuestoServiceImpl implements IPresupuestoService {

    @Autowired
    private IPresupuestoRepository presupuestoRepository;


    @Override
    public Optional<List<Presupuesto>> getAll(Long idPresupuesto) {
        return presupuestoRepository.findAllByIdPresupuesto(idPresupuesto);
    }

    @Override
    public Presupuesto getPresupuesto(Long idPresupuesto) {
        return presupuestoRepository.findByIdPresupuesto(idPresupuesto);
    }

    @Override
    public void updatePresupuestoWithMap(Long id, Map<Object, Object> objectMap) {
        Presupuesto presupuesto = presupuestoRepository.findByIdPresupuesto(id);
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Presupuesto.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, presupuesto, value);
        });
        presupuestoRepository.save(presupuesto);
    }
}
