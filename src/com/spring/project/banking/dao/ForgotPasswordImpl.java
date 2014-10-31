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
@Repository("fgtpwddao")
public class ForgotPasswordImpl implements ForgotPasswordDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	// @Override
	/* (non-Javadoc)
	 * @see com.spring.project.banking.dao.ForgotPasswordDao#forgotpassword(com.spring.project.banking.model.Users)
	 */
	public List<Users> forgotpassword(Users umodel) {
		// TODO Auto-generated method stub
	
		List<Users> list = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Users u where u.accno='" + umodel.getAccno()
								+ "' and u.aname='" + umodel.getAname() + "'")
				.list();
		return list;
	}

}
