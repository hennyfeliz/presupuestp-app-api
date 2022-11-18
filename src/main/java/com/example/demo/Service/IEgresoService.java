package com.example.demo.Service;

import com.example.demo.Entity.Egresos;

import java.util.List;
import java.util.Optional;

public interface IEgresoService {

    Optional<List<Egresos>> getAll(Long id);
}
