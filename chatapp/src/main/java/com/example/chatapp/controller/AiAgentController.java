package com.example.chatapp.controller;

import com.example.chatapp.entity.AiAgent;
import com.example.chatapp.service.AiAgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai-agents")
public class AiAgentController {

    private final AiAgentService aiAgentService;

    public AiAgentController(AiAgentService aiAgentService) {
        this.aiAgentService = aiAgentService;
    }

    // Get all agents
    @GetMapping
    public List<AiAgent> getAllAgents() {
        return aiAgentService.getAllAgents();
    }

    // Get agent by ID
    @GetMapping("/{id}")
    public AiAgent getAgentById(@PathVariable Integer id) {
        return aiAgentService.getAgentById(id);
    }

    // Create new agent
    @PostMapping
    public AiAgent createAgent(@RequestBody AiAgent aiAgent) {
        return aiAgentService.createAgent(aiAgent);
    }

    // Update agent
    @PutMapping("/{id}")
    public AiAgent updateAgent(@PathVariable Integer id, @RequestBody AiAgent updatedAgent) {
        return aiAgentService.updateAgent(id, updatedAgent);
    }

    // Delete agent
    @DeleteMapping("/{id}")
    public String deleteAgent(@PathVariable Integer id) {
        aiAgentService.deleteAgent(id);
        return "AI Agent deleted with id " + id;
    }
}
