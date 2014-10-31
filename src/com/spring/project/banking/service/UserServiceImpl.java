package com.spring.project.banking.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.banking.dao.UsersDao;
import com.spring.project.banking.form.UserForm;
import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
@Service("userservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDao uDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Users> ValidateUser(Users umodel) {
		List<Users> li = uDao.validateUser(umodel);
		return li;
	}

	@Override
	public Users prepareModelu(UserForm userbean) {

		Users u = new Users();
		System.out.println(userbean.getAccno());
		System.out.println(userbean.getPwd());
		u.setAccno(userbean.getAccno());
		u.setPwd(userbean.getPwd());
		System.out.println(u.getAccno());
		System.out.println(u.getPwd());
		return u;

	}

	public List<UserForm> prepareListofusers(List<Users> user) {
		List<UserForm> beans = null;
		if (user != null && !user.isEmpty()) {
			beans = new ArrayList<UserForm>();
			UserForm ubean = null;
			for (Users u : user) {
				ubean = new UserForm();
				ubean.setAccname(u.getAname());
				ubean.setAccno(u.getAccno());
				ubean.setAddress(u.getAddress());
				ubean.setBranch(u.getBranch());
				ubean.setContactno(u.getContactno());
				ubean.setEmailid(u.getEmailid());
				ubean.setStatus(u.getStatus());
				ubean.setId(u.getId());

				beans.add(ubean);
			}
		}
		return beans;
	}

	@Override
	public BigDecimal GetBalance(String no) {
		// TODO Auto-generated method stub

		BigDecimal f = uDao.getBalance(no);
		return f;
	}

	@Override
	public List<Users> getCustomer(String id) {
		// TODO Auto-generated method stub
		return uDao.getCustomer(id);
	}

	@Override
	public List<Users> listEmployeess() {
		// TODO Auto-generated method stub
		return uDao.listcustomeres();
	}

}
