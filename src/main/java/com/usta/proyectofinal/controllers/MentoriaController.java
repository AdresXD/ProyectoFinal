package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.MentoriaEntity;
import com.usta.proyectofinal.services.MentoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // Mostrar formulario para crear mentoría
    @GetMapping(value = "/crearMentoria")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("title", "Crear Mentoría");
        model.addAttribute("mentoria", new MentoriaEntity());  // objeto vacío para el formulario
        return "mentorias/crearMentoria";
    }

    // Procesar el formulario y guardar la mentoría
    @PostMapping(value = "/crearMentoria")
    public String procesarFormularioCrear(@ModelAttribute MentoriaEntity mentoria, RedirectAttributes redirectAttrs) {
        mentoriaService.save(mentoria);  // guardar en la base de datos

        redirectAttrs.addFlashAttribute("mensajeExito", "Mentoría creada exitosamente.");
        return "redirect:/listarMentorias";  // redirigir a la lista después de guardar
    }
}
