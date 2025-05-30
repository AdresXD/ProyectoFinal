package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.StartupEntity;
import org.springframework.data.repository.CrudRepository;

public interface StartUpDao extends CrudRepository<StartupEntity, Integer> {

}
