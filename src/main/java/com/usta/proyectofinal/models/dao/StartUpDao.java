package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.StartupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StartUpDao extends CrudRepository<StartupEntity, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT Us FROM StartupEntity Us WHERE Us.idStartup=?1")
    public StartupEntity viewDetail(Long id);

    @Query("SELECT s FROM StartupEntity s WHERE s.emprendedor.idUsuario = ?1")
    List<StartupEntity> findByUsuarioId(Long idUsuario);
}
