package Ctrl_c_Ctrl_v.demo.controller;

import Ctrl_c_Ctrl_v.demo.entity.UnidadAdminEntity;
import Ctrl_c_Ctrl_v.demo.service.UnidadAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidadadmin")
@CrossOrigin(origins = "*")
public class UnidadAdminController {

    @Autowired
    private UnidadAdminService service;

    @GetMapping
    public List<UnidadAdminEntity> listar() {
        return service.listar();
    }

    @PostMapping
    public UnidadAdminEntity guardar(
            @RequestBody UnidadAdminEntity unidad) {

        return service.guardar(unidad);
    }
    @PutMapping("/{id}")
    public UnidadAdminEntity actualizar(
            @PathVariable String id,
            @RequestBody UnidadAdminEntity unidad) {

        return service.actualizar(id, unidad);
    }
    @DeleteMapping("/{id}")
    public void eliminar(
            @PathVariable String id) {

        service.eliminar(id);
    }
    @GetMapping("/{id}")
    public UnidadAdminEntity buscarPorId(
            @PathVariable String id) {

        return service.buscarPorId(id);
    }
}