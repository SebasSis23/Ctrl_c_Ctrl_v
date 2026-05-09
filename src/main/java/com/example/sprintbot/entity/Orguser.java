package com.example.sprintbot.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orguser")
public class Orguser {

    @Id
    @Column(length = 12, nullable = false)
    private String id;

    @Column(length = 12)
    private String tipo;

    @Column(length = 24)
    private String nombre;

    @Column(name = "solo_lectura")
    private Boolean soloLectura;

    private Integer ckval;

    @Lob
    @Column(columnDefinition = "nvarchar(max)")
    private String datos;

    @Column(name = "fecha_actualizacion")
    private LocalDate fechaActualizacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getSoloLectura() {
        return soloLectura;
    }

    public void setSoloLectura(Boolean soloLectura) {
        this.soloLectura = soloLectura;
    }

    public Integer getCkval() {
        return ckval;
    }

    public void setCkval(Integer ckval) {
        this.ckval = ckval;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
