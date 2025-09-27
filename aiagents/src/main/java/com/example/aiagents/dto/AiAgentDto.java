package com.example.aiagents.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AiAgentDto {

    private Long agentId;

    @NotBlank(message = "Custom ID is required")
    private String customId;

    @NotBlank(message = "Website ID is required")
    private String websiteId;

    private String llm;

    private Map<String, Object> settings;
}
