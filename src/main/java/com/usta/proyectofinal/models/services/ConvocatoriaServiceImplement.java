package com.usta.proyectofinal.models.services;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.models.dao.ConvocatoriaDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ConvocatoriaServiceImplement implements ConvocatoriaService {

    @Autowired
    private ConvocatoriaDao convocatoriaDao;

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
    public void delete(int id) {
    }

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
    public void cancelarConvo(int id) {

    }
}
