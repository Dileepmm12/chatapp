package com.example.chatapp.repository;

import com.example.chatapp.entity.AgentTakeover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentTakeoverRepository extends JpaRepository<AgentTakeover, Long> {
}
