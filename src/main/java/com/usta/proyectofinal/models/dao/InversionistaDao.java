package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.InversionistaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface InversionistaDao extends CrudRepository<InversionistaEntity,Integer> {
}
