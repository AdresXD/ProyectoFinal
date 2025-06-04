package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.InversionistaEntity;
import com.usta.proyectofinal.services.InversionistaService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class InversionistaServiceImplement implements InversionistaService {

    @Override
    @Transactional
    public List<InversionistaEntity> findAll() {
        return List.of();
    }

    @Override
    @Transactional
    public void save(InversionistaEntity inversionista) {

    }

    @Override
    @Transactional
    public InversionistaEntity findById(int id) {
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {

    }

    @Override
    @Transactional
    public InversionistaEntity actualizarInver(InversionistaEntity inversionista) {
        return null;
    }
}
