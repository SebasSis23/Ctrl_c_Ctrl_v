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

    public Optional<OficinaEntity> getOficinaById(String entidad) {
        return oficinaRepository.findById(entidad);
    }

    public OficinaEntity saveOficina(OficinaEntity oficinaEntity) {
        return oficinaRepository.save(oficinaEntity);
    }

    public void deleteOficina(String entidad) {
    oficinaRepository.deleteById(entidad);
    }
}