package com.usta.proyectofinal.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "MENTORIAS")
public class MentoriaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_mentoria")
    private long idMentoria;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Size(max = 500)
    @Column(name = "observaciones", length = 500)
    private String observaciones;

    @Column(name = "calificacion")
    private Integer calificacion;

    @Size(max = 300)
    @Column(name = "logo", length = 300)
    private String logo;

    /**
     Relación con la entidad startup
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_startup", referencedColumnName = "id_startup", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StartupEntity startup;

    /**
     Relación con la entidad usuario
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mentor", referencedColumnName = "id_usuario", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UsuarioEntity mentor;

}