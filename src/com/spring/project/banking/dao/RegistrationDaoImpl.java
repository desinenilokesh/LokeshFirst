package com.spring.project.banking.dao;

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
@Repository("regdao")
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	private SessionFactory sessionFactory;



	@Override
	public int insertuser(Users um) {
		// TODO Auto-generated method stub
		try {

			System.out.println(um.getPwd());
			String s = "insert into  user_data(accno,accname,branch,address,contactno,emailid,pwd,status) values('"
					+ um.getAccno()
					+ "','"
					+ um.getAname()
					+ "','"
					+ um.getBranch()
					+ "','"
					+ um.getAddress()
					+ "','"
					+ um.getContactno()
					+ "','"
					+ um.getEmailid()
					+ "','"
					+ um.getPwd() + "','" + um.getStatus() + "')";
			int count = sessionFactory.getCurrentSession().createSQLQuery(s)
					.executeUpdate();
			// sessionFactory.getCurrentSession().saveOrUpdate(um);
			System.out.println("in dao");
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<Users> listUsers() {
		// TODO Auto-generated method stub
		List<Users> li = sessionFactory.getCurrentSession()
				.createCriteria(Users.class)
				.add(Restrictions.eq("status", "pending")).list();
		System.out.println(li);
		return li;
		// return null;
	}

}
