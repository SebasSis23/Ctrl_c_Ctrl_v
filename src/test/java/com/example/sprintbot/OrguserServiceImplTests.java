package com.example.sprintbot;

import com.example.sprintbot.entity.Orguser;
import com.example.sprintbot.repository.OrguserRepository;
import com.example.sprintbot.service.impl.OrguserServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class OrguserServiceImplTests {

    private final FakeOrguserRepository fakeOrguserRepository = new FakeOrguserRepository();
    private final OrguserRepository orguserRepository = fakeOrguserRepository.asRepository();
    private final OrguserServiceImpl orguserService = new OrguserServiceImpl(orguserRepository);

    @Test
    void createSavesOrguser() {
        Orguser orguser = buildOrguser("USR001");

        Orguser savedOrguser = orguserService.create(orguser);

        assertThat(savedOrguser).isEqualTo(orguser);
        assertThat(orguserRepository.findById("USR001")).contains(orguser);
    }

    @Test
    void updateCopiesEditableFieldsWhenOrguserExists() {
        Orguser existingOrguser = buildOrguser("USR001");
        Orguser update = buildOrguser("IGNORED");
        update.setTipo("admin");
        update.setNombre("Usuario actualizado");
        update.setSoloLectura(true);
        update.setCkval(99);
        update.setDatos("datos actualizados");
        update.setFechaActualizacion(LocalDate.of(2026, 5, 9));

        orguserRepository.save(existingOrguser);

        Optional<Orguser> updatedOrguser = orguserService.update("USR001", update);

        assertThat(updatedOrguser).isPresent();
        assertThat(updatedOrguser.get().getId()).isEqualTo("USR001");
        assertThat(updatedOrguser.get().getTipo()).isEqualTo("admin");
        assertThat(updatedOrguser.get().getNombre()).isEqualTo("Usuario actualizado");
        assertThat(updatedOrguser.get().getSoloLectura()).isTrue();
        assertThat(updatedOrguser.get().getCkval()).isEqualTo(99);
        assertThat(updatedOrguser.get().getDatos()).isEqualTo("datos actualizados");
        assertThat(updatedOrguser.get().getFechaActualizacion()).isEqualTo(LocalDate.of(2026, 5, 9));
    }

    @Test
    void deleteReturnsFalseWhenOrguserDoesNotExist() {
        boolean deleted = orguserService.deleteById("USR404");

        assertThat(deleted).isFalse();
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

    private static final class FakeOrguserRepository implements InvocationHandler {

        private final Map<String, Orguser> orgusers = new HashMap<>();
        private final OrguserRepository proxy = (OrguserRepository) java.lang.reflect.Proxy.newProxyInstance(
                OrguserRepository.class.getClassLoader(),
                new Class<?>[]{OrguserRepository.class},
                this);

        public OrguserRepository asRepository() {
            return proxy;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            return switch (method.getName()) {
                case "findAll" -> new ArrayList<>(orgusers.values());
                case "findById" -> Optional.ofNullable(orgusers.get((String) args[0]));
                case "existsById" -> orgusers.containsKey((String) args[0]);
                case "save" -> save((Orguser) args[0]);
                case "deleteById" -> {
                    orgusers.remove((String) args[0]);
                    yield null;
                }
                default -> throw new UnsupportedOperationException(method.getName() + " is not needed by these tests");
            };
        }

        public List<Orguser> findAll() {
            return new ArrayList<>(orgusers.values());
        }

        public Optional<Orguser> findById(String id) {
            return Optional.ofNullable(orgusers.get(id));
        }

        public Orguser save(Orguser entity) {
            orgusers.put(entity.getId(), entity);
            return entity;
        }
    }
}
