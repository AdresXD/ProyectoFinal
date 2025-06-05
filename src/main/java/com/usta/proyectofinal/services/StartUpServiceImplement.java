package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.StartupEntity;
import com.usta.proyectofinal.entities.UsuarioEntity;
import com.usta.proyectofinal.models.dao.StartUpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StartUpServiceImplement implements StartUpService {

    @Autowired
    private StartUpDao startUpDao;

    @Override
    @Transactional(readOnly = true)
    public List<StartupEntity> findAll() {
        return (List<StartupEntity>) startUpDao.findAll();
    }

    @Override
    @Transactional
    public void save(StartupEntity startup) {
        startUpDao.save(startup);
    }

    @Override
    @Transactional(readOnly = true)
    public StartupEntity findById(int id) {
        return startUpDao.findById((long) id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(int id) {
        startUpDao.deleteById((long) id);
    }

    @Override
    @Transactional(readOnly = true)
    public StartupEntity ActualizarStartUp(int id) {
        return findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public StartupEntity viewDetail(int id) {
        return startUpDao.viewDetail((long) id);
    }

    @Override
    @Transactional
    public void cancelarStartUp(int id) {
        delete(id);
    }

    @Override
    public List<StartupEntity> findByUsuarioId(Long idUsuario) {
        return startUpDao.findByUsuarioId(idUsuario);
    }

    public interface UsuarioService {
        UsuarioEntity findByEmail(String email);
    }
}
