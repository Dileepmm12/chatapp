package com.example.chatapp.repository;

import com.example.chatapp.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    List<Conversation> findByStatus(String status);
    List<Conversation> findByCustomerId(Long customerId);
}
