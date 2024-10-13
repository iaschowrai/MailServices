package com.iaschowrai.mailService.controller;

import com.iaschowrai.mailService.data.BulkEmailMessageDto;
import com.iaschowrai.mailService.service.BulkEmailMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bulk-email-messages")
@RequiredArgsConstructor
public class BulkEmailMessageController {

    private final BulkEmailMessageService bulkemailMessageService;

    @PostMapping
    public void create(@RequestBody BulkEmailMessageDto bulkEmailMessageDto){
        bulkemailMessageService.create(bulkEmailMessageDto);

    }
}
