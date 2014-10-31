package com.spring.project.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.banking.dao.EmailStatDao;
import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
@Service("emailstatservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmailStatServiceImpl implements EmailStatService {

	@Autowired
	private EmailStatDao esDao;

	public List<Users> getToMail(String accno) {
		return esDao.getToMail(accno);
	}


}
