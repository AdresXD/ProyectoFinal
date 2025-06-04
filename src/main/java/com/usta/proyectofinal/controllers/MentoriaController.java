package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.MentoriaEntity;
import com.usta.proyectofinal.services.MentoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

@Controller
public class MentoriaController {

    @Autowired
    private MentoriaService mentoriaService;

    @GetMapping(value = "/listarMentorias")
    public String Mentoria(Model model) {
        model.addAttribute("title", "Mentoria List");
        model.addAttribute("urlRegistro", "/crearMentoria");

        // Copia mutable de la lista
        List<MentoriaEntity> lista = new ArrayList<>(mentoriaService.findAll());
        lista.sort(Comparator.comparing(MentoriaEntity::getIdMentoria));

        model.addAttribute("mentorias", lista);
        return "mentorias/listarMentorias";
    }
}
