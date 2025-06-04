package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.entities.StartupEntity;
import com.usta.proyectofinal.models.dao.ConvocatoriaDao;
import jakarta.transaction.Transactional;

import java.util.List;

public class ConvocatoriaServiceImplement implements ConvocatoriaService {
    @Override
    @Transactional
    public List<ConvocatoriaEntity> findAll() {
        return List.of();
    }

    @Override
    @Transactional
    public void save(ConvocatoriaEntity convocatoria) {

    }

    @Override
    @Transactional
    public ConvocatoriaEntity findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {}

    @Override
    @Transactional
    public ConvocatoriaEntity actualizarConvo(ConvocatoriaEntity convocatoria) {
        return null;
    }

    @Override
    @Transactional
    public ConvocatoriaEntity viewConvo(int id) {
        return null;
    }

    @Override
    @Transactional
    public void cancelarConvo(int id) {}

    @Override
    public boolean existeConvocatoriaParaStartup(StartupEntity startup) {
        return false;
    }

    @Override
    public List<ConvocatoriaEntity> buscarPorStartup(StartupEntity startup) {
        return List.of();
    }

    public ConvocatoriaServiceImplement() {
        super();
    }

    public List<ConvocatoriaEntity> buscarPorStartupId(Integer idStartup) {
        return null;
    }
}
