package com.example.aiagents.repository;

import com.example.aiagents.entity.AiAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiAgentRepository extends JpaRepository<AiAgent, Long> {
}
