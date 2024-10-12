package com.iaschowrai.mailService.service;

import com.iaschowrai.mailService.config.EmailProviderConfig;
import com.iaschowrai.mailService.data.EmailMessageDto;
import com.iaschowrai.mailService.exception.EmailMessageSendingException;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
@Slf4j
class EmailMessageSenderService {

    private final EmailProviderConfig emailProviderConfig;

    public void sendEmail(EmailMessageDto emailMessageDto) throws EmailMessageSendingException {
        try {
            Properties prop = new Properties();
            prop.putAll(emailProviderConfig.getProperties());

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailProviderConfig.getAuth().getUsername(), emailProviderConfig.getAuth().getPassword());
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailMessageDto.getFrom()));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailMessageDto.getTo()));
            message.setSubject(emailMessageDto.getSubject());

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(emailMessageDto.getBody(), "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);
            Transport.send(message);
        }catch (MessagingException e){
            log.error(e.getMessage(), e);
            throw new EmailMessageSendingException(e.getMessage(), e);
        }
    }
}
