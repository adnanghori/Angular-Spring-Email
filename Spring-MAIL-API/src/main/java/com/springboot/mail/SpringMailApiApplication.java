package com.springboot.mail;

import java.io.File;
import java.io.FileNotFoundException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.springboot.mail.service.EmailService;

@SpringBootApplication
public class SpringMailApiApplication {
	@Autowired
	private EmailService emailService;
	public static void main(String[] args) {
		SpringApplication.run(SpringMailApiApplication.class, args);
	}

	// If not using postman
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException,FileNotFoundException {
		//this.emailService.sendEmail("this is subject", "this is message", "vedantkachwaha1@gmail.com");
		
		//this.emailService.sendEmailWithAttachment("vedantkachwaha1@gmail.com", "this is email with attachment", "this is subject", "/Users/adnanghori/Documents/IMG20220622114905.jpg");
//		File file_1 = new File("/Users/adnanghori/Documents/IMG20220622114905.jpg");
//		File file_2 = new File("/Users/adnanghori/Documents/Adnan_Resume_.pdf"); 
//		File [] files = new File[] {file_1,file_2};
//		this.emailService.sendEmailWithMultipleAttachment("vedantkachwaha1@gmail.com", "this is message", "this is subject", files);
	}
}
