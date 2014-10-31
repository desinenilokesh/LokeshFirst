package com.spring.project.banking.service;

import java.util.List;

import com.spring.project.banking.form.UserForm;
import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
public interface ForgotPassword {
	public boolean getUser(Users umodel);

	public Users prepareModelfgtpwd(UserForm userbean);

	public boolean sendmail(String password, String mail);

}
