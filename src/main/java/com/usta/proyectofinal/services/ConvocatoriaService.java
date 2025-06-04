package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.entities.StartupEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface ConvocatoriaService {
    public List<ConvocatoriaEntity> findAll();
    public void save(ConvocatoriaEntity convocatoria);
    public ConvocatoriaEntity findById(int id);
    public void delete(int id);
    public ConvocatoriaEntity actualizarConvo(ConvocatoriaEntity convocatoria);
    public ConvocatoriaEntity viewConvo(int id);
    public void cancelarConvo(int id);
    public boolean existeConvocatoriaParaStartup(StartupEntity startup);
    public List<ConvocatoriaEntity> buscarPorStartup(StartupEntity startup);

}