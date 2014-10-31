package com.spring.project.banking.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
@Repository("userdao")
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Users> validateUser(Users umodel) {

		List<Users> list = sessionFactory.getCurrentSession()
				.createCriteria(Users.class)
				.add(Restrictions.eq("accno", umodel.getAccno()))
				.add(Restrictions.eq("pwd", umodel.getPwd())).list();
		return list;
	}

	public BigDecimal getBalance(String no) {

		String s = "SELECT b.amount FROM balance b,user_data u  WHERE u.id=b.u_id and  u.accno='"
				+ no + "' ORDER BY b.amount ASC LIMIT 0,1";
		List<BigDecimal> q = sessionFactory.getCurrentSession()
				.createSQLQuery(s).list();
		BigDecimal b = null;
		for (BigDecimal sm : q) {
			b = sm;
			System.out.println(sm);
		}
		return b;

	}

	@Override
	public List<Users> getCustomer(String id) {
		// TODO Auto-generated method stub
		String s = "pending";
		List<Users> li = sessionFactory.getCurrentSession()
				.createCriteria(Users.class).add(Restrictions.eq("status", s))
				.list();
		return li;

	}

	@Override
	public List<Users> listcustomeres() {
		// TODO Auto-generated method stub
		return (List<Users>) ((Users) sessionFactory.getCurrentSession()
				.createQuery("From Users u where u.status='pending'"));
	}

}
