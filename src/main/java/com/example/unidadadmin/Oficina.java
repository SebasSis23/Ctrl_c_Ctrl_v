package Ctrl_c_Ctrl_v.demo;

import java.util.Date;

public class Oficina {
    private String entidad;    
    private String unidad;     
    private int codofic;       
    private String nomofic;    
    private String observ;     
    private Date feult;        
    private String usuar;      
    private int api_estado;    

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

    public int getCodofic() {
        return codofic;
    }

    public void setCodofic(int codofic) {
        this.codofic = codofic;
    }

    public String getNomofic() {
        return nomofic;
    }

    public void setNomofic(String nomofic) {
        this.nomofic = nomofic;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public Date getFeult() {
        return feult;
    }

    public void setFeult(Date feult) {
        this.feult = feult;
    }

    public String getUsuar() {
        return usuar;
    }

    public void setUsuar(String usuar) {
        this.usuar = usuar;
    }

    public int getApi_estado() {
        return api_estado;
    }

    public void setApi_estado(int api_estado) {
        this.api_estado = api_estado;
    }
}
