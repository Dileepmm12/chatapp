package com.example.aiagents.service;

import com.example.aiagents.dto.AiAgentDto;
import java.util.List;

public interface AiAgentService {
    List<AiAgentDto> getAllAgents();
    AiAgentDto getAgentById(Long id);
    AiAgentDto createAgent(AiAgentDto dto);
    AiAgentDto updateAgent(Long id, AiAgentDto dto);
    void deleteAgent(Long id);
}
