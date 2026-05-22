package Ctrl_c_Ctrl_v.demo.service;

import Ctrl_c_Ctrl_v.demo.entity.PasswordEntity;
import Ctrl_c_Ctrl_v.demo.repository.PasswordRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository repository;

    // LISTAR
    public List<PasswordEntity> obtenerTodos() {

        return repository.findAll();
    }

    // BUSCAR POR ID
    public PasswordEntity obtenerPorId(int id) {

        Optional<PasswordEntity> dato = repository.findById(id);

        return dato.orElse(null);
    }

    // GUARDAR
    public PasswordEntity guardar(PasswordEntity password) {

        return repository.save(password);
    }

    // ACTUALIZAR
    public PasswordEntity actualizar(int id, PasswordEntity nuevo) {

        PasswordEntity existente = obtenerPorId(id);

        if (existente != null) {

            existente.setCompleto(nuevo.getCompleto());
            existente.setDes(nuevo.getDes());
            existente.setPsw(nuevo.getPsw());
            existente.setTipo(nuevo.getTipo());
            existente.setGrupo(nuevo.getGrupo());
            existente.setFeult(nuevo.getFeult());
            existente.setUsuar(nuevo.getUsuar());

            return repository.save(existente);
        }

        return null;
    }

    // ELIMINAR
    public String eliminar(int id) {

        PasswordEntity existente = obtenerPorId(id);

        if (existente != null) {

            repository.deleteById(id);

            return "Registro eliminado";
        }

        return "No encontrado";
    }
}