package com.example.unidadadmin.controller;

import com.example.unidadadmin.entity.UnidadAdminEntity;
import com.example.unidadadmin.service.UnidadAdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidadadmin")
public class UnidadAdminController {

    private final UnidadAdminService service;

    public UnidadAdminController(UnidadAdminService service) {
        this.service = service;
    }

    @GetMapping
    public List<UnidadAdminEntity> listar() {
        return service.listar();
    }

    @PostMapping
    public UnidadAdminEntity guardar(@RequestBody UnidadAdminEntity unidad) {
        return service.guardar(unidad);
    }
}