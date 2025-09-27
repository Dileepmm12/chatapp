package com.example.chatapp.controller;

import com.example.chatapp.entity.Conversation;
import com.example.chatapp.repository.ConversationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    private final ConversationRepository conversationRepository;

    public ConversationController(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    // Get all conversations
    @GetMapping
    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

    // Get conversation by id
    @GetMapping("/{id}")
    public Conversation getConversationById(@PathVariable Long id) {
        return conversationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conversation not found with id " + id));
    }

    // Create a new conversation
    @PostMapping
    public Conversation createConversation(@RequestBody Conversation conversation) {
        return conversationRepository.save(conversation);
    }

    // Update conversation status
    @PutMapping("/{id}/status")
    public Conversation updateStatus(@PathVariable Long id, @RequestParam Conversation.Status status) {
        Conversation conversation = conversationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conversation not found with id " + id));
        conversation.setStatus(status);
        return conversationRepository.save(conversation);
    }

    // Delete conversation
    @DeleteMapping("/{id}")
    public String deleteConversation(@PathVariable Long id) {
        conversationRepository.deleteById(id);
        return "Conversation deleted with id " + id;
    }
}
