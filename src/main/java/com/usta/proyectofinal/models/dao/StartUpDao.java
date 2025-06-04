package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.StartupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface StartUpDao extends CrudRepository<StartupEntity, Integer> {
    @Transactional
    @Query("SELECT Us FROM StartupEntity Us WHERE Us.idStartup=?1")
    public StartupEntity findById(int
                                  idStartup);
    //Nesecita busqueda
}
