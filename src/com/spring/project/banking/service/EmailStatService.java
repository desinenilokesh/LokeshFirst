package com.spring.project.banking.service;

import java.util.List;

import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
public interface EmailStatService {

	public List<Users> getToMail(String accno);

}
