package com.spring.project.banking.dao;

import java.util.List;

import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
public interface RegistrationDao {
	public int insertuser(Users um);

	public List<Users> listUsers();
}
