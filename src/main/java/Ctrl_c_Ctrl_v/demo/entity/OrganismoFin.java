package Ctrl_c_Ctrl_v.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "organismo_fin")
@Data
public class OrganismoFin {

    @Column(nullable = false)
    private Integer gestion;

    @Id
    @Column(length = 3)
    private String of;

    @Column(length = 100)
    private String des;

    @Column(length = 15)
    private String sigla;
}