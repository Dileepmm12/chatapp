package com.example.chatapp.mapper;

import com.example.chatapp.dto.MessageDTO;
import com.example.chatapp.entity.Message;

import java.time.LocalDateTime;

public class MessageMapper {

    public static MessageDTO toDTO(Message entity) {
        return new MessageDTO(
                entity.getMessageId(),
                entity.getConversationId(),
                entity.getSenderType(),
                entity.getSenderId(),
                entity.getContent(),
                entity.getMessageType()
        );
    }

    public static Message toEntity(MessageDTO dto) {
        return Message.builder()
                .messageId(dto.messageId())
                .conversationId(dto.conversationId())
                .senderType(dto.senderType())
                .senderId(dto.senderId())
                .content(dto.content())
                .messageType(dto.messageType())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
