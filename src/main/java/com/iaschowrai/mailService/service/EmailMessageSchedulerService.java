package com.iaschowrai.mailService.service;

import com.iaschowrai.mailService.data.EmailMessageDto;
import com.iaschowrai.mailService.entity.EmailMessageEntity;
import com.iaschowrai.mailService.entity.EmailMessageStatus;
import com.iaschowrai.mailService.mapper.EmailMessageMapper;
import com.iaschowrai.mailService.repository.EmailMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailMessageSchedulerService {

    private final EmailMessageRepository repository;
    private final EmailMessageSenderService emailMessageSenderService;
    private final EmailMessageMapper mapper;

    @Scheduled(fixedDelay= 1000)
    public void schedule(){
        try {
            List<EmailMessageEntity> messageEntities = repository.findByStatus(EmailMessageStatus.PENDING);

            for (EmailMessageEntity entity : messageEntities) {
                entity.setStatus(EmailMessageStatus.SENDING);
                repository.save(entity);
            }

            for (EmailMessageEntity entity : messageEntities) {
                entity.setStatus(EmailMessageStatus.SENDING);

                EmailMessageDto dto = mapper.from(entity);

                try {
                    emailMessageSenderService.sendEmail(dto);
                    entity.setStatus(EmailMessageStatus.SENT);

                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    entity.setStatus(EmailMessageStatus.FAILED);
                }finally {
                    repository.save(entity);
                }
            }
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }
}
