package Ctrl_c_Ctrl_v.demo.dto;

public class UnidadAdminDTO {

    private Long id;
    private String entidad;
    private String unidad;
    private String descrip;
    private String ciudad;
    private int estadouni;

    public UnidadAdminDTO() {
    }

    public UnidadAdminDTO(Long id, String entidad, String unidad,
                          String descrip, String ciudad, int estadouni) {
        this.id = id;
        this.entidad = entidad;
        this.unidad = unidad;
        this.descrip = descrip;
        this.ciudad = ciudad;
        this.estadouni = estadouni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getEstadouni() {
        return estadouni;
    }

    public void setEstadouni(int estadouni) {
        this.estadouni = estadouni;
    }
}