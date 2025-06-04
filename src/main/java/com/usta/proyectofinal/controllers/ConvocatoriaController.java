package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.ConvocatoriaEntity;
import com.usta.proyectofinal.models.dao.ConvocatoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

        @PostMapping
        public ConvocatoriaEntity create(@RequestBody ConvocatoriaEntity entity) {
            return convocatoriaDao.save(entity);
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


