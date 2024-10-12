package com.iaschowrai.mailService.controller;

import com.iaschowrai.mailService.data.EmailMessageDto;
import com.iaschowrai.mailService.service.EmailMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email-messages")
@RequiredArgsConstructor
public class EmailMessageController {

    private final EmailMessageService emailMessageService;

    @PostMapping
    public void create(@RequestBody EmailMessageDto emailMessageDto){
        emailMessageService.create(emailMessageDto);

    }
}
