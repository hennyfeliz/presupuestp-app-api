package com.example.demo.Controller;

import com.example.demo.Entity.Egresos;
import com.example.demo.Entity.Ingresos;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repository.IEgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/")
    public HttpStatus createEgreso(@Valid @RequestBody Egresos egreso){
        egresoRepository.save(egreso);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("/{id}")
    public HttpStatus updateEgreso(@PathVariable(value = "id") Long id,
                                        @Valid @RequestBody Egresos egresoDetails){

        Egresos egreso = egresoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Egresos", "id", id));

        egreso.setId(egresoDetails.getId());
        egreso.setDescripcion(egresoDetails.getDescripcion());
        egreso.setValor(egresoDetails.getValor());
        egreso.setPresupuesto(egresoDetails.getPresupuesto());

        egresoRepository.save(egreso);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEgreso(@PathVariable(value = "id") Long id){
        Egresos egreso = egresoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Egresos", "id", id));

        egresoRepository.delete(egreso);
        return HttpStatus.ACCEPTED;
    }

}
