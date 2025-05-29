package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.RolEntity;

import java.util.List;

public interface RolService {
    public List<RolEntity> findAll();
    public void save(RolEntity rol);
    public RolEntity findById(int id);
    public void delete(int id);
    public RolEntity actualizarRol(RolEntity rol);
}
