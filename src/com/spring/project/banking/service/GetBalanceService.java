package com.spring.project.banking.service;

import java.util.List;

import com.spring.project.banking.form.UserForm;
import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
public interface GetBalanceService {
	public List<Users> GetBalance(Users umodel);

	public Users prepareModelu(UserForm userbean);

}
