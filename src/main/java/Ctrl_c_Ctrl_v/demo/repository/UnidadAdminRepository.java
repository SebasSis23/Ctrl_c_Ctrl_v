package Ctrl_c_Ctrl_v.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Ctrl_c_Ctrl_v.demo.entity.UnidadAdminEntity;

public interface UnidadAdminRepository
        extends JpaRepository<UnidadAdminEntity, String> {
}