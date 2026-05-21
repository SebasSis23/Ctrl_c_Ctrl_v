package Ctrl_c_Ctrl_v.demo.repository;

import Ctrl_c_Ctrl_v.demo.Entity.UnidadAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadAdminRepository
        extends JpaRepository<UnidadAdminEntity, String> {
}