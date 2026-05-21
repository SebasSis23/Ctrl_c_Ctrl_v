package Ctrl_c_Ctrl_v.demo.service;

import Ctrl_c_Ctrl_v.demo.entity.UnidadAdminEntity;
import Ctrl_c_Ctrl_v.demo.repository.UnidadAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadAdminService {

    @Autowired
    private UnidadAdminRepository repository;

    public List<UnidadAdminEntity> listar() {
        return repository.findAll();
    }

    public UnidadAdminEntity guardar(UnidadAdminEntity unidad) {
        return repository.save(unidad);
    }
    public UnidadAdminEntity actualizar(
            String entidad,
            UnidadAdminEntity unidad) {

        unidad.setEntidad(entidad);

        return repository.save(unidad);
    }
    public void eliminar(String entidad) {
        repository.deleteById(entidad);
    }
}


