package com.example.aiagents.controller;

import com.example.aiagents.dto.AiAgentDto;
import com.example.aiagents.service.AiAgentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AiAgentController {

    private final AiAgentService service;

    public AiAgentController(AiAgentService service) {
        this.service = service;
    }

    // ------------------------
    // CREATE
    // POST /api/agents
    // ------------------------
    @PostMapping
    public ResponseEntity<AiAgentDto> createAgent(@Valid @RequestBody AiAgentDto dto) {
        AiAgentDto created = service.createAgent(dto);
        return ResponseEntity.ok(created);
    }

    // ------------------------
    // READ ALL
    // GET /api/agents
    // ------------------------
    @GetMapping
    public ResponseEntity<List<AiAgentDto>> getAllAgents() {
        return ResponseEntity.ok(service.getAllAgents());
    }

    // ------------------------
    // READ BY ID
    // GET /api/agents/{id}
    // ------------------------
    @GetMapping("/{id}")
    public ResponseEntity<AiAgentDto> getAgentById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAgentById(id));
    }

    // ------------------------
    // UPDATE
    // PUT /api/agents/{id}
    // ------------------------
    @PutMapping("/{id}")
    public ResponseEntity<AiAgentDto> updateAgent(
            @PathVariable Long id,
            @Valid @RequestBody AiAgentDto dto) {
        AiAgentDto updated = service.updateAgent(id, dto);
        return ResponseEntity.ok(updated);
    }

    // ------------------------
    // DELETE
    // DELETE /api/agents/{id}
    // ------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Long id) {
        service.deleteAgent(id);
        return ResponseEntity.noContent().build();
    }
}
