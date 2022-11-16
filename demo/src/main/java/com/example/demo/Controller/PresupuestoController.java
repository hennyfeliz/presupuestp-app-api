package com.example.demo.Controller;

import com.example.demo.Entity.Presupuesto;
import com.example.demo.Repository.IPresupuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/presupuesto")
public class PresupuestoController {

    @Autowired
    private IPresupuestoRepository presupuestoRepository;

    @GetMapping("/")
    public List<Presupuesto> getAll(){
        return presupuestoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<List<Presupuesto>> getAll(@PathVariable(value = "id") Long id){
        return presupuestoRepository.findAllById(id);
    }

}
