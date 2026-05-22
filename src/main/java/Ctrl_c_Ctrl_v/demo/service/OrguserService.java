package Ctrl_c_Ctrl_v.demo.service;

import Ctrl_c_Ctrl_v.demo.entity.OrguserEntity;
import Ctrl_c_Ctrl_v.demo.model.Orguser;
import Ctrl_c_Ctrl_v.demo.repository.OrguserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrguserService {

    @Autowired
    private OrguserRepository orguserRepository;

    public List<Orguser> getAllOrguser() {
        return orguserRepository.findAll()
                .stream()
                .map(this::toModel)
                .toList();
    }

    public Optional<Orguser> getOrguserById(String id) {
        return orguserRepository.findById(id).map(this::toModel);
    }

    public boolean deleteOrguser(String id) {
        if (!orguserRepository.existsById(id)) {
            return false;
        }

        orguserRepository.deleteById(id);
        return true;
    }

    public Orguser saveOrguser(Orguser orguser) {
        OrguserEntity orguserEntity = toEntity(orguser);
        return toModel(orguserRepository.save(orguserEntity));
    }

    public Optional<Orguser> updateOrguser(String id, Orguser orguser) {
        if (!orguserRepository.existsById(id)) {
            return Optional.empty();
        }

        OrguserEntity orguserEntity = toEntity(orguser);
        orguserEntity.setId(id);
        return Optional.of(toModel(orguserRepository.save(orguserEntity)));
    }

    private Orguser toModel(OrguserEntity orguserEntity) {
        Orguser orguser = new Orguser();
        orguser.setId(orguserEntity.getId());
        orguser.setTipo(orguserEntity.getType());
        orguser.setNombre(orguserEntity.getName());
        orguser.setSoloLectura(orguserEntity.getReadonly());
        orguser.setCkval(orguserEntity.getCkval());
        orguser.setDatos(orguserEntity.getData());
        orguser.setFechaActualizacion(orguserEntity.getUpdated());
        return orguser;
    }

    private OrguserEntity toEntity(Orguser orguser) {
        OrguserEntity orguserEntity = new OrguserEntity();
        orguserEntity.setId(orguser.getId());
        orguserEntity.setType(orguser.getTipo());
        orguserEntity.setName(orguser.getNombre());
        orguserEntity.setReadonly(orguser.getSoloLectura());
        orguserEntity.setCkval(orguser.getCkval());
        orguserEntity.setData(orguser.getDatos());
        orguserEntity.setUpdated(orguser.getFechaActualizacion());
        return orguserEntity;
    }
}
