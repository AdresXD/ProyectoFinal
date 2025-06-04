package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.RolEntity;
import com.usta.proyectofinal.entities.UsuarioEntity;
import com.usta.proyectofinal.services.UsuarioService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;



    @GetMapping(value = "/usuario")
    public String usuario(Model model) {
        model.addAttribute("title", "Usuario List");
        model.addAttribute("urlRegistro", "/crearUsuario");
        List<UsuarioEntity> lista = usuarioService.findAll();
        lista.sort(Comparator.comparing(UsuarioEntity::getIdUsuario));
        model.addAttribute("usuarios", lista);
        return "usuarios/ListarUsuarios";
    }

    //****************************************
    // --------------------------------
    @PostMapping("/register")
    public String registro(@ModelAttribute("usuario") @Valid UsuarioEntity usuario,
                           BindingResult result,
                           @RequestParam("confirmarClave") String confirmarClave,
                           Model model, RedirectAttributes redirectAttributes,
                           SessionStatus status) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Register a new user");
            return "register";
        }

        //Verificación de existencia de cedula por ID
        if (usuarioService.findById(usuario.getIdUsuario()) != null) {
            result.rejectValue("idUsuario", "error.usuario", "Ya existe un usuario con esa cédula.");
            model.addAttribute("title", "Register a new user");
            return "register";
        }

        if (!usuario.getPassword().equals(confirmarClave)) {
            result.rejectValue("clave", "error.usuario", "The passwords do not match.");
            model.addAttribute("title", "Register a new User");
            return "register";
        }

        String pass = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setPassword(pass);

        RolEntity rol = new RolEntity();
        rol.setIdRol(2L);
        usuario.setRol(rol);
        usuario.setFechaRegistro(LocalDate.now());
        usuarioService.save(usuario);
        status.setComplete();
        redirectAttributes.addFlashAttribute("success", "User registered successfully!");
        return "redirect:/login";
    }

    //*****************
    @GetMapping(value = "/register")
    public String registro(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        model.addAttribute("title", "register a  new user");
        model.addAttribute("fechaRegistro", LocalDate.now());
        return "register";

    }

}

