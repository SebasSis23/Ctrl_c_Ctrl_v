package com.example.sprintbot.controller;

import com.example.sprintbot.entity.Orguser;
import com.example.sprintbot.service.OrguserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orguser")
@CrossOrigin("*")
public class OrguserController {

    private final OrguserService orguserService;

    public OrguserController(OrguserService orguserService) {
        this.orguserService = orguserService;
    }

    @GetMapping
    public List<Orguser> listar() {
        return orguserService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orguser> obtenerPorId(@PathVariable String id) {
        return orguserService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Orguser> guardar(@RequestBody Orguser orguser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orguserService.create(orguser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orguser> actualizar(@PathVariable String id, @RequestBody Orguser orguser) {
        return orguserService.update(id, orguser)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (!orguserService.deleteById(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
