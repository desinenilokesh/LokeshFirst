package com.spring.project.banking.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.project.banking.form.StatementForm;
import com.spring.project.banking.form.UserForm;

/**
 * @author lokesh & nag
 * 
 */
@Repository("stmtDao")
public class StatementDaoImpl implements StatementDao {

	@Autowired
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getStatementModels(StatementForm statbean,
			UserForm userbean) {

	

		String s = "SELECT USER.accno,USER.accname,bal.txdate,bal.credit,bal.debit,bal.amount FROM user_data USER JOIN balance bal ON USER.id=bal.u_id WHERE USER.accno='"
				+ userbean.getAccno()
				+ "' AND txdate BETWEEN '"
				+ statbean.getFromdate()
				+ "' AND '"
				+ statbean.getTodate()
				+ "'";
		List<Object> q = sessionFactory.getCurrentSession().createSQLQuery(s)
				.list();
	
		return q;

	}

}
