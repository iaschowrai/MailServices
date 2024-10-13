package com.iaschowrai.mailService.repository;

import com.iaschowrai.mailService.entity.BulkEmailMessageEntity;
import com.iaschowrai.mailService.entity.EmailMessageEntity;
import com.iaschowrai.mailService.entity.EmailMessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BulkEmailMessageRepository extends JpaRepository<BulkEmailMessageEntity, Long> {


}
