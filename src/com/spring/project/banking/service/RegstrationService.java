package com.spring.project.banking.service;

import java.util.List;

import com.spring.project.banking.form.RegistrationForm;
import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
public interface RegstrationService {
	public int insertusers(Users regmodel);

	public Users prepareModelreg(RegistrationForm regbean);

	public List<Users> listEmployeess();
}
