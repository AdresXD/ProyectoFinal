package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.MentoriaEntity;
import com.usta.proyectofinal.models.dao.MentoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service

public class MentoriaServiceImplement implements MentoriaService{
    @Autowired
    private MentoriaDao mentoriaDao;


    @Override
    @Transactional
    public List<MentoriaEntity> findAll() {
        return(List<MentoriaEntity>) mentoriaDao.findAll() ;
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

    @Transactional

    public MentoriaEntity viewDetail(long id) {
        return mentoriaDao.viewDetails(id);
    }



}
