package com.example.chatapp.controller;

import com.example.chatapp.entity.AgentTakeover;
import com.example.chatapp.service.AgentTakeoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agent-takeovers")
public class AgentTakeoverController {

    @Autowired
    private AgentTakeoverService service;

    // CREATE
    @PostMapping
    public ResponseEntity<AgentTakeover> createTakeover(@RequestBody AgentTakeover request) {
        if(request.getConversationId() == null || request.getToAgent() == null) {
            return ResponseEntity.badRequest().build();
        }
        AgentTakeover saved = service.save(request);
        return ResponseEntity.ok(saved);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<AgentTakeover>> getAllTakeovers() {
        return ResponseEntity.ok(service.findAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AgentTakeover> getTakeoverById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<AgentTakeover> updateTakeover(@PathVariable Long id, @RequestBody AgentTakeover request) {
        try {
            AgentTakeover updated = service.update(id, request);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTakeover(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
