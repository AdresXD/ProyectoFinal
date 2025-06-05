package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.entities.StartupEntity;
import com.usta.proyectofinal.models.dao.ConvocatoriaDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvocatoriaServiceImplement implements ConvocatoriaService {

    @Autowired
    private ConvocatoriaDao convocatoriaDao;

    @Override
    @Transactional
    public List<ConvocatoriaEntity> findAll() {
        return (List<ConvocatoriaEntity>) convocatoriaDao.findAll();
    }

    @Override
    @Transactional
    public void save(ConvocatoriaEntity convocatoria) {
        convocatoriaDao.save(convocatoria);
    }

    @Override
    @Transactional
    public ConvocatoriaEntity findById(int id) {
        return convocatoriaDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        convocatoriaDao.deleteById(id);
    }

    @Override
    @Transactional
    public ConvocatoriaEntity actualizarConvo(ConvocatoriaEntity convocatoria) {
        return convocatoriaDao.save(convocatoria); // Save sirve también para actualizar si el ID ya existe
    }

    @Override
    @Transactional
    public ConvocatoriaEntity viewConvo(int id) {
        return convocatoriaDao.findById(id);
    }

    @Override
    @Transactional
    public void cancelarConvo(int id) {
        ConvocatoriaEntity convocatoria = convocatoriaDao.findById(id);
        if (convocatoria != null) {
            // Suponiendo que tienes un campo de estado
            // convocatoria.setEstadoConvocatoria("Cancelado");
            convocatoriaDao.save(convocatoria);
        }
    }

    @Override
    public boolean existeConvocatoriaParaStartup(StartupEntity startup) {
        List<ConvocatoriaEntity> convocatorias = convocatoriaDao.findByStartup(startup);
        return !convocatorias.isEmpty();
    }

    @Override
    public List<ConvocatoriaEntity> buscarPorStartup(StartupEntity startup) {
        return convocatoriaDao.findByStartup(startup);
    }

    public List<ConvocatoriaEntity> buscarPorStartupId(Integer idStartup) {
        return convocatoriaDao.findByStartupId(idStartup);
    }
}
