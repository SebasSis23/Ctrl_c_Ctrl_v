package Ctrl_c_Ctrl_v.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "orguser")
@Data
public class Orguser {

    @Id
    private String id;

    private String tipo;

    private String nombre;

    private Boolean soloLectura;

    private Integer ckval;

    @Column(columnDefinition = "TEXT")
    private String datos;

    private Date fechaActualizacion;
}