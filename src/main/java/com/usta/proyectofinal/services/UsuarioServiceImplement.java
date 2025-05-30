package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    @Override
    public List<UsuarioEntity> findAll() {
        return List.of();
    }

    @Override
    public void save(UsuarioEntity usuario) {

    }

    @Override
    public UsuarioEntity findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public UsuarioEntity actualizarUsu(UsuarioEntity usuario) {
        return null;
    }

    @Override
    public void changeState(int id) {

    }

    @Override
    public UsuarioEntity viewDetail(int id) {
        return null;
    }
}
