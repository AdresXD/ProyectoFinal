package com.usta.proyectofinal.models.services;

import com.usta.proyectofinal.entities.MentoriaEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MentoriaServiceImplement implements MentoriaServicePa {


    @Override
    @Transactional
    public List<MentoriaEntity> findAll() {
        return List.of();
    }

    @Override
    @Transactional
    public void save(MentoriaEntity mentoria) {

    }

    @Override
    @Transactional
    public MentoriaEntity findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {

    }

    @Override
    @Transactional
    public MentoriaEntity actualizarMen(MentoriaEntity mentoria) {
        return null;
    }

    @Override
    @Transactional
    public void changeState(int id) {

    }

    @Override
    @Transactional
    public MentoriaEntity viewDetail(int id) {
        return null;
    }
}
