package Ctrl_c_Ctrl_v.demo.controller;

import Ctrl_c_Ctrl_v.demo.dto.UnidadAdminDTO;
import Ctrl_c_Ctrl_v.demo.service.UnidadAdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidadadmin")
public class UnidadAdminController {

    private final UnidadAdminService service;

    public UnidadAdminController(UnidadAdminService service) {
        this.service = service;
    }

    @GetMapping
    public List<UnidadAdminDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UnidadAdminDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public UnidadAdminDTO add(@RequestBody UnidadAdminDTO unidad) {
        return service.add(unidad);
    }

    @PutMapping("/{id}")
    public UnidadAdminDTO update(@PathVariable Long id,
                                 @RequestBody UnidadAdminDTO unidad) {
        return service.update(id, unidad);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        boolean eliminado = service.delete(id);

        if (eliminado) {
            return "Unidad eliminada";
        }

        return "Unidad no encontrada";
    }
}