package com.springboot.mail.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	public boolean sendEmail(String subject , String message , String to) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("adnanghori12@gmail.com");
		simpleMailMessage.setTo(to);
		simpleMailMessage.setText(message);
		simpleMailMessage.setSubject(subject);
		 
		javaMailSender.send(simpleMailMessage);
		System.out.println("sent");
			
		return true;
		
	}
	public void sendEmailWithAttachment(String toEmail,String body , String subject,String attachment) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		helper.setFrom("adnanghori12@gmail.com");
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body);
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		helper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
		javaMailSender.send(message);
		System.out.println("sent");
	}
	public void sendEmailWithMultipleAttachment(String toEmail,String message,String subject,File[] attachments) throws MessagingException {
		MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
		
		messageHelper.setFrom("adnanghori12@gmail.com");
		messageHelper.setTo(toEmail);
		messageHelper.setText(message);
		messageHelper.setSubject(subject);
		
		for(File file :attachments) {
			FileSystemResource fileSystemResource = new FileSystemResource(file);
			messageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		}
		this.javaMailSender.send(mimeMessage);
		System.out.println("Sent");
	}
	public void sendEmailWithAttachmentController(String toEmail,String body , String subject,MultipartFile file) throws MessagingException {
		
		
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		helper.setFrom("adnanghori12@gmail.com");
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body);
		File attachment = new File(file.getOriginalFilename());
		FileSystemResource fileSystemResource = new FileSystemResource(attachment);
		helper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
		javaMailSender.send(message);
		System.out.println("sent");
	}
	
}
