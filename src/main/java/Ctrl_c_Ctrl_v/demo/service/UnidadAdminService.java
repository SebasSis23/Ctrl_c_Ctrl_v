package Ctrl_c_Ctrl_v.demo.service;

import Ctrl_c_Ctrl_v.demo.dto.UnidadAdminDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UnidadAdminService {

    private final List<UnidadAdminDTO> lista = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<UnidadAdminDTO> getAll() {
        return lista;
    }

    public UnidadAdminDTO getById(Long id) {
        return lista.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public UnidadAdminDTO add(UnidadAdminDTO unidad) {
        unidad.setId(idGenerator.getAndIncrement());
        lista.add(unidad);
        return unidad;
    }

    public UnidadAdminDTO update(Long id, UnidadAdminDTO nuevo) {

        UnidadAdminDTO unidad = getById(id);

        if (unidad != null) {
            unidad.setEntidad(nuevo.getEntidad());
            unidad.setUnidad(nuevo.getUnidad());
            unidad.setDescrip(nuevo.getDescrip());
            unidad.setCiudad(nuevo.getCiudad());
            unidad.setEstadouni(nuevo.getEstadouni());
        }

        return unidad;
    }

    public boolean delete(Long id) {

        UnidadAdminDTO unidad = getById(id);

        if (unidad != null) {
            lista.remove(unidad);
            return true;
        }

        return false;
    }
}