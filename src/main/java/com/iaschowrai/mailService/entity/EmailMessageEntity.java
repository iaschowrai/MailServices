package com.iaschowrai.mailService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmailMessageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "\"from\"")
    private String from;

    @Column(name = "\"to\"")
    private String to;
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Enumerated(EnumType.STRING)
    private EmailMessageStatus status;
}
