package com.usta.proyectofinal.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "APOYOS")
public class ApoyoEntity {

    @Id
    @Column(name = "id_apoyo")
    private Integer idApoyo;

    @Column(name = "monto")
    private Integer monto;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Size(max = 500)
    @Column(name = "observaciones", length = 500)
    private String observaciones;

    /**
     Relación con la entidad inversionista
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inversionista", referencedColumnName = "id_inversionista", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private InversionistaEntity inversionista;

    /**
     Relación con la entidad startup
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_startup", referencedColumnName = "id_startup", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StartupEntity startup;

}

