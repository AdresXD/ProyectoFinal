package com.usta.proyectofinal.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "evaluaciones")
public class EvaluacionEntity {

    @Id
    @Column(name = "id_evaluacion")
    private Integer idEvaluacion;

    @NotNull
    @Column(name = "puntaje", nullable = false)
    private Integer puntaje;

    @NotNull
    @Size(max = 100)
    @Column(name = "nombre_proyecto", nullable = false, length = 100)
    private String nombreProyecto;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "fecha_evaluacion", nullable = false)
    private Date fechaEvaluacion;

    /**
     Relación con la entidad startup
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_startup", referencedColumnName = "id_startup", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StartupEntity startup;

}

