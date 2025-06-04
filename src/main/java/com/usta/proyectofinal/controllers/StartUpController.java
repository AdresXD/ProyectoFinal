package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.StartupEntity;
import com.usta.proyectofinal.models.dao.StartUpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/startups")

public class StartUpController {
        @Autowired
        private StartUpDao startUpDao;

        @GetMapping
        public List<StartupEntity> getAll() {
            return (List<StartupEntity>) startUpDao.findAll();
        }

        @PostMapping
        public StartupEntity create(@RequestBody StartupEntity entity) {
            return startUpDao.save(entity);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable int id) {
            if (startUpDao.existsById(id)) {
                startUpDao.deleteById(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }
    }


