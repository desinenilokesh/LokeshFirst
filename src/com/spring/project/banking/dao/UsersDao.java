package com.spring.project.banking.dao;

import java.math.BigDecimal;
import java.util.List;

import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
public interface UsersDao {
	public List<Users> validateUser(Users um);

	public BigDecimal getBalance(String s);

	public List<Users> getCustomer(String id);

	public List<Users> listcustomeres();

}
