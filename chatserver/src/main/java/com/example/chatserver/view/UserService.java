package com.example.chatserver.view;

import com.example.chatserver.model.ChatDB;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;


@Service
public class UserService {//UserService class contains business logic and often interacts with the repository to fetch, insert, update, or delete data
    @Autowired
    //private ChatDB insertIntochatDB;
    private JavaMailSender mailSender;

    public UserDetails createUser(String username, String email, String password) {
        UserDetails user = new UserDetails();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        //insertIntochatDB.save(user);
        sendVerificationEmail(email, username);

        return user;
    }

    private void sendVerificationEmail(String email, String username) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject("Please verify your email");
            helper.setFrom("your-email@example.com");
            helper.setTo(email);
            String content = "<h1>Hello, " + username + "</h1>"
                    + "<p>Please verify your email by clicking the link below:</p>"
                    + "<a href=\"http://localhost:8080/verify?email=" + email + "\">Verify</a>";
            helper.setText(content, true);

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    }
