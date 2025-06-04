package com.usta.proyectofinal.models.services;

import com.usta.proyectofinal.entities.ApoyoEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface ApoyoService {
    public List<ApoyoEntity>findAll();
    public void save(ApoyoEntity apoyo);
    public ApoyoEntity findById(int id);
    public void delete(int id);
    public ApoyoEntity actualizarApo(ApoyoEntity apoyo);

}
