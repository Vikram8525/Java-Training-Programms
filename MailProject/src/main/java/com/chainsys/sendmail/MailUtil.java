package com.chainsys.sendmail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
    public static boolean sendEmail(OrderDetails orderDetails) {
        final String username = "osonlineshopping614@gmail.com";
        final String password = "eaer hvch jsje qspy";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(orderDetails.getEmail()));
            message.setSubject("Order Confirmation");
            message.setText("Dear " + orderDetails.getName() + ",\n\nYour order has been placed successfully!\n\nDetails:\nAddress: " + orderDetails.getAddress() + "\nContact: " + orderDetails.getContact() + "\n\nThank you for your order!");

            Transport.send(message);

            return true;
        } catch (MessagingException e) {
            // Print the stack trace for debugging
            e.printStackTrace();
            // Return false indicating the email was not sent
            return false;
        }
    }
}
