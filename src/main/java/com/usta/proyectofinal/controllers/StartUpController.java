package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.entities.StartupEntity;
import com.usta.proyectofinal.entities.UsuarioEntity;
import com.usta.proyectofinal.services.ConvocatoriaService;
import com.usta.proyectofinal.services.StartUpService;
import com.usta.proyectofinal.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/startups")
public class StartUpController {

    @Autowired
    private StartUpService startUpService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ConvocatoriaService convocatoriaService;

    @GetMapping("/lista")
    public String listarStartups(Model model,
                                 @RequestParam(value = "success", required = false) String success,
                                 @RequestParam(value = "error", required = false) String error) {
        List<StartupEntity> startups = startUpService.findAll();
        model.addAttribute("startups", startups);
        model.addAttribute("title", "Lista de Startups");
        model.addAttribute("urlRegistro", "/api/startups/");
        if (success != null) model.addAttribute("success", success);
        if (error != null) model.addAttribute("error", error);
        return "startups/listarStartups";
    }

    @PostMapping("/eliminarStartup/{id}")
    public String eliminarStartup(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
            startUpService.delete(id);
            redirectAttributes.addAttribute("success", "Startup eliminada correctamente.");
        } catch (Exception e) {
            redirectAttributes.addAttribute("error", "Error al eliminar la startup.");
        }
        return "redirect:/api/startups/lista";
    }

    @GetMapping("/modificar/{id}")
    public String modificarStartup(@PathVariable int id, Model model) {
        StartupEntity startup = startUpService.findById(id);
        List<ConvocatoriaEntity> convocatorias = convocatoriaService.findAll();

        model.addAttribute("title", "Modificar Startup");
        model.addAttribute("startup", startup);
        model.addAttribute("convocatorias", convocatorias);
        model.addAttribute("imagen", startup.getLogo());
        return "startups/editarStartups";
    }

    @PostMapping("/editar")
    public String editarStartup(@ModelAttribute("startup") StartupEntity startup,
                                RedirectAttributes redirectAttributes) {
        try {
            StartupEntity existente = startUpService.findById(startup.getIdStartup());

            if (existente != null) {
                existente.setNombre(startup.getNombre());
                existente.setDescripcion(startup.getDescripcion());
                existente.setSector(startup.getSector());
                existente.setLogo(startup.getLogo());
                existente.setFechaPostulacion(startup.getFechaPostulacion());
                existente.setConvocatoria(startup.getConvocatoria());

                startUpService.save(existente);
                redirectAttributes.addFlashAttribute("success", "Startup actualizada correctamente.");
            } else {
                redirectAttributes.addFlashAttribute("error", "No se encontró la startup.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error al editar la startup.");
        }

        return "redirect:/api/startups/lista";
    }

    @PostMapping("/registrar")
    public String registrarStartup(@ModelAttribute("startup") StartupEntity startup,
                                   RedirectAttributes redirectAttributes) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();

            UsuarioEntity usuarioActual = usuarioService.findByEmail(username);
            if (usuarioActual == null) {
                redirectAttributes.addFlashAttribute("error", "Usuario no encontrado.");
                return "redirect:/api/startups/";
            }

            startup.setEmprendedor(usuarioActual);
            startup.setFechaPostulacion(new Date());

            startUpService.save(startup);
            redirectAttributes.addFlashAttribute("success", "Startup registrada exitosamente");
            return "redirect:/api/startups/lista";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error al registrar la startup");
            return "redirect:/api/startups/";
        }
    }
}
