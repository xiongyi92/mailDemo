package util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author hw
 */
public class SendEmailByVVY {


    public static void sendEmail(String to,String content) throws MessagingException {
        //创建连接对象
        Properties  props=new Properties();
        //设置邮件发送的协议
        props.put("mail.transport.protocol","smtp");
        //设置发送邮件的服务器
        props.put("mail.smtp.host","smtp.163.com");
        //需要经过授权，才能通过验证
        props.put("mail.smtp.auth", "true");
        //使用465端口发送
        props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback" , "false");
        props.setProperty("mail.smtp.port" , "465");
        props.setProperty("mail.smtp.socketFactory.port" , "465");
        //认证信息
        Session session=Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("13544319724@163.com","19951230xy");
            }
        });

        //创建邮件对象
        Message message=new MimeMessage(session);

        //设置发件人
        message.setFrom(new InternetAddress("13544319724@163.com"));

        //设置收件人
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        //设置抄送者
        message.setRecipient(Message.RecipientType.CC,new InternetAddress("13544319724@163.com"));
        //设置邮件的主题
        message.setSubject("主题");
        //设置邮件的内容
        message.setContent(content,"text/html;charset=utf-8");
        //发送邮件
        Transport.send(message);


    }



}
