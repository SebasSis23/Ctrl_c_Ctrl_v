package Ctrl_c_Ctrl_v.demo.repository;
//corregido
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ctrl_c_Ctrl_v.demo.entity.ObjGastoEntity;

@Repository
public interface ObjGastoRepository extends JpaRepository<ObjGastoEntity, String> {
}
