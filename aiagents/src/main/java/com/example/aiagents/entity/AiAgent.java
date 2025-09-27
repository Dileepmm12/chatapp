package com.example.aiagents.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Map;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "ai_agents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AiAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    @Column(nullable = false, length = 100)
    private String customId;

    @Column(nullable = false, length = 100)
    private String websiteId;

    private String llm;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Map<String, Object> settings;
}
