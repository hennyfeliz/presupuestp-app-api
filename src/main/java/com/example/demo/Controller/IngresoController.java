package com.example.demo.Controller;

import com.example.demo.Entity.Ingresos;
import com.example.demo.Entity.Presupuesto;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repository.IIngresoRepository;
import com.example.demo.Service.Impl.IngresoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ingreso")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class IngresoController {

    @Autowired
    private IIngresoRepository ingresoRepository;

    @Autowired
    private IngresoServiceImpl ingresoServiceImpl;

    @GetMapping("/")
    public Optional<List<Ingresos>> getAll() {
        return Optional.of(ingresoRepository.findAll());
    }

    @GetMapping("/{id}")
    public Optional<List<Ingresos>> getAll(@PathVariable(value = "id") Long id) {
        return ingresoRepository.findAllByIdIngreso(id);
    }

    @GetMapping("/searchByPresupuesto/{id}")
    public Optional<List<Ingresos>> getAllByPresupuesto(@PathVariable(value = "id") Long id) {
        return ingresoRepository.findByPresupuestoIdPresupuesto(id);
    }

    @PostMapping("/")
    public HttpStatus createIngreso(@Valid @RequestBody Ingresos ingreso){
        ingresoRepository.save(ingreso);
        return HttpStatus.ACCEPTED;
    }

    @PatchMapping("/updateIngreso/{idIngreso}")
    public HttpStatus updateCursoAny(@PathVariable(value = "idIngreso") Long idIngreso, @Valid @RequestBody Map<Object, Object> objectMap){
        ingresoServiceImpl.updateIngresoWithMap(idIngreso, objectMap);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("/{id}")
    public HttpStatus updatePresupuesto(@PathVariable(value = "id") Long id,
                                        @Valid @RequestBody Ingresos ingresoDetails){

        Ingresos ingreso = ingresoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ingresos", "id", id));

        ingreso.setIdIngreso(ingresoDetails.getIdIngreso());
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
