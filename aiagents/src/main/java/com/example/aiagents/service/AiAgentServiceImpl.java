package com.example.aiagents.service;

import com.example.aiagents.dto.AiAgentDto;
import com.example.aiagents.entity.AiAgent;
import com.example.aiagents.mapper.AiAgentMapper;
import com.example.aiagents.repository.AiAgentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AiAgentServiceImpl implements AiAgentService {

    private final AiAgentRepository repository;
    private final AiAgentMapper mapper;

    // Constructor Injection
    public AiAgentServiceImpl(AiAgentRepository repository, AiAgentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<AiAgentDto> getAllAgents() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public AiAgentDto getAgentById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + id));
    }

    @Override
    public AiAgentDto createAgent(AiAgentDto dto) {
        AiAgent entity = mapper.toEntity(dto);
        AiAgent saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public AiAgentDto updateAgent(Long id, AiAgentDto dto) {
        AiAgent existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent not found with id: " + id));

        // Update fields
        existing.setCustomId(dto.getCustomId());
        existing.setWebsiteId(dto.getWebsiteId());
        existing.setLlm(dto.getLlm());
        existing.setSettings(dto.getSettings());

        AiAgent updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public void deleteAgent(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Agent not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
