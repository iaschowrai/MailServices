package com.iaschowrai.mailService.service;

import com.iaschowrai.mailService.data.BulkEmailMessageDto;
import com.iaschowrai.mailService.data.EmailMessageDto;
import com.iaschowrai.mailService.entity.BulkEmailMessageEntity;
import com.iaschowrai.mailService.mapper.BulkEmailMessageMapper;
import com.iaschowrai.mailService.repository.BulkEmailMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BulkEmailMessageService {
    private final BulkEmailMessageRepository repository;
    private final BulkEmailMessageMapper mapper;
    private final EmailMessageSenderService emailMessageSenderService;

    private final EmailMessageService emailMessageService;

    public void create(BulkEmailMessageDto bulkEmailMessageDto) {

        BulkEmailMessageEntity entity = mapper.to(bulkEmailMessageDto);
        repository.save(entity);

        for (String to : bulkEmailMessageDto.getTo()) {
            EmailMessageDto emailMessageDto = new EmailMessageDto();
            emailMessageDto.setFrom(bulkEmailMessageDto.getFrom());
            emailMessageDto.setTo(to);
            emailMessageDto.setSubject(bulkEmailMessageDto.getSubject());
            emailMessageDto.setBody(bulkEmailMessageDto.getBody());

            emailMessageService.create(emailMessageDto);
        }
    }


}
