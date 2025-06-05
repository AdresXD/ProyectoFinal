package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.UsuarioEntity;
import com.usta.proyectofinal.models.dao.UsuarioDao;
import com.usta.proyectofinal.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioDao usuarioDao;

    public UsuarioServiceImplement(UsuarioRepository usuarioRepository, UsuarioDao usuarioDao) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioDao = usuarioDao;
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
    public UsuarioEntity findById(Long id) {
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

    @Override
    public UsuarioEntity findByEmail(String email) {
        return usuarioDao.findByEmail(email);
    }
}
