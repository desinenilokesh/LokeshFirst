package com.spring.project.banking.dao;

import java.util.List;

import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
public interface ForgotPasswordDao {

	public List<Users> forgotpassword(Users Umodel);

}
