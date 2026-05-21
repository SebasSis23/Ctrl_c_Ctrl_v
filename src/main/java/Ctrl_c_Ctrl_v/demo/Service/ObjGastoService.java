package Ctrl_c_Ctrl_v.demo.service;

import Ctrl_c_Ctrl_v.demo.repository.ObjGastoRepository;
import Ctrl_c_Ctrl_v.demo.entity.ObjGastoEntity;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjGastoService {

    private final ObjGastoRepository repository;

    public ObjGastoService(ObjGastoRepository repository) {
        this.repository = repository;
    }

    public List<ObjGastoEntity> listar() {
        return repository.findAll();
    }

    public ObjGastoEntity buscar(String partida) {
        return repository.findById(partida).orElse(null);
    }

    public ObjGastoEntity guardar(ObjGastoEntity objGasto) {
        return repository.save(objGasto);
    }

    public ObjGastoEntity actualizar(String partida, ObjGastoEntity objGastoActualizado) {
        ObjGastoEntity objGasto = repository.findById(partida).orElse(null);
        if (objGasto != null) {
            objGasto.setGestion(objGastoActualizado.getGestion());
            objGasto.setDescrip(objGastoActualizado.getDescrip());
            return repository.save(objGasto);
        }
        return null;
    }

    public void eliminar(String partida) {
        repository.deleteById(partida);
    }
}
