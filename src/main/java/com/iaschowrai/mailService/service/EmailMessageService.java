package com.iaschowrai.mailService.service;

import com.iaschowrai.mailService.data.EmailMessageDto;
import com.iaschowrai.mailService.entity.EmailMessageEntity;
import com.iaschowrai.mailService.mapper.EmailMessageMapper;
import com.iaschowrai.mailService.repository.EmailMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailMessageService {
    private final EmailMessageRepository repository;
    private final EmailMessageMapper mapper;
    private final EmailMessageSenderService emailMessageSenderService;

    public void create(EmailMessageDto emailMessageDto) {
        EmailMessageEntity entity = mapper.to(emailMessageDto);

        repository.save(entity);

        emailMessageSenderService.sendEmail(emailMessageDto);

    }
}
