package com.example.aiagents.mapper;

import com.example.aiagents.dto.AiAgentDto;
import com.example.aiagents.entity.AiAgent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AiAgentMapper {
    AiAgentDto toDto(AiAgent entity);
    AiAgent toEntity(AiAgentDto dto);
}
