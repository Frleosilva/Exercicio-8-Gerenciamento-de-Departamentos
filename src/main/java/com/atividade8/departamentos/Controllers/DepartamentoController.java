package com.atividade8.departamentos.Controllers;

import com.atividade8.departamentos.Models.DepartamentoModel;
import com.atividade8.departamentos.Services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoModel> create(@RequestBody DepartamentoModel departamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoService.save(departamento));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> getAll() {
        return ResponseEntity.ok(departamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoModel> getById(@PathVariable Long id) {
        return departamentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (departamentoService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        departamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}