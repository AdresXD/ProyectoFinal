package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.InversionistaEntity;
import com.usta.proyectofinal.entities.RolEntity;

import java.util.List;
public interface InversionistaService {
    public List<InversionistaEntity> findAll();
    public void save(InversionistaEntity inversionista);
    public InversionistaEntity findById(int id);
    public void delete(int id);
    public InversionistaEntity actualizarInver(InversionistaEntity inversionista);
}
