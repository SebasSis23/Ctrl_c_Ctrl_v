package Ctrl_c_Ctrl_v.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Ctrl_c_Ctrl_v.demo.entity.OficinaEntity;

@Repository
public interface OficinaRepository extends JpaRepository<OficinaEntity, String> {
}