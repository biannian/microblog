package com.biannian.microblog.Utils;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class mailUtil {
    public static String smtp_host = "smtp.qq.com"; // 基于那个平台? 我们使用qq
    public static String username = "1124784701@qq.com"; // 邮箱 改为你的
    public static String password = "yfkycpvdrrmhjbea"; // 授权码（登录邮箱-->设置-->邮箱安全设置-->客户端授权密码），这里不是邮箱的密码，切记！
    public static String from = "1124784701@qq.com"; // 来源邮箱，改成你的账号

    /**
     * 发送邮箱方法
     * @param to 接收者邮箱
     * @param subject 邮箱内容
     * @param text 邮箱标题
     * @throws Exception
     */
    public static void sendMail(String to, String subject, String text) throws Exception {
        // 1 准备发送邮件需要的参数
        Properties props = new Properties();
        // 设置主机地址 smtp.qq.com smtp.126.com smtp.163.com
        props.put("mail.smtp.host", smtp_host);
        // 是否打开验证:只能设置true，必须打开
        props.put("mail.smtp.auth", true);
        // 2 连接邮件服务器
        Session session = Session.getDefaultInstance(props);
        // 3 创建邮件信息
        MimeMessage message = new MimeMessage(session);
        // 4 设置发送者
        InternetAddress fromAddress = new InternetAddress(from);
        message.setFrom(fromAddress);
        // 5 设置接收者
        InternetAddress toAddress = new InternetAddress(to);
        // to:直接接收者 cc：抄送 bcc暗送
        message.setRecipient(MimeMessage.RecipientType.TO, toAddress);
        // 6 设置主题
        message.setSubject(subject);
        // 7 设置正文
        message.setText(text);

        // 设置HTML方式发送
        //message.setContent(text, "text/html;charset=utf-8");

        // 8 发送:么么哒
        Transport transport = session.getTransport("smtp");// 参数不能少，表示的是发送协议
        // 登录邮箱,此处的密码是授权码
        transport.connect(username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println("邮件发送成功！"+to);
    }
}
