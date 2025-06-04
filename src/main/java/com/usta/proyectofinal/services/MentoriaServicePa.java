package com.usta.proyectofinal.services;

import com.usta.proyectofinal.entities.MentoriaEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface MentoriaServicePa {
        public List<MentoriaEntity> findAll();
        public void save(MentoriaEntity mentoria);
        public MentoriaEntity findById(int id);
        public void deleteById(int id);
        public MentoriaEntity actualizarMen(MentoriaEntity mentoria);
        public  void changeState(int id);
        public MentoriaEntity viewDetail(int id);
}


