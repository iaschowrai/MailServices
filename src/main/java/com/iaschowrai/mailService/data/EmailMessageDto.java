package com.iaschowrai.mailService.data;


import lombok.Data;

@Data
public class EmailMessageDto {

    private Long id;
    private String from;
    private String to;
    private String subject;
    private String body;
}
