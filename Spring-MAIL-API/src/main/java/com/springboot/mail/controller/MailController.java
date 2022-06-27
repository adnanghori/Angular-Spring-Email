package com.springboot.mail.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.mail.model.EmailRequest;
import com.springboot.mail.model.EmailResponse;
import com.springboot.mail.service.EmailService;

@RestController
@CrossOrigin
public class MailController {
	@Autowired
	private EmailService emailService;
		@GetMapping("/")
		public String hello() {
			return "welcome to MAIL API";
		}
		
		@PostMapping("/sendEmail")
		public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest){
		
				this.emailService.sendEmail(emailRequest.getSubject(), emailRequest.getMessage(), emailRequest.getTo());
				System.out.println(emailRequest); 
				//return ResponseEntity.ok("done");
				
				// this convert object to json
				return ResponseEntity.ok(new EmailResponse("Success"));
		}
		@PostMapping("/sendEmailAttachment")
		public ResponseEntity<?> sendEmailWithAttachment(@RequestParam("attachment") MultipartFile file,@RequestBody EmailRequest emailRequest) throws MessagingException{
			
				//this.emailService.sendEmailWithAttachmentController(emailRequest.getTo(), emailRequest.getMessage(), emailRequest.getSubject(), file);
			System.out.println(emailRequest);
			
			
			return ResponseEntity.ok("done"); 
		}
}
	