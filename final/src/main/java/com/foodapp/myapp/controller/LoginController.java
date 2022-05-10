package com.foodapp.myapp.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.foodapp.myapp.dao.UserDao;
import com.foodapp.myapp.pojo.User;
import com.foodapp.myapp.validator.UserValidator;


@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
  
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    UserValidator validator;
	
	@RequestMapping(value = "/signup.htm", method = RequestMethod.POST)
	public String login(HttpServletRequest request, UserDao userdao,ModelMap model, User user,HttpSession httpsession) throws Exception {
		
		HttpSession session = request.getSession();
		String userName = request.getParameter("uname");
		String userPassword = request.getParameter("upass");

		try {

		User userinfo = userdao.searchUser(userName);	
  
		boolean isPasswordMatches = passwordEncoder.matches(userPassword, userinfo.getPassword());	
			if (userinfo != null && isPasswordMatches) {
				System.out.println("Login successful");
				httpsession.setAttribute("user",userinfo);
				model.addAttribute("user", user);
				System.out.println(httpsession.getId());
				return "timeline";
			}	

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "error";
	}
	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String signup(@ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDao userdao) {
		validator.validate(user, result);
		if(result.hasErrors())
		{
			System.out.print("Please check firstname and lastname");
			return "redirect:loggedout.htm";
		}
		else {
		
		 user.setPassword(passwordEncoder.encode( user.getPassword()));
		 String userName = user.getEmail();
		 boolean mailUser = sendEmail(userName);
		 try {
			User userinfo = userdao.searchUser(userName);
			 if (userinfo == null) {
					userdao.save(user);   
					status.setComplete(); 
					return "redirect:loggedout.htm";
					 }
			 else {
				 System.out.print("User already present in the database");
				 
			 }
		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		status.setComplete(); 
		return "error";
	}
	
	private boolean sendEmail(String userName) {
		String username = "webtoolsemail@gmail.com";
		String password  = "webtools@2022";


		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");


		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("webtoolsemail@gmail.com"));
			message.setRecipients(
					Message.RecipientType.TO, InternetAddress.parse(userName));
			message.setSubject("Welcome to Yumm App");

			String msg = "Thank you for registerng with us please login using your credentials"  ;

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart);

			Transport.send(message);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		
	}


	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logout(HttpSession httpsession,HttpServletRequest request)
	{ 
		HttpSession session = request.getSession(true);
		session.invalidate();
		return "redirect:loggedout.htm";
	}

}
