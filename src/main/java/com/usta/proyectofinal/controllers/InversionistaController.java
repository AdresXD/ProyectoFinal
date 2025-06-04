package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.InversionistaEntity;
import com.usta.proyectofinal.models.dao.InversionistaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/inversionistas")

@Controller

public class InversionistaController {
        @Autowired
        private InversionistaDao inversionistaDao;

        @GetMapping
        public Iterable<InversionistaEntity> getAll() {
            return inversionistaDao.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<InversionistaEntity> getById(@PathVariable int id) {
            Optional<InversionistaEntity> inversionista = inversionistaDao.findById(id);
            return inversionista.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public InversionistaEntity create(@RequestBody InversionistaEntity entity) {
            return inversionistaDao.save(entity);
        }

        @PutMapping("/{id}")
        public ResponseEntity<InversionistaEntity> update(@PathVariable int id, @RequestBody InversionistaEntity entity) {
            return inversionistaDao.findById(id).map(existing -> {
                entity.setIdInversionista(id);
                return ResponseEntity.ok(inversionistaDao.save(entity));
            }).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable int id) {
            if (inversionistaDao.existsById(id)) {
                inversionistaDao.deleteById(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }
    }


