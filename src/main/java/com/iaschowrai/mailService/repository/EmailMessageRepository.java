package com.iaschowrai.mailService.repository;

import com.iaschowrai.mailService.data.EmailMessageDto;
import com.iaschowrai.mailService.entity.EmailMessageEntity;
import com.iaschowrai.mailService.entity.EmailMessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailMessageRepository extends JpaRepository<EmailMessageEntity, Long> {

    List<EmailMessageEntity> findByStatus(EmailMessageStatus emailMessageStatus);
}
