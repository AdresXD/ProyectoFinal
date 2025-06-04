package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.RolEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RolServiceImplement  implements RolService{
    @Override
    @Transactional
    public List<RolEntity> findAll() {
        return List.of();
    }

    @Override
    @Transactional
    public void save(RolEntity rol) {

    }

    @Override
    @Transactional
    public RolEntity findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {

    }

    @Override
    @Transactional
    public RolEntity actualizarRol(RolEntity rol) {
        return null;
    }


}
