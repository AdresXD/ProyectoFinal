package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.ApoyoEntity;

import java.util.List;

public interface ApoyoService {
    public List<ApoyoEntity>findAll();
    public void save(ApoyoEntity apoyo);
    public ApoyoEntity findById(int id);
    public void delete(int id);
    public ApoyoEntity actualizarApo(ApoyoEntity apoyo);

}
