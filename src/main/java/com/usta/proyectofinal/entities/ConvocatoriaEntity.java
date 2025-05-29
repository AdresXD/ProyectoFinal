package com.usta.proyectofinal.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "convocatorias")
public class ConvocatoriaEntity {

    @Id
    @Column(name = "id_convocatoria")
    private Integer idConvocatoria;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 250)
    @Column(name = "descripcion", length = 250)
    private String descripcion;

    @Size(max = 100)
    @Column(name = "lugar", length = 100)
    private String lugar;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @DateTimeFormat(pattern = "hh:mm")
    @Column(name = "hora")
    private java.time.LocalTime hora;

}
