package com.spring.project.banking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author lokesh & nag
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "user_data")
public class Users implements Serializable {

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	@Column(name = "id")
	private Integer id;

	@Column(name = "accno")
	private String accno;
	@NotEmpty
	@Column(name = "accname")
	private String aname;
	@NotEmpty
	@Column(name = "branch")
	private String branch;

	@NotEmpty
	@Column(name = "address")
	private String address;
	@NotEmpty
	@Column(name = "contactno")
	private String contactno;
	@NotEmpty
	@Column(name = "emailid")
	private String emailid;
	@NotEmpty
	@Column(name = "pwd")
	private String pwd;
	@NotEmpty
	@Column(name = "status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
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
