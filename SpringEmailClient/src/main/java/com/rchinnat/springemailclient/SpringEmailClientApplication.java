package com.rchinnat.springemailclient;

import java.util.Date;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling //conditionalOnProperties annotation to enable on Condition
public class SpringEmailClientApplication {
	
	Logger logger = LoggerFactory.getLogger(SpringEmailClientApplication.class);

	@Autowired
	private EmailSenderService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		//service.sendSimpleEmail("rajprakashcr@gmail.com", "This is the Email Body", "This is the Email Subject.. RAJP");
		//service.sendEmailWithAttachment("rajprakashcr@gmail.com", "This is Email Body with Attachment...", "Mail Subject:This email has attachment...", "C:\\Users\\chinn\\Downloads\\RENTAL AGREEMENT.docx");
	}
	
	//spring.task.scheduling.pool.size
	@Scheduled(fixedRate = 2000L)
	public void job() {
		logger.info("Job Current Time: " + new Date());
	}
}
