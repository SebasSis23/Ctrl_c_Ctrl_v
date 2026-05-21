package Ctrl_c_Ctrl_v.demo.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Orguser {

    private String id;
    private String tipo;
    private String nombre;
    private Boolean soloLectura;
    private Integer ckval;
    private String datos;
    private LocalDate fechaActualizacion;
}
