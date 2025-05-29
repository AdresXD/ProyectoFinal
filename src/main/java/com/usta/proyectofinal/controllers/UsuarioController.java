package com.usta.proyectofinal.controllers;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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


}

