/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.verimov.mail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Raul
 */
public class RecoverPassword {
    
    private static final String USERNAME = "verimovilipn@gmail.com";
    private static final String PASSWORD = "ivangoyorulo";
    private static final String SUBJECT = "Recupera tu contraseña";
    private static StringBuilder sb;
    private static final Logger LOGGER = Logger.getLogger("com.ipn.verimov.mail.RecoverPassword");
    
    public static boolean enviarMail(String correoDestinatario, String Password, String name){
        boolean enviado = true;
        sb = new StringBuilder();
        sb.append("Que tal ");
        sb.append(name);
        sb.append("\n");
        sb.append("Solicito que su contraseña fuera recuperada, es la siguiente: \n\n");
        sb.append("Password: ");
        sb.append(Password);
        sb.append("\n\n\nVerimovil :)");
        //LOGGER.log(Level.INFO, correoDestinatario);
        try{
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", USERNAME);
            props.setProperty("mail.smtp.auth", "true");
            
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
            
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestinatario));
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestinatario));
            message.setSubject(SUBJECT);
            message.setText(sb.toString());
            
            Transport.send(message);
            
        }catch(MessagingException e){
            LOGGER.log(Level.WARNING, "Error al enviar correo",e);
            enviado = false;
        }
        return enviado;
    }
    
    
}
