package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

public interface UsuarioDao extends CrudRepository<UsuarioEntity, Long> {

    @Transactional
    @Query("SELECT Us FROM UsuarioEntity Us WHERE Us.email=?1")
    public UsuarioEntity findByEmail(String email);
}
