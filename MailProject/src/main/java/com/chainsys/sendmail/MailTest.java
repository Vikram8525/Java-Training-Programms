package com.chainsys.sendmail;

public class MailTest {
    public static void main(String[] args) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setName("Test User");
        orderDetails.setEmail("thiruvikramarajan@gmail.com");
        orderDetails.setAddress("123 Test St");
        orderDetails.setContact("1234567890");

        boolean emailSent = MailUtil.sendEmail(orderDetails);
        if (emailSent) {
            System.out.println("Email sent successfully.");
        } else {
            System.out.println("Failed to send email.");
        }
    }
}
