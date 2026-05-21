package Ctrl_c_Ctrl_v.demo.service;

import Ctrl_c_Ctrl_v.demo.entity.OrganismoFin;
import Ctrl_c_Ctrl_v.demo.repository.OrganismoFinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganismoFinService {

    @Autowired
    private OrganismoFinRepository repository;

    // LISTAR TODOS
    public List<OrganismoFin> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Optional<OrganismoFin> buscarPorId(String of) {
        return repository.findById(of);
    }

    // GUARDAR
    public OrganismoFin guardar(OrganismoFin organismoFin) {
        return repository.save(organismoFin);
    }

    // ELIMINAR
    public void eliminar(String of) {
        repository.deleteById(of);
    }
}
