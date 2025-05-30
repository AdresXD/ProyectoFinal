package com.usta.proyectofinal.controllers;

import org.springframework.stereotype.Controller;


import com.usta.proyectofinal.entities.ApoyoEntity;
import com.usta.proyectofinal.models.dao.ApoyoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/apoyo")

@Controller

public class ApoyoController {


    @Autowired
    private ApoyoDao apoyoDao;

    @GetMapping
    public Iterable<ApoyoEntity> getAll() {
        return apoyoDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApoyoEntity> getById(@PathVariable int id) {
        Optional<ApoyoEntity> apoyo = apoyoDao.findById(id);
        return apoyo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ApoyoEntity create(@RequestBody ApoyoEntity apoyoEntity) {
        return apoyoDao.save(apoyoEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApoyoEntity> update(@PathVariable int id, @RequestBody ApoyoEntity updatedApoyo) {
        return apoyoDao.findById(id).map(apoyo -> {
            updatedApoyo.setIdApoyo(id); // Asegúrate de tener el método setId
            return ResponseEntity.ok(apoyoDao.save(updatedApoyo));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (apoyoDao.existsById(id)) {
            apoyoDao.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
