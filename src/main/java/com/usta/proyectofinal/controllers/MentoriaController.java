package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.MentoriaEntity;
import com.usta.proyectofinal.models.services.MentoriaServicePa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Controller
//mentor controller
public class MentoriaController {
    @Autowired
    private MentoriaServicePa mentoriaServicePa;

    @GetMapping("/mentoria")
    public String mentoria(Model model){
        model.addAttribute("title", "Listar Mentorias");
        List<MentoriaEntity> listaInmutable = mentoriaServicePa.findAll();
        List<MentoriaEntity> lista = new ArrayList<>(listaInmutable); // 🔧 Hacemos mutable
        lista.sort(Comparator.comparing(MentoriaEntity::getIdMentoria)); // o lo que uses para ordenar
        model.addAttribute("mentorias", lista);
        return "mentorias/listarMentorias";
    }
}
