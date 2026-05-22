package Ctrl_c_Ctrl_v.demo.entity;
//corregido
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "orguser")
public class OrguserEntity {

    @Id
    @Column(length = 12)
    private String id;

    @Column(length = 12)
    private String type;

    @Column(length = 24)
    private String name;

    @Column(name = "readonly")
    private Boolean readonly;

    @Column(precision = 6, scale = 0)
    private Integer ckval;

    @Column(columnDefinition = "TEXT")
    private String data;

    private LocalDate updated;

    public OrguserEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getReadonly() {
        return readonly;
    }

    public void setReadonly(Boolean readonly) {
        this.readonly = readonly;
    }

    public Integer getCkval() {
        return ckval;
    }

    public void setCkval(Integer ckval) {
        this.ckval = ckval;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }
}
