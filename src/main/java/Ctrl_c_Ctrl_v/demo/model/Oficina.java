package Ctrl_c_Ctrl_v.demo.model;
//corregido
import lombok.Data;
import java.util.Date;

@Data
public class Oficina {
    private String entidad;    
    private String unidad;     
    private int codofic;       
    private String nomofic;    
    private String observ;     
    private Date feult;        
    private String usuar;      
    private int api_estado;    
}