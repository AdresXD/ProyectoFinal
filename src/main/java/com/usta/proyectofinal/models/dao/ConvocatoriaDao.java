package com.usta.proyectofinal.models.dao;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ConvocatoriaDao extends CrudRepository<ConvocatoriaEntity,Integer> {
    @Transactional
    @Query("SELECT Us FROM ConvocatoriaEntity Us WHERE Us.idConvocatoria=?1")
    public ConvocatoriaEntity findById(int idConvocatoria);
    //Nesecita busqueda
}
