package Ctrl_c_Ctrl_v.demo.controller;

import Ctrl_c_Ctrl_v.demo.model.OrganismoFin;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/organismo-fin")
public class OrganismoFinController {

    // Base de datos en memoria
    private List<OrganismoFin> lista = new ArrayList<>();

    // GET - listar todos
    @GetMapping
    public List<OrganismoFin> listar() {
        return lista;
    }

    // POST - guardar nuevo registro
    @PostMapping
    public OrganismoFin guardar(@RequestBody OrganismoFin o) {
        lista.add(o);
        return o;
    }

    // PUT - actualizar por índice
    @PutMapping("/{index}")
    public OrganismoFin actualizar(@PathVariable int index,
                                   @RequestBody OrganismoFin o) {

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
