package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.MentoriaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MentoriaDao extends CrudRepository<MentoriaEntity, Integer> {

    @Transactional
    @Query("SELECT Me FROM MentoriaEntity Me WHERE Me.idMentoria=?1")
    public MentoriaEntity findMentoriaById(Integer id);

    @Transactional
    @Modifying
    @Query("SELECT Me FROM MentoriaEntity Me ORDER BY Me.fecha DESC ")
    List<MentoriaEntity> findMentoriasByDate();
}
