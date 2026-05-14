package Ctrl_c_Ctrl_v.demo.Model;

import lombok.Data;
import java.util.Date;

@Data
public class Orguser {

    private String id;
    private String tipo;
    private String nombre;
    private Boolean soloLectura;
    private Integer ckval;
    private String datos;
    private Date fechaActualizacion;
}