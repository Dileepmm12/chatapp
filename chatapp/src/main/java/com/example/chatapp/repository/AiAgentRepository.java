package com.example.chatapp.repository;

import com.example.chatapp.entity.AiAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiAgentRepository extends JpaRepository<AiAgent, Integer> {
}
