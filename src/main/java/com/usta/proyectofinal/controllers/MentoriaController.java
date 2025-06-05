package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.MentoriaEntity;
import com.usta.proyectofinal.services.MentoriaServicePa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MentoriaController {

    @Autowired
    private MentoriaServicePa mentoriaServicePa;

    @GetMapping("/mentoria")
    public String mentoria(Model model){
        model.addAttribute("title", "Listar Mentorias");
        List<MentoriaEntity> lista = mentoriaServicePa.findAll();
        System.out.println("Mentorias encontradas en controlador: " + lista.size());
        model.addAttribute("mentorias", lista);
        return "mentorias/listarMentorias";
    }
}
