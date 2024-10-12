package com.iaschowrai.mailService.repository;

import com.iaschowrai.mailService.data.EmailMessageDto;
import com.iaschowrai.mailService.entity.EmailMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailMessageRepository extends JpaRepository<EmailMessageEntity, Long> {

}
