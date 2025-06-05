package com.usta.proyectofinal.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "STARTUPS")
public class StartupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_startup")
    private Integer idStartup;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 500)
    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "sector", nullable = false, length = 100)
    private String sector;

    @Size(max = 300)
    @Column(name = "logo", length = 300)
    private String logo;

    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_postulacion", nullable = false)
    private Date fechaPostulacion;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_emprendedor", referencedColumnName = "id_usuario", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UsuarioEntity emprendedor;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_convocatoria", referencedColumnName = "id_convocatoria", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ConvocatoriaEntity convocatoria;
}
