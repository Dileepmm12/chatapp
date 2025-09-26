package com.example.chatapp.service;

import com.example.chatapp.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getAll();
    MessageDTO getById(Long id);
    MessageDTO create(MessageDTO dto);
    MessageDTO update(Long id, MessageDTO dto);
    void delete(Long id);
}
