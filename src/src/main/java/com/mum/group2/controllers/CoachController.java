package com.mum.group2.controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mum.group2.EmailUtil;
import com.mum.group2.domain.Role;
import com.mum.group2.domain.User;
import com.mum.group2.services.UserService;

@Controller
@RequestMapping("/coach")
public class CoachController {
	@Autowired
	UserService userService;
	
	 public static String generateKey(String s) throws NoSuchAlgorithmException
	    {

	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(s.getBytes());

	        byte byteData[] = md.digest();

	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }

	         
	        
	        return sb.toString();
	       
	    }
	 
	 @RequestMapping(value = "/generateKey/{id}", method = RequestMethod.GET)
		
		public @ResponseBody String setKey(@PathVariable("id") String s) throws NoSuchAlgorithmException {
			
			
		 	String s1 = generateKey(s);
		 	System.out.println(s1);
		 	return s1;
			  
		}
	 
	 @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
		public String sendEmail(Model model) {
		 
		 final String fromEmail = "govinda.pandeya1987@gmail.com"; //requires valid gmail id
			final String password = "roshani1234"; // correct password for gmail id
			final String toEmail = "ashish.nembang@gmail.com"; // can be any email id 
			
			System.out.println("TLSEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			
	                //create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			System.out.println("Email sent");
			
			EmailUtil.sendEmail(session, toEmail,"Student Access Id and URL", "Student Access Id: 436c28de357796000a92752205d8229b \nexam url: Localhost:8080/group2/startTest"
					+ "\nThis mail is sent to verify whether the system is working or not"
					+ "\nThank you"
					+ "\nGovinda Pandeya");
			return "Emailsent";
		}

}
