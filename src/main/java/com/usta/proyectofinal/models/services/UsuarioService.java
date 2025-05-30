package com.usta.proyectofinal.models.services;

import com.usta.proyectofinal.entities.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface UsuarioService {
    public List<UsuarioEntity> findAll();
    public void save(UsuarioEntity usuario);
    public UsuarioEntity findById(int id);
    public void delete(int id);
    public UsuarioEntity actualizarUsu(UsuarioEntity usuario);
    public void changeState(int id);
    public UsuarioEntity viewDetail(int id);
}
