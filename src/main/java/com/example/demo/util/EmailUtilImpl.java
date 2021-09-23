package com.example.demo.util;

import com.example.demo.exceptions.ChartVException;
import com.example.demo.messages.ResponseMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;


@Component
public class EmailUtilImpl implements com.example.demo.util.EmailUtil {
	
	@Autowired
	private JavaMailSender sender;

	@Override
	public void sendEmail(String ToAddress, String subject, String body) throws ChartVException {
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setTo(ToAddress);
			helper.setSubject(subject);
			helper.setText(body);
			
		} catch (Exception e) {
			throw new ChartVException(ResponseMessages.UNEXPECTED_ERROR, e.getCause());
		}
		sender.send(message);

	}

}
