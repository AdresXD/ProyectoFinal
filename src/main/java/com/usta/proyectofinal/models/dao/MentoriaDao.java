package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.MentoriaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MentoriaDao extends CrudRepository<MentoriaEntity, Long> {

    @Transactional
    @Query("SELECT Me from MentoriaEntity  Me where Me.idMentoria=?1")
    public MentoriaEntity viewDetails(Long idMentoria);
}
