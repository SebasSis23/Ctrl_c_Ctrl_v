package Ctrl_c_Ctrl_v.demo.Controller;

import Ctrl_c_Ctrl_v.demo.Entity.PasswordEntity;
import Ctrl_c_Ctrl_v.demo.service.PasswordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/password")
@CrossOrigin(origins = "*")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;


    @GetMapping
    public List<PasswordEntity> obtenerPasswords() {

        return passwordService.obtenerTodos();
    }


    @GetMapping("/{id}")
    public PasswordEntity obtenerPorId(@PathVariable int id) {

        return passwordService.obtenerPorId(id);
    }


    @PostMapping
    public PasswordEntity agregarPassword(
            @RequestBody PasswordEntity password) {

        return passwordService.guardar(password);
    }


    @PutMapping("/{id}")
    public PasswordEntity actualizarPassword(
            @PathVariable int id,
            @RequestBody PasswordEntity nuevo) {

        return passwordService.actualizar(id, nuevo);
    }


    @DeleteMapping("/{id}")
    public String eliminarPassword(@PathVariable int id) {

        return passwordService.eliminar(id);
    }
}