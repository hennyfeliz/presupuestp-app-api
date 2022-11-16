package com.example.demo.Service.Impl;

import com.example.demo.Entity.Presupuesto;
import com.example.demo.Repository.IPresupuestoRepository;
import com.example.demo.Service.IPresupuestoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PresupuestoServiceImpl implements IPresupuestoService {

    @Autowired
    private IPresupuestoRepository presupuestoRepository;


    @Override
    public Optional<List<Presupuesto>> getAll(Long id) {
        return presupuestoRepository.findAllById(id);
    }
}
