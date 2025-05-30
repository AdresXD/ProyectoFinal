package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;

import java.util.List;

public interface ConvocatoriaService {
    public List<ConvocatoriaEntity> findAll();
    public void save(ConvocatoriaEntity convocatoria);
    public ConvocatoriaEntity findById(int id);
    public void delete(int id);
    public ConvocatoriaEntity actualizarConvo(ConvocatoriaEntity convocatoria);
    public ConvocatoriaEntity viewConvo(int id);
    public void cancelarConvo(int id);

}
