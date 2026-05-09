package Ctrl_c_Ctrl_v.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/oficinas")
public class OficinaController {

    private static List<Oficina> listaOficinas = new ArrayList<>();

    @GetMapping
    public List<Oficina> listar() {
        return listaOficinas;
    }

    @PostMapping
    public Oficina guardar(@RequestBody Oficina nuevaOficina) {
        listaOficinas.add(nuevaOficina);
        return nuevaOficina;
    }

    @PutMapping("/{index}")
    public Oficina actualizar(@PathVariable int index, @RequestBody Oficina oficinaEditada) {
        if (index >= 0 && index < listaOficinas.size()) {
            listaOficinas.set(index, oficinaEditada);
            return oficinaEditada;
        }
        return null;
    }

    @DeleteMapping("/{index}")
    public String eliminar(@PathVariable int index) {
        if (index >= 0 && index < listaOficinas.size()) {
            listaOficinas.remove(index);
            return "Oficina eliminada correctamente";
        }
        return "Error: Índice no encontrado";
    }
}