package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ConvocatoriaDao extends CrudRepository<ConvocatoriaEntity,Integer> {
    //Nesecita busqueda
}
