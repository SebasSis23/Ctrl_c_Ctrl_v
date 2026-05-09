package com.example.unidadadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "unidadadmin")
public class UnidadAdminEntity {

    @Id
    private String unidad;

    private String entidad;
    private String descrip;
    private String ciudad;
    private int estadouni;

    public UnidadAdminEntity() {
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
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

    public int getEstadouni() {
        return estadouni;
    }

    public void setEstadouni(int estadouni) {
        this.estadouni = estadouni;
    }
}