package com.usta.proyectofinal.models.services;

import com.usta.proyectofinal.entities.RolEntity;
import com.usta.proyectofinal.services.RolService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RolServiceImplement  implements RolService {
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
