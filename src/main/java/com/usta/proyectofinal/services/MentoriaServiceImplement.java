package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.MentoriaEntity;
import com.usta.proyectofinal.models.dao.MentoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MentoriaServiceImplement implements MentoriaServicePa {

    @Autowired
    private MentoriaDao mentoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<MentoriaEntity> findAll() {
        List<MentoriaEntity> lista = mentoriaDao.findMentoriasByDate();
        System.out.println("Mentorias encontradas en servicio: " + lista.size());
        return lista;
    }

    @Override
    @Transactional
    public void save(MentoriaEntity mentoria) {
        mentoriaDao.save(mentoria);
    }

    @Override
    @Transactional(readOnly = true)
    public MentoriaEntity findById(int id) {
        return mentoriaDao.findMentoriaById(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        mentoriaDao.deleteById(id);
    }

    @Override
    @Transactional
    public MentoriaEntity actualizarMen(MentoriaEntity mentoria) {
        return mentoriaDao.save(mentoria);
    }

    @Override
    @Transactional
    public void changeState(int id) {
        // Aquí puedes implementar según la lógica que necesites
    }

    @Override
    @Transactional(readOnly = true)
    public MentoriaEntity viewDetail(int id) {
        return mentoriaDao.findMentoriaById(id);
    }
}