package com.example.sprintbot.service.impl;

import com.example.sprintbot.entity.Orguser;
import com.example.sprintbot.repository.OrguserRepository;
import com.example.sprintbot.service.OrguserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrguserServiceImpl implements OrguserService {

    private final OrguserRepository orguserRepository;

    public OrguserServiceImpl(OrguserRepository orguserRepository) {
        this.orguserRepository = orguserRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Orguser> findAll() {
        return orguserRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Orguser> findById(String id) {
        return orguserRepository.findById(id);
    }

    @Override
    public Orguser create(Orguser orguser) {
        return orguserRepository.save(orguser);
    }

    @Override
    public Optional<Orguser> update(String id, Orguser orguser) {
        return orguserRepository.findById(id)
                .map(existingOrguser -> {
                    existingOrguser.setTipo(orguser.getTipo());
                    existingOrguser.setNombre(orguser.getNombre());
                    existingOrguser.setSoloLectura(orguser.getSoloLectura());
                    existingOrguser.setCkval(orguser.getCkval());
                    existingOrguser.setDatos(orguser.getDatos());
                    existingOrguser.setFechaActualizacion(orguser.getFechaActualizacion());
                    return orguserRepository.save(existingOrguser);
                });
    }

    @Override
    public boolean deleteById(String id) {
        if (!orguserRepository.existsById(id)) {
            return false;
        }

        orguserRepository.deleteById(id);
        return true;
    }
}
