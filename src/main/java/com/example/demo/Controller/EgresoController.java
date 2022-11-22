package com.example.demo.Controller;

import com.example.demo.Entity.Egresos;
import com.example.demo.Entity.Ingresos;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repository.IEgresoRepository;
import com.example.demo.Service.Impl.EgresoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/egreso")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class EgresoController {

    @Autowired
    private IEgresoRepository egresoRepository;

    @Autowired
    private EgresoServiceImpl egresoServiceImpl;

    @GetMapping("/")
    public Optional<List<Egresos>> getAll() {
        return Optional.of(egresoRepository.findAll());
    }

    @GetMapping("/{idEgreso}")
    public Optional<List<Egresos>> getAll(@PathVariable(value = "idEgreso") Long idEgreso) {
        return egresoRepository.findAllByIdEgreso(idEgreso);
    }

    @GetMapping("/searchByPresupuesto/{idEgreso}")
    public Optional<List<Egresos>> getAllByPresupuesto(@PathVariable(value = "idEgreso") Long idEgreso) {
        return egresoRepository.findByPresupuestoIdPresupuesto(idEgreso);
    }

    @PatchMapping("/{idEgreso}")
    public HttpStatus updateEgresoAny(@PathVariable(value = "idEgreso") Long idEgreso, @Valid @RequestBody Map<Object, Object> objectMap){
        egresoServiceImpl.updateEgresoWithMap(idEgreso, objectMap);
        return HttpStatus.ACCEPTED;
    }

    @PostMapping("/")
    public HttpStatus createEgreso(@Valid @RequestBody Egresos egreso){
        egresoRepository.save(egreso);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("/{idEgreso}")
    public HttpStatus updateEgreso(@PathVariable(value = "idEgreso") Long idEgreso,
                                        @Valid @RequestBody Egresos egresoDetails){

        Egresos egreso = egresoRepository.findById(idEgreso).orElseThrow(() -> new ResourceNotFoundException("Egresos", "idEgreso", idEgreso));

        egreso.setIdEgreso(egresoDetails.getIdEgreso());
        egreso.setDescripcion(egresoDetails.getDescripcion());
        egreso.setValor(egresoDetails.getValor());
        egreso.setPresupuesto(egresoDetails.getPresupuesto());

        egresoRepository.save(egreso);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{idEgreso}")
    public HttpStatus deleteEgreso(@PathVariable(value = "idEgreso") Long idEgreso){
        Egresos egreso = egresoRepository.findById(idEgreso).orElseThrow(() -> new ResourceNotFoundException("Egresos", "idEgreso", idEgreso));

        egresoRepository.delete(egreso);
        return HttpStatus.ACCEPTED;
    }

}
