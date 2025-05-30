package com.usta.proyectofinal.entities;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ROLES")

public class RolEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "rol", length = 30, nullable = false)
    private String rol;

    public RolEntity(String rol) {
        super();
        this.rol = rol;
    }
    public RolEntity(){

    }
    public String getRol() {
        return this.rol;
    }
    public void setRol(String rol){
        this.rol = rol;
    }

    public Long getIdRol(){return idRol;}
    public void setIdRol(){this.idRol = idRol;}

}