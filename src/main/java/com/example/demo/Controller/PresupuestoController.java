package com.example.demo.Controller;

import com.example.demo.Entity.Presupuesto;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repository.IPresupuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/presupuesto")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class PresupuestoController {

    @Autowired
    private IPresupuestoRepository presupuestoRepository;

    @GetMapping("/")
    public List<Presupuesto> getAll(){
        return presupuestoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<List<Presupuesto>> getAll(@PathVariable(value = "idPresupuesto") Long idPresupuesto){
        return presupuestoRepository.findAllByIdPresupuesto(idPresupuesto);
    }

    @PostMapping("/")
    public HttpStatus createPresupuesto(@Valid @RequestBody Presupuesto presupuesto){
        presupuestoRepository.save(presupuesto);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("/{id}")
    public HttpStatus updatePresupuesto(@PathVariable(value = "idPresupuesto") Long idPresupuesto,
                                        @Valid @RequestBody Presupuesto presupuestoDetails){

        Presupuesto presupuesto = presupuestoRepository.findById(idPresupuesto).orElseThrow(() -> new ResourceNotFoundException("Presupuesto", "idPresupuesto", idPresupuesto));

        presupuesto.setIdPresupuesto(presupuestoDetails.getIdPresupuesto());
        presupuesto.setValor(presupuestoDetails.getValor());

        presupuestoRepository.save(presupuesto);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteFacilitador(@PathVariable(value = "idPresupuesto") Long idPresupuesto){
        Presupuesto presupuesto = presupuestoRepository.findById(idPresupuesto).orElseThrow(() -> new ResourceNotFoundException("Presupuesto", "idPresupuesto", idPresupuesto));

        presupuestoRepository.delete(presupuesto);
        return HttpStatus.ACCEPTED;
    }

}
