package Ctrl_c_Ctrl_v.demo.service;

import Ctrl_c_Ctrl_v.demo.entity.OficinaEntity;
import Ctrl_c_Ctrl_v.demo.repository.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OficinaService {

    @Autowired
    private OficinaRepository oficinaRepository;

    public List<OficinaEntity> getAllOficina() {
        return oficinaRepository.findAll();
    }

    public Optional<OficinaEntity> getOficinaById(String id) {
        return oficinaRepository.findById(id);
    }

    public OficinaEntity saveOficina(OficinaEntity oficinaEntity) {
        return oficinaRepository.save(oficinaEntity);
    }

    public OficinaEntity updateOficina(String id, OficinaEntity oficinaEntity) {
        return oficinaRepository.findById(id)
                .map(existingOficina -> {
                    existingOficina.setUnidad(oficinaEntity.getUnidad());
                    existingOficina.setCodofic(oficinaEntity.getCodofic());
                    existingOficina.setNomofic(oficinaEntity.getNomofic());
                    existingOficina.setObserv(oficinaEntity.getObserv());
                    existingOficina.setFeult(oficinaEntity.getFeult());
                    existingOficina.setUsuar(oficinaEntity.getUsuar());
                    existingOficina.setApi_estado(oficinaEntity.getApi_estado());
                    return oficinaRepository.save(existingOficina);
                }).orElseThrow(() -> new RuntimeException("Oficina no encontrada con ID: " + id));
    }

    public void deleteOficina(String id) {
        oficinaRepository.deleteById(id);
    }
}