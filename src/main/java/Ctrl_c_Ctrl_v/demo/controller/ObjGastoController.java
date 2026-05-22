package Ctrl_c_Ctrl_v.demo.controller;
//corregido
import Ctrl_c_Ctrl_v.demo.entity.ObjGastoEntity;
import Ctrl_c_Ctrl_v.demo.service.ObjGastoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objgasto")
@CrossOrigin(origins = "*")
@Tag(name = "ObjGasto")
public class ObjGastoController {

    private final ObjGastoService service;

    public ObjGastoController(ObjGastoService service) {
        this.service = service;
    }

    @Operation(
            summary = "Mostrar objetos de gasto",
            description = "Devuelve todos los registros guardados"
    )
    @GetMapping
    public List<ObjGastoEntity> listarObjGasto() {
        return service.listar();
    }

    @Operation(
            summary = "Buscar por partida",
            description = "Obtiene un objeto de gasto usando la partida"
    )
    @GetMapping("/{partida}")
    public ObjGastoEntity buscarObjGasto(@PathVariable String partida) {
        return service.buscar(partida);
    }

    @Operation(
            summary = "Guardar objeto de gasto",
            description = "Registra un nuevo objeto de gasto"
    )
    @PostMapping
    public ObjGastoEntity guardarObjGasto(@RequestBody ObjGastoEntity objGasto) {
        return service.guardar(objGasto);
    }

    @Operation(
            summary = "Editar objeto de gasto",
            description = "Actualiza los datos de un registro existente"
    )
    @PutMapping("/{partida}")
    public ObjGastoEntity editarObjGasto(
            @PathVariable String partida,
            @RequestBody ObjGastoEntity objGasto
    ) {
        return service.actualizar(partida, objGasto);
    }

    @Operation(
            summary = "Eliminar objeto de gasto",
            description = "Elimina un registro según la partida"
    )
    @DeleteMapping("/{partida}")
    public String eliminarObjGasto(@PathVariable String partida) {
        service.eliminar(partida);
        return "Registro eliminado";
    }
}
