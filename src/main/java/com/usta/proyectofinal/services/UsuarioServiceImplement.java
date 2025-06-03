package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.UsuarioEntity;
import com.usta.proyectofinal.repositories.UsuarioRepository;
import com.usta.proyectofinal.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImplement(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioEntity> findAll() {
        return List.of();
    }

    @Override
    public void save(UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
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
    public UsuarioEntity viewDetail(Long id) {
        return null;
    }
}
