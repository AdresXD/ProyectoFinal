package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.StartupEntity;

import java.util.List;

public interface StartUpService {
    public List<StartupEntity> findAll();
    public void save(StartupEntity startup);
    public StartupEntity findById(int id);
    public void delete(int id);
    public StartupEntity ActualizarStartUp(int id);
    public StartupEntity viewDetail(int id);
    public void cancelarStartUp(int id);

}
