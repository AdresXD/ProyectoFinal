package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.MentoriaEntity;
import com.usta.proyectofinal.services.MentoriaServicePa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Comparator;
import java.util.List;
@Controller
//mentor controller
public class MentoriaController {
    @Autowired
    private MentoriaServicePa mentoriaServicePa;

    @GetMapping(value ="/mentoria")
    public String Mentoria(Model model){
        model.addAttribute("title","Mentoria List");
        model.addAttribute("urlRegistro","/crearMentoria");
        List<MentoriaEntity> lista= mentoriaService.findAll();
        lista.sort(Comparator.comparing(MentoriaEntity::getIdMentoria));
        model.addAttribute("mentorias",lista);
        return "mentorias/listarMentorias";
    }


}
