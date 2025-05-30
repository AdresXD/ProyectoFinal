package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.StartupEntity;
import com.usta.proyectofinal.services.StartUpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StartUpServiceImplement implements StartUpService {
    @Override
    @Transactional
    public List<StartupEntity> findAll() {
        return List.of();
    }

    @Override
    @Transactional
    public void save(StartupEntity startup) {

    }

    @Override
    @Transactional
    public StartupEntity findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {

    }

    @Override
    @Transactional
    public StartupEntity ActualizarStartUp(int id) {
        return null;
    }

    @Override
    @Transactional
    public StartupEntity viewDetail(int id) {
        return null;
    }

    @Override
    @Transactional
    public void cancelarStartUp(int id) {

    }
}
