package com.example.demo.Service.Impl;

import com.example.demo.Entity.Ingresos;
import com.example.demo.Repository.IIngresoRepository;
import com.example.demo.Service.IIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngresoServiceImpl implements IIngresoService {

    @Autowired
    private IIngresoRepository ingresoRepository;

    @Override
    public Optional<List<Ingresos>> getAll(Long id) {
        return ingresoRepository.findAllById(id);
    }

    @Override
    public Optional<List<Ingresos>> getByPresupuesto(Long id) {
        return ingresoRepository.findByPresupuestoId(id);
    }
}
