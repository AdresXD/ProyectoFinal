package com.usta.proyectofinal.models.services;

import com.usta.proyectofinal.entities.RolEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface RolService {
    public List<RolEntity> findAll();
    public void save(RolEntity rol);
    public RolEntity findById(int id);
    public void delete(int id);
    public RolEntity actualizarRol(RolEntity rol);
}
