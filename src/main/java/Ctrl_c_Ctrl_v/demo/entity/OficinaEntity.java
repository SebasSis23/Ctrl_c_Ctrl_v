package Ctrl_c_Ctrl_v.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "oficina")
public class OficinaEntity {

    @Id
    @Column(length = 4)
    private String entidad;

    @Column(length = 5)
    private String unidad;

    private Integer codofic;

    @Column(length = 65)
    private String nomofic;

    @Column(columnDefinition = "TEXT")
    private String observ;

    private Date feult;

    @Column(length = 8)
    private String usuar;

    private Integer api_estado;

    public OficinaEntity() {
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

    public Integer getCodofic() { 
        return codofic; 
    }
    public void setCodofic(Integer codofic) { 
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

    public Integer getApi_estado() { 
        return api_estado; 
    }
    public void setApi_estado(Integer api_estado) { 
        this.api_estado = api_estado; 
    }
}