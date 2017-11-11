/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.pattern;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author vinicius caetano
 */
public class JavaMailApp {

    public static void main(String[] args) {

        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587"); //587
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587"); //465

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("livrariatreebu@gmail.com", "xxxxxxx");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vinicin15@gmail.com")); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse("vinicin15@gmail.com");

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Enviando email testando o JavaMail");//Assunto
            message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            System.out.println("erro Exception "+e.getMessage());
            throw new RuntimeException(e);
            
        }
    }

}
