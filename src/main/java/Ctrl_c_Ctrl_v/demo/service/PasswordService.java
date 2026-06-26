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
    private PasswordRepository passwordRepository;

    public List<PasswordEntity> obtenerTodos() {
        return passwordRepository.findAll();
    }

    public Optional<PasswordEntity> obtenerPorId(int id) {
        return passwordRepository.findById(id);
    }

    public PasswordEntity guardar(PasswordEntity password) {
        return passwordRepository.save(password);
    }

    public PasswordEntity actualizar(int id, PasswordEntity nuevo) {
        return passwordRepository.findById(id).map(p -> {
            p.setCompleto(nuevo.getCompleto());
            p.setDes(nuevo.getDes());
            p.setPsw(nuevo.getPsw());
            p.setTipo(nuevo.getTipo());
            p.setGrupo(nuevo.getGrupo());
            p.setFeult(nuevo.getFeult());
            p.setUsuar(nuevo.getUsuar());
            return passwordRepository.save(p);
        }).orElse(null);
    }

    public boolean eliminar(int id) {
        if (passwordRepository.existsById(id)) {
            passwordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}