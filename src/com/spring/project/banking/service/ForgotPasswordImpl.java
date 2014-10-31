package com.spring.project.banking.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.banking.dao.ForgotPasswordDao;
import com.spring.project.banking.form.UserForm;
import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
@Service("fgtpwdservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ForgotPasswordImpl implements ForgotPassword {
	private static final Authenticator MimeMessage = null;
	@Autowired
	private ForgotPasswordDao fgtpwdDao;

	@Override
	public boolean getUser(Users umodel) {
		List<Users> li = (List<Users>) fgtpwdDao.forgotpassword(umodel);
		String mail = "";
		String password = "";
		UserForm userbean = new UserForm();
		if (!li.isEmpty()) {
			for (Users u : li) {
				userbean.setPwd(u.getPwd());
				userbean.setEmailid(u.getEmailid());
			}
			password = userbean.getPwd();
			mail = userbean.getEmailid();
			boolean b = sendmail(password, mail);
			;
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Users prepareModelfgtpwd(UserForm userbean) {

		Users u = new Users();

		u.setAccno(userbean.getAccno());
		u.setAname(userbean.getAccname());
		

		return u;

	}

	@Override
	public boolean sendmail(String password, String email) {

		try {

			final String a = "Desineni@6282";

			String to = "lokesh.desineni@valuelabs.net";
			String from = "lokesh.desineni@valuelabs.net";
			String host = "localhost";
			Properties properties = System.getProperties();
			properties.setProperty("mx.valuelabs.net", host);
			properties.put("mail.smtp.host", "mx.valuelabs.net");
			properties.put("mail.smtp.user", "lokesh.desineni@valuelabs.net"); // User
																				// name
			properties.put("mail.smtp.password", "Desineni@6282"); // password
			properties.put("mx.valuelabs.net", "25");
			properties.put("mx.valuelabs.net", "true");
			Session session = Session.getInstance(properties,
					new javax.mail.Authenticator() {
						protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
							return new javax.mail.PasswordAuthentication(
									"lokesh.desineni", a);
						}
					});

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.setSubject("Password recovery");
			message.setText("your password is" + password);
			Transport.send(message);
			
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

}
