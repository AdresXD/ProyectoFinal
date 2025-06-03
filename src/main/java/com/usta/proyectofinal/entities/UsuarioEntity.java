package com.usta.proyectofinal.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "USUARIOS")
public class UsuarioEntity {

    @Id
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotNull
    @Email
    @Size(min = 5, max = 150)
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @NotNull
    @Size(min = 6, max = 100)
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RolEntity rol;

    /**
     public RolEntity getRol() {
        return this.rol;
     }

     public void setRol(RolEntity rol) {
        this.rol = rol;
     }

     public String getEmail() {
        return this.email;
     }
     */
}