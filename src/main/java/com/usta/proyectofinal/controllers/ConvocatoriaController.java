package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.services.ConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/convocatorias")
public class ConvocatoriaController {

    @Autowired
    private ConvocatoriaService convocatoriaService;

    @GetMapping("/convocatoria")  // Corregido para que coincida con el redirect
    public String listarConvocatorias(Model model) {
        List<ConvocatoriaEntity> convocatorias = convocatoriaService.findAll();
        model.addAttribute("convocatorias", convocatorias);
        return "convocatorias/listarConvocatorias"; // Asegúrate que la vista exista en templates/convocatorias/
    }

    @PostMapping
    public String create(@ModelAttribute ConvocatoriaEntity entity) {
        convocatoriaService.save(entity);
        return "redirect:/convocatorias/listarConvocatorias";
    }

    @PostMapping("/eliminarConvo/{id}")
    public String delete(@PathVariable int id) {
        convocatoriaService.delete(id);
        return "redirect:/convocatorias/listarConvocatorias";
    }
}