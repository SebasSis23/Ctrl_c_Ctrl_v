package Ctrl_c_Ctrl_v.demo.Repository;

import Ctrl_c_Ctrl_v.demo.Entity.ObjGastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjGastoRepository extends JpaRepository<ObjGastoEntity, String> {
}
