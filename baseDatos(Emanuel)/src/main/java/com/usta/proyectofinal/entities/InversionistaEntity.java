package com.usta.proyectofinal.entities;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "INVERSIONISTAS")
public class InversionistaEntity {

    @Id
    @Column(name = "id_inversionista")
    private Integer idInversionista;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotNull
    @Size(min = 6, max = 100)
    @Column(name = "password", nullable = false, length = 100)
    private String password;
}

