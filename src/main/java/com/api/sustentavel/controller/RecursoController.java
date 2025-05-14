package com.api.sustentavel.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {
    @GetMapping
    public ResponseEntity<?> listarRecursos() {
        Map<String, String> response = new HashMap<>();
        response.put("mensagem", "Lista de recursos disponível para usuários autenticados");
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> criarRecurso() {
        Map<String, String> response = new HashMap<>();
        response.put("mensagem", "Recurso criado com sucesso - apenas ADMIN");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> atualizarRecurso(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("mensagem", "Recurso " + id + " atualizado com sucesso - apenas ADMIN");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> excluirRecurso(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("mensagem", "Recurso " + id + " excluído com sucesso - apenas ADMIN");
        return ResponseEntity.ok(response);
    }
}
