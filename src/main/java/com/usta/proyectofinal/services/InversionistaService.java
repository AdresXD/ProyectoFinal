package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.InversionistaEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface InversionistaService {
    public List<InversionistaEntity> findAll();
    public void save(InversionistaEntity inversionista);
    public InversionistaEntity findById(int id);
    public void delete(int id);
    public InversionistaEntity actualizarInver(InversionistaEntity inversionista);
}
