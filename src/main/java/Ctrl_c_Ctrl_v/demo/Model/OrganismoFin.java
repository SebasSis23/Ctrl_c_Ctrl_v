package Ctrl_c_Ctrl_v.demo.model;

import lombok.Data;

@Data
public class OrganismoFin {

    private Integer gestion; // Numeric(4)
    private String of;       // Character(3)
    private String des;      // Character(100)
    private String sigla;    // Character(15)
}