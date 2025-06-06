package com.usta.proyectofinal.controllers;

import com.usta.proyectofinal.entities.RolEntity;
import com.usta.proyectofinal.models.dao.RolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolDao rolDao;

    @GetMapping
    public List<RolEntity> getAll() {
        return (List<RolEntity>) rolDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolEntity> getById(@PathVariable Long id) {
        Optional<RolEntity> rol = rolDao.findById(id);
        return rol.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RolEntity create(@RequestBody RolEntity entity) {
        return rolDao.save(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolEntity> update(@PathVariable Long id, @RequestBody RolEntity entity) {
        return rolDao.findById(id).map(existing -> {
            entity.setIdRol(id);
            return ResponseEntity.ok(rolDao.save(entity));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (rolDao.existsById(id)) {
            rolDao.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
