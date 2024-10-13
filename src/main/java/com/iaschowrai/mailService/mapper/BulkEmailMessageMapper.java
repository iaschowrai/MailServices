package com.iaschowrai.mailService.mapper;

import com.iaschowrai.mailService.data.BulkEmailMessageDto;
import com.iaschowrai.mailService.data.EmailMessageDto;
import com.iaschowrai.mailService.entity.BulkEmailMessageEntity;
import com.iaschowrai.mailService.entity.EmailMessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BulkEmailMessageMapper {

     BulkEmailMessageDto from(BulkEmailMessageEntity entity);

     BulkEmailMessageEntity to(BulkEmailMessageDto entity);
}

