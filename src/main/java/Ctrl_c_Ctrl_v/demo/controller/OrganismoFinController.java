package Ctrl_c_Ctrl_v.demo.controller;
//corregido
import Ctrl_c_Ctrl_v.demo.entity.OrganismoFin;
import Ctrl_c_Ctrl_v.demo.service.OrganismoFinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organismo-fin")
@CrossOrigin("*")
public class OrganismoFinController {

    @Autowired
    private OrganismoFinService service;

    // GET TODOS
    @GetMapping
    public List<OrganismoFin> listar() {
        return service.listar();
    }

    // GET POR ID
    @GetMapping("/{of}")
    public Optional<OrganismoFin> buscarPorId(@PathVariable String of) {
        return service.buscarPorId(of);
    }

    // POST
    @PostMapping
    public OrganismoFin guardar(@RequestBody OrganismoFin organismoFin) {
        return service.guardar(organismoFin);
    }

    // PUT
    @PutMapping("/{of}")
    public OrganismoFin actualizar(@PathVariable String of,
                                   @RequestBody OrganismoFin organismoFin) {

        organismoFin.setOf(of);
        return service.guardar(organismoFin);
    }

    // DELETE
    @DeleteMapping("/{of}")
    public void eliminar(@PathVariable String of) {
        service.eliminar(of);
    }
}
