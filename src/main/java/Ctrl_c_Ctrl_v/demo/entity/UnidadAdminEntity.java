package Ctrl_c_Ctrl_v.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bd_unidad_admin")
public class UnidadAdminEntity {

    @Id
    @Column(length = 4)
    private String entidad;

    @Column(length = 5)
    private String unidad;

    @Column(length = 120)
    private String descrip;

    @Column(length = 20)
    private String ciudad;

    private Integer estadouni;

    public UnidadAdminEntity() {
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getEstadouni() {
        return estadouni;
    }

    public void setEstadouni(Integer estadouni) {
        this.estadouni = estadouni;
    }
}