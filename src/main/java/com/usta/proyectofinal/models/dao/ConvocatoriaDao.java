package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.entities.StartupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ConvocatoriaDao extends CrudRepository<ConvocatoriaEntity,Integer> {
    @Transactional
    @Query("SELECT Us FROM ConvocatoriaEntity Us WHERE Us.idConvocatoria=?1")
    public ConvocatoriaEntity findById(int idConvocatoria);
    //Nesecita busqueda

    @Query("SELECT c FROM ConvocatoriaEntity c WHERE c.idConvocatoria = ?1")
    List<ConvocatoriaEntity> findByStartup(StartupEntity startup);

    @Query("SELECT DISTINCT c FROM ConvocatoriaEntity c JOIN StartupEntity s ON s.convocatoria = c WHERE s.idStartup = ?1")
    List<ConvocatoriaEntity> findByStartupId(Integer idStartup);


}
