package Ctrl_c_Ctrl_v.demo.controller;

import Ctrl_c_Ctrl_v.demo.Entity.UnidadAdminEntity;
import Ctrl_c_Ctrl_v.demo.service.UnidadAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidadadmin")
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
}