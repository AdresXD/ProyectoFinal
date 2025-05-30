package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.StartupEntity;
import com.usta.proyectofinal.models.dao.StartUpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/startups")

@Controller

public class StartUpController {
        @Autowired
        private StartUpDao startUpDao;

        @GetMapping
        public List<StartupEntity> getAll() {
            return (List<StartupEntity>) startUpDao.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<StartupEntity> getById(@PathVariable int id) {
            Optional<StartupEntity> startup = startUpDao.findById(id);
            return startup.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public StartupEntity create(@RequestBody StartupEntity entity) {
            return startUpDao.save(entity);
        }

        @PutMapping("/{id}")
        public ResponseEntity<StartupEntity> update(@PathVariable int id, @RequestBody StartupEntity entity) {
            return startUpDao.findById(id).map(existing -> {
                entity.setIdStartup(id);
                return ResponseEntity.ok(startUpDao.save(entity));
            }).orElseGet(() -> ResponseEntity.notFound().build());
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


