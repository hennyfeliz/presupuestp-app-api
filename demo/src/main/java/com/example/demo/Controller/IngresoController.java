package com.example.demo.Controller;

import com.example.demo.Entity.Ingresos;
import com.example.demo.Repository.IIngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {

    @Autowired
    private IIngresoRepository ingresoRepository;

    @GetMapping("/")
    public Optional<List<Ingresos>> getAll() {
        return Optional.of(ingresoRepository.findAll());
    }

    @GetMapping("/{id}")
    public Optional<List<Ingresos>> getAll(@PathVariable(value = "id") Long id) {
        return ingresoRepository.findAllById(id);
    }


}
