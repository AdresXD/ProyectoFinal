package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.ApoyoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ApoyoDao extends CrudRepository<ApoyoEntity,Integer> {
//Se puede quitar pero ahí se queda por mk
}
