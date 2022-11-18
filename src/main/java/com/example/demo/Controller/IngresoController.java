package com.example.demo.Controller;

import com.example.demo.Entity.Ingresos;
import com.example.demo.Entity.Presupuesto;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repository.IIngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingreso")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
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

    @GetMapping("/searchByPresupuesto/{id}")
    public Optional<List<Ingresos>> getAllByPresupuesto(@PathVariable(value = "id") Long id) {
        return ingresoRepository.findByPresupuestoId(id);
    }

    @PostMapping("/")
    public HttpStatus createIngreso(@Valid @RequestBody Ingresos ingreso){
        ingresoRepository.save(ingreso);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("/{id}")
    public HttpStatus updatePresupuesto(@PathVariable(value = "id") Long id,
                                        @Valid @RequestBody Ingresos ingresoDetails){

        Ingresos ingreso = ingresoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ingresos", "id", id));

        ingreso.setId(ingresoDetails.getId());
        ingreso.setValor(ingresoDetails.getValor());
        ingreso.setPresupuesto(ingresoDetails.getPresupuesto());
        ingreso.setDescripcion(ingresoDetails.getDescripcion());

        ingresoRepository.save(ingreso);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteIngreso(@PathVariable(value = "id") Long id){
        Ingresos ingreso = ingresoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ingresos", "id", id));

        ingresoRepository.delete(ingreso);
        return HttpStatus.ACCEPTED;
    }


}
