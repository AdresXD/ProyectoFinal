package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.ApoyoEntity;
import com.usta.proyectofinal.models.dao.ApoyoDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ApoyoServiceImplement implements ApoyoService {
    @Autowired
    private ApoyoDao apoyoDao;

    @Override
    @Transactional
    public List<ApoyoEntity> findAll() {
        return List.of();
    }

    @Override
    @Transactional
    public void save(ApoyoEntity apoyo) {

    }

    @Override
    @Transactional
    public ApoyoEntity findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {

    }

    @Override
    @Transactional
    public ApoyoEntity actualizarApo(ApoyoEntity apoyo) {
        return null;
    }
}
