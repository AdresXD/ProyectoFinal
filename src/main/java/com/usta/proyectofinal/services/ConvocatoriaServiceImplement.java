package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

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
    public void delete(int id) {
        //ConvocatoriaDao.deleteById();
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
