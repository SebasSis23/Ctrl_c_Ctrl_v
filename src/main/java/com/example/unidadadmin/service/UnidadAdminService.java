
package com.example.unidadadmin.service;

import com.example.unidadadmin.entity.UnidadAdminEntity;
import com.example.unidadadmin.repository.UnidadAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadAdminService {

    private final UnidadAdminRepository repository;

    public UnidadAdminService(UnidadAdminRepository repository) {
        this.repository = repository;
    }

    public List<UnidadAdminEntity> listar() {
        return repository.findAll();
    }

    public UnidadAdminEntity guardar(UnidadAdminEntity unidad) {
        return repository.save(unidad);
    }
}