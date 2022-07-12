package com.example.demo;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class Mail {
    private String password;
    private String username;
    private String recipient;
    private String sender;
    private String image;
    private String location;
    private String description;


    public Mail(String recipient, String sender, String image, String location, String description) {
        this.recipient = recipient;
        this.sender = sender;
        this.image = image;
        this.location = location;
        this.description = description;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void sendEmail() {
        String to = recipient;
        MailContent mailContent = new MailContent(this.location, this.image, this.description);
        mailContent.generateHTMLContent();

        // Sender's email ID needs to be mentioned
        String from = sender;

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();


        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("claimyourawesomereward@gmail.com", "xatbpxeqtujnckgn");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Free Reward");

            // Now set the actual message
            message.setText("This is actual message");
            message.setContent(mailContent.getMailContent(), "text/html");
            //message.setContent("<h1>This is actual message embedded in HTML tags</h1>" +
                            //this.image, "text/html");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}




