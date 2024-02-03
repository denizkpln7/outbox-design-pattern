package com.denizkpln.outboxdesignpattern.service;

import com.denizkpln.outboxdesignpattern.model.Account;
import com.denizkpln.outboxdesignpattern.model.Outbox;
import com.denizkpln.outboxdesignpattern.repository.OutBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OutBoxService {

    private final OutBoxRepository outBoxRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public Outbox addOutBox(Account account) throws JsonProcessingException {
        return outBoxRepository.save(Outbox.builder()
                .aggregateId(String.valueOf(UUID.randomUUID()))
                .createDate(LocalDateTime.now())
                .messageType("Account Created")
                .payload(objectMapper.writeValueAsString(account))
                .aggregateType(Account.class.getName())
                .build());
    }
}
