package Ctrl_c_Ctrl_v.demo.repository;
//corregido
import Ctrl_c_Ctrl_v.demo.entity.OrguserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrguserRepository extends JpaRepository<OrguserEntity, String> {
}
