package com.usta.proyectofinal.models.services;

import com.usta.proyectofinal.entities.StartupEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface StartUpService {
    public List<StartupEntity> findAll();
    public void save(StartupEntity startup);
    public StartupEntity findById(int id);
    public void delete(int id);
    public StartupEntity ActualizarStartUp(int id);
    public StartupEntity viewDetail(int id);
    public void cancelarStartUp(int id);

}
