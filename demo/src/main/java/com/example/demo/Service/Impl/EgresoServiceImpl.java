package com.example.demo.Service.Impl;

import com.example.demo.Entity.Egresos;
import com.example.demo.Repository.IEgresoRepository;
import com.example.demo.Service.IEgresoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class EgresoServiceImpl implements IEgresoService {

    @Autowired
    private IEgresoRepository egresoRepository;

    @Override
    public Optional<List<Egresos>> getAll(Long id) {
        return egresoRepository.findAllById(id);
    }

}
