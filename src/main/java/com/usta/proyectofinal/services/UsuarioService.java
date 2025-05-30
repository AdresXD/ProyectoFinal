package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioService {
    public List<UsuarioEntity> findAll();
    public void save(UsuarioEntity usuario);
    public UsuarioEntity findById(int id);
    public void delete(int id);
    public UsuarioEntity actualizarUsu(UsuarioEntity usuario);
    public void changeState(int id);
    public UsuarioEntity viewDetail(int id);
}
