package com.spring.project.banking.dao;

import java.util.List;

import com.spring.project.banking.form.StatementForm;
import com.spring.project.banking.form.UserForm;

/**
 * @author lokesh & nag
 * 
 */
public interface StatementDao {
	public List<Object> getStatementModels(StatementForm statbean,
			UserForm userbean);
}
