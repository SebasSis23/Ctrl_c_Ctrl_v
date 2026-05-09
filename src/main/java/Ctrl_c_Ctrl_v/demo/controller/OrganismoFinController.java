package Ctrl_c_Ctrl_v.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/organismo-fin")
public class OrganismoFinController {

    // “Base de datos en memoria”
    private List<OrganismoFinController> lista = new ArrayList<>();

    // GET - listar todo
    @GetMapping
    public List<OrganismoFinController> listar() {
        return lista;
    }

    // POST - crear nuevo registro
    @PostMapping
    public OrganismoFinController guardar(@RequestBody OrganismoFinController o) {
        lista.add(o);
        return o;
    }

    // PUT - actualizar por índice
    @PutMapping("/{index}")
    public OrganismoFinController actualizar(@PathVariable int index, @RequestBody OrganismoFinController o) {
        if (index >= 0 && index < lista.size()) {
            lista.set(index, o);
            return o;
        }
        return null;
    }

    // DELETE - eliminar por índice
    @DeleteMapping("/{index}")
    public String eliminar(@PathVariable int index) {
        if (index >= 0 && index < lista.size()) {
            lista.remove(index);
            return "Eliminado correctamente";
        }
        return "Índice no válido";
    }
}
