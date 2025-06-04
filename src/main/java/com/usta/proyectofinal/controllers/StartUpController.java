package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.entities.StartupEntity;
import com.usta.proyectofinal.models.dao.StartUpDao;
import com.usta.proyectofinal.services.ConvocatoriaService;
import com.usta.proyectofinal.services.StartUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/startups")

public class StartUpController {
    @Autowired
    private StartUpDao startUpDao;
    @Autowired
    private StartUpService startUpService;
    @Autowired
    private ConvocatoriaService convocatoriaService;

    @GetMapping(value = "/modificar/{id}")
    public String modificarStartup(@PathVariable int id, Model model) {
        StartupEntity startup = startUpDao.findById((long) id).orElse(null);
        model.addAttribute("title", "Modificar Startup");
        model.addAttribute("startupEdit", startup);
        model.addAttribute("imagen", startup.getLogo());
        return "startups/editarStartups";
    }

    @PostMapping(value = "/eliminarStartup/{id}")
    public String eliminarStartup(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        if (id > 0) {
            StartupEntity startup = startUpService.findById((int) id);
            if (startup != null) {
                // Suponiendo que el servicio tiene un método que devuelve convocatorias por startup
                List<ConvocatoriaEntity> convocatorias = convocatoriaService.buscarPorStartup(startup);

                if (!convocatorias.isEmpty()) {
                    redirectAttributes.addFlashAttribute("Error", "No se puede eliminar la startup porque está asociada a convocatorias.");
                    return "redirect:/startup";
                }

                startUpService.deleteById((int) id);
                redirectAttributes.addFlashAttribute("Success", "Startup eliminada correctamente.");
            } else {
                redirectAttributes.addFlashAttribute("Error", "La startup no existe.");
            }
        } else {
            redirectAttributes.addFlashAttribute("Error", "ID inválido.");
        }
        return "redirect:/startup";
    }

}