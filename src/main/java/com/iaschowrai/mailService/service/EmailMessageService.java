package com.iaschowrai.mailService.service;

import com.iaschowrai.mailService.data.EmailMessageDto;
import com.iaschowrai.mailService.entity.EmailMessageEntity;
import com.iaschowrai.mailService.entity.EmailMessageStatus;
import com.iaschowrai.mailService.mapper.EmailMessageMapper;
import com.iaschowrai.mailService.repository.EmailMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class EmailMessageService {
    private final EmailMessageRepository repository;
    private final EmailMessageMapper mapper;
    private final EmailMessageSenderService emailMessageSenderService;

    private final ExecutorService executorService = Executors.newFixedThreadPool(20);

    public void create(EmailMessageDto emailMessageDto) {
        EmailMessageEntity entity = mapper.to(emailMessageDto);
        entity.setStatus(EmailMessageStatus.PENDING);
        repository.save(entity);

    }
}
