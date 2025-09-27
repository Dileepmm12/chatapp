package com.example.chatapp.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@Table(name = "ai_agents")
public class AiAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agentId;

    @Column(nullable = false)
    private String customId;

    @Column(nullable = false)
    private String websiteId;

    private String llm;

    @JdbcTypeCode(SqlTypes.JSON)  // ✅ Fix JSON mapping for Hibernate 6
    @Column(columnDefinition = "json")
    private JsonNode settings;
}
