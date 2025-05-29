package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.StartupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface StartupDao extends CrudRepository {
    @Transactional
    @Query("SELECT S FROM StartupEntity S WHERE S.fechaPostulacion=?1")
    public List<StartupEntity> findByFechaPostulacion(Date fecha);

    @Transactional
    @Query("SELECT S FROM StartupEntity S WHERE S.idStartup=?1")
    public List<StartupEntity> findByIdStartup(Long idStartup);
}
