package org.demointernetshop.services.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DemoInternetMailSender {

    private final JavaMailSender javaMailSender;

    @Async
    public void send(String email, String subject, String text) {

        MimeMessage message = javaMailSender.createMimeMessage(); // создаем сообщение
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8"); // создаем обертку для удобства работы

        try {
            // наполняем данными письмо которое хотим отправить
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(text, true);
        } catch (MessagingException e) {
            throw new IllegalStateException(e);
        }

        // отправить письмо
        javaMailSender.send(message);

    }
}
