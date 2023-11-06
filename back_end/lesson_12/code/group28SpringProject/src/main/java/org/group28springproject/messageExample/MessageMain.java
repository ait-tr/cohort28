package org.group28springproject.messageExample;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);

        Message message = context.getBean(Message.class);

        message.setMessage("This is simple message");

        System.out.println(message);
    }
}
