package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioDao extends CrudRepository<UsuarioEntity, Long> {
    @Transactional
    @Query("SELECT Us FROM UsuarioEntity Us WHERE Us.email=?1")
    public UsuarioEntity findByEmail(String email);

}
