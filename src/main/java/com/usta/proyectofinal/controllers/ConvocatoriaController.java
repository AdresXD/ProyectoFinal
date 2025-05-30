package com.usta.proyectofinal.controllers;

import org.springframework.stereotype.Controller;
import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.models.dao.ConvocatoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/convocatorias")

@Controller
public class ConvocatoriaController {

        @Autowired
        private ConvocatoriaDao convocatoriaDao;

        @GetMapping
        public Iterable<ConvocatoriaEntity> getAll() {
            return convocatoriaDao.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<ConvocatoriaEntity> getById(@PathVariable int id) {
            Optional<ConvocatoriaEntity> convocatoria = convocatoriaDao.findById(id);
            return convocatoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ConvocatoriaEntity create(@RequestBody ConvocatoriaEntity entity) {
            return convocatoriaDao.save(entity);
        }

        @PutMapping("/{id}")
        public ResponseEntity<ConvocatoriaEntity> update(@PathVariable int id, @RequestBody ConvocatoriaEntity entity) {
            return convocatoriaDao.findById(id).map(existing -> {
                entity.setIdConvocatoria(id);
                return ResponseEntity.ok(convocatoriaDao.save(entity));
            }).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable int id) {
            if (convocatoriaDao.existsById(id)) {
                convocatoriaDao.deleteById(id);
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        }
    }


