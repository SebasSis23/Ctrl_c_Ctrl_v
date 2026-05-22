package Ctrl_c_Ctrl_v.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "password")
public class PasswordEntity {

    @Id
    private int id;

    private String completo;
    private String des;
    private String psw;
    private String tipo;
    private String grupo;
    private String feult;
    private String usuar;

    // Constructor vacío
    public PasswordEntity() {
    }

    // Constructor completo
    public PasswordEntity(int id, String completo, String des,
        String psw, String tipo, String grupo,
        String feult, String usuar) {

        this.id = id;
        this.completo = completo;
        this.des = des;
        this.psw = psw;
        this.tipo = tipo;
        this.grupo = grupo;
        this.feult = feult;
        this.usuar = usuar;
    }

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getCompleto() {
        return completo;
    }

    public void setCompleto(String completo) {
        this.completo = completo;
    }


    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }


    public String getFeult() {
        return feult;
    }

    public void setFeult(String feult) {
        this.feult = feult;
    }


    public String getUsuar() {
        return usuar;
    }

    public void setUsuar(String usuar) {
        this.usuar = usuar;
    }
}