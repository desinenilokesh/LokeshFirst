package com.spring.project.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.banking.dao.RegistrationDao;
import com.spring.project.banking.form.RegistrationForm;
import com.spring.project.banking.model.Users;

/**
 * @author lokesh & nag
 * 
 */
@Service("regservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RegistrationServiceImpl implements RegstrationService {

	@Autowired
	private RegistrationDao regDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Users prepareModelreg(RegistrationForm regbean) {
		System.out.println("in prepare model");
		Users u = new Users();
		System.out.println(regbean.getAccno());
		System.out.println(regbean.getPassword());
		u.setAccno(regbean.getAccno());
		u.setPwd(regbean.getPassword());
		u.setAname(regbean.getAccname());
		u.setBranch(regbean.getBranch());
		u.setAddress(regbean.getAddress());
		u.setContactno(regbean.getContactno());
		u.setEmailid(regbean.getMailid());
		u.setStatus("pending");

		System.out.println(u.getAccno());
		System.out.println(u.getPwd());
		return u;

	}

	@Override
	public int insertusers(Users regmodel) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		int i = regDao.insertuser(regmodel);
		return i;

	}

	@Override
	public List<Users> listEmployeess() {
		// TODO Auto-generated method stub
		return regDao.listUsers();

	}

}
