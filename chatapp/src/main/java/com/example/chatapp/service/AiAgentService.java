package com.example.chatapp.service;

import com.example.chatapp.entity.AiAgent;
import com.example.chatapp.repository.AiAgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiAgentService {

    private final AiAgentRepository aiAgentRepository;

    public AiAgentService(AiAgentRepository aiAgentRepository) {
        this.aiAgentRepository = aiAgentRepository;
    }

    // Get all agents
    public List<AiAgent> getAllAgents() {
        return aiAgentRepository.findAll();
    }

    // Get agent by ID
    public AiAgent getAgentById(Integer id) {
        return aiAgentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AI Agent not found with id " + id));
    }

    // Create new agent
    public AiAgent createAgent(AiAgent aiAgent) {
        return aiAgentRepository.save(aiAgent);
    }

    // Update agent
    public AiAgent updateAgent(Integer id, AiAgent updatedAgent) {
        AiAgent agent = aiAgentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AI Agent not found with id " + id));

        agent.setCustomId(updatedAgent.getCustomId());
        agent.setWebsiteId(updatedAgent.getWebsiteId());
        agent.setLlm(updatedAgent.getLlm());
        agent.setSettings(updatedAgent.getSettings());

        return aiAgentRepository.save(agent);
    }

    // Delete agent
    public void deleteAgent(Integer id) {
        aiAgentRepository.deleteById(id);
    }
}
