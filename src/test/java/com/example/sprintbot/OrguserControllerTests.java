package com.example.sprintbot;

import com.example.sprintbot.controller.OrguserController;
import com.example.sprintbot.entity.Orguser;
import com.example.sprintbot.service.OrguserService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class OrguserControllerTests {

    private final FakeOrguserService orguserService = new FakeOrguserService();
    private final OrguserController orguserController = new OrguserController(orguserService);

    @Test
    void listarReturnsAllOrgusers() {
        Orguser orguser = buildOrguser("USR001");
        orguserService.create(orguser);

        List<Orguser> orgusers = orguserController.listar();

        assertThat(orgusers).containsExactly(orguser);
    }

    @Test
    void obtenerPorIdReturnsNotFoundWhenOrguserDoesNotExist() {
        ResponseEntity<Orguser> response = orguserController.obtenerPorId("USR404");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void guardarReturnsCreatedOrguser() {
        Orguser orguser = buildOrguser("USR001");

        ResponseEntity<Orguser> response = orguserController.guardar(orguser);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(orguser);
    }

    private Orguser buildOrguser(String id) {
        Orguser orguser = new Orguser();
        orguser.setId(id);
        orguser.setTipo("user");
        orguser.setNombre("Usuario");
        orguser.setSoloLectura(false);
        orguser.setCkval(1);
        orguser.setDatos("datos");
        orguser.setFechaActualizacion(LocalDate.of(2026, 5, 9));
        return orguser;
    }

    private static final class FakeOrguserService implements OrguserService {

        private final Map<String, Orguser> orgusers = new HashMap<>();

        @Override
        public List<Orguser> findAll() {
            return List.copyOf(orgusers.values());
        }

        @Override
        public Optional<Orguser> findById(String id) {
            return Optional.ofNullable(orgusers.get(id));
        }

        @Override
        public Orguser create(Orguser orguser) {
            orgusers.put(orguser.getId(), orguser);
            return orguser;
        }

        @Override
        public Optional<Orguser> update(String id, Orguser orguser) {
            if (!orgusers.containsKey(id)) {
                return Optional.empty();
            }

            orgusers.put(id, orguser);
            return Optional.of(orguser);
        }

        @Override
        public boolean deleteById(String id) {
            return orgusers.remove(id) != null;
        }
    }
}
