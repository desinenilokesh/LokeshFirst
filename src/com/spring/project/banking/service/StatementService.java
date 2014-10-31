package com.spring.project.banking.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.project.banking.form.StatementForm;
import com.spring.project.banking.form.UserForm;

/**
 * @author lokesh & nag
 * 
 */
public interface StatementService {
	public List<Object> Statements(StatementForm stbean, UserForm userbean);

	public List<StatementForm> prepareListofBeanstmt(List<Object> stmodel);
}
