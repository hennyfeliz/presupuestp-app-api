package com.example.demo.Controller;

import com.example.demo.Entity.Egresos;
import com.example.demo.Repository.IEgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/egreso")
public class EgresoController {

    @Autowired
    private IEgresoRepository egresoRepository;

    @GetMapping("/")
    public Optional<List<Egresos>> getAll() {
        return Optional.of(egresoRepository.findAll());
    }

    @GetMapping("/{id}")
    public Optional<List<Egresos>> getAll(@PathVariable(value = "id") Long id) {
        return egresoRepository.findAllById(id);
    }

}
