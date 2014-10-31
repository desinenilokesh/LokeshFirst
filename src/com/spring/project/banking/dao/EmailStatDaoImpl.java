package com.spring.project.banking.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
@Repository("emailstatdao")
public class EmailStatDaoImpl implements EmailStatDao {

	@Autowired
	private SessionFactory sessionFactory;



	public List<Users> getToMail(String accno) {
		List<Users> list = sessionFactory.getCurrentSession().createQuery("from Users u where u.accno='" + accno + "'").list();
		return list;
	}

	
}
