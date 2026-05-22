package Ctrl_c_Ctrl_v.demo.controller;
//corregido
import Ctrl_c_Ctrl_v.demo.entity.OficinaEntity;
import Ctrl_c_Ctrl_v.demo.service.OficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/oficina")
@CrossOrigin(origins = "*")
public class OficinaController {

    @Autowired
    private OficinaService oficinaService;

    @GetMapping
    public List<OficinaEntity> getOficina() {
        return oficinaService.getAllOficina();
    }

    @PostMapping
    public OficinaEntity createOficina(@RequestBody OficinaEntity oficinaEntity) {
        return oficinaService.saveOficina(oficinaEntity);
    }

    @GetMapping("/{entidad}")
    public Optional<OficinaEntity> getOficinaById(@PathVariable String entidad) {
        return oficinaService.getOficinaById(entidad);
    }

    @DeleteMapping("/{entidad}")
    public void deleteOficina(@PathVariable String entidad) {
        oficinaService.deleteOficina(entidad);
}
}