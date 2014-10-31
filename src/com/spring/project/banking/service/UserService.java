package com.spring.project.banking.service;

import java.math.BigDecimal;
import java.util.List;

import com.spring.project.banking.form.UserForm;
import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
public interface UserService {
	public List<Users> ValidateUser(Users umodel);

	public Users prepareModelu(UserForm userbean);

	public List<UserForm> prepareListofusers(List<Users> user);

	public BigDecimal GetBalance(String no);

	public List<Users> getCustomer(String id);

	public List<Users> listEmployeess();

}
