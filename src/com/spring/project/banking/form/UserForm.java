package com.spring.project.banking.form;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author lokesh & nag
 * 
 */

public class UserForm {
	// my variables

	@NotEmpty
	private String accno;
	@NotEmpty
	private String pwd;
	private int id;
	private String branch;
	private String address;
	private String contactno;
	private String emailid;
	private String accname;
	private BigDecimal bal;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getBal() {
		return bal;
	}

	public void setBal(BigDecimal bal) {
		this.bal = bal;
	}

	public String getBranch() {
		return Branch;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	private String Branch;

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
