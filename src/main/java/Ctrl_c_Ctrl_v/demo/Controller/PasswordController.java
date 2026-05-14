package Ctrl_c_Ctrl_v.demo.Controller;

import Ctrl_c_Ctrl_v.demo.Model.Password;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    private List<Password> listaPassword = new ArrayList<>();


    public PasswordController() {

        listaPassword.add(new Password(
                1,
                "Administrador Principal",
                "Cuenta principal",
                "admin123",
                "Admin",
                "Sistemas",
                "2026-05-14",
                "ariel"
        ));

        listaPassword.add(new Password(
                2,
                "Usuario RRHH",
                "Recursos Humanos",
                "rrhh456",
                "Usuario",
                "RRHH",
                "2026-05-13",
                "maria"
        ));

        listaPassword.add(new Password(
                3,
                "Supervisor Ventas",
                "Ventas generales",
                "ventas789",
                "Supervisor",
                "Ventas",
                "2026-05-12",
                "carlos"
        ));
    }


    @GetMapping
    public List<Password> obtenerPasswords() {

        return listaPassword;
    }


    @GetMapping("/{id}")
    public Password obtenerPorId(@PathVariable int id) {

        for (Password p : listaPassword) {

            if (p.getId() == id) {

                return p;
            }
        }

        return null;
    }


    @PostMapping
    public Password agregarPassword(@RequestBody Password password) {

        listaPassword.add(password);

        return password;
    }


    @PutMapping("/{id}")
    public Password actualizarPassword(@PathVariable int id,
    @RequestBody Password nuevo) {

        for (Password p : listaPassword) {

            if (p.getId() == id) {

                p.setCompleto(nuevo.getCompleto());
                p.setDes(nuevo.getDes());
                p.setPsw(nuevo.getPsw());
                p.setTipo(nuevo.getTipo());
                p.setGrupo(nuevo.getGrupo());
                p.setFeult(nuevo.getFeult());
                p.setUsuar(nuevo.getUsuar());

                return p;
            }
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public String eliminarPassword(@PathVariable int id) {

        for (Password p : listaPassword) {

            if (p.getId() == id) {

                listaPassword.remove(p);

                return "Registro eliminado";
            }
        }

        return "No encontrado";
    }
}