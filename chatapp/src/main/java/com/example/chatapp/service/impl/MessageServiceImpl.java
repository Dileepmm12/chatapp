package com.example.chatapp.service.impl;

import com.example.chatapp.dto.MessageDTO;
import com.example.chatapp.entity.Message;
import com.example.chatapp.mapper.MessageMapper;
import com.example.chatapp.repository.MessageRepository;
import com.example.chatapp.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    public MessageServiceImpl(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MessageDTO> getAll() {
        return repository.findAll().stream()
                .map(MessageMapper::toDTO)
                .toList();
    }

    @Override
    public MessageDTO getById(Long id) {
        return repository.findById(id)
                .map(MessageMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Message not found with id " + id));
    }

    @Override
    public MessageDTO create(MessageDTO dto) {
        Message entity = MessageMapper.toEntity(dto);
        return MessageMapper.toDTO(repository.save(entity));
    }

    @Override
    public MessageDTO update(Long id, MessageDTO dto) {
        Message existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Message not found with id " + id));
        existing.setConversationId(dto.conversationId());
        existing.setSenderType(dto.senderType());
        existing.setSenderId(dto.senderId());
        existing.setContent(dto.content());
        existing.setMessageType(dto.messageType());
        return MessageMapper.toDTO(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
