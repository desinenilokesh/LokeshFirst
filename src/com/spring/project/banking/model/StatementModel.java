package com.spring.project.banking.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author lokesh & nag
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="balance")
public class StatementModel implements Serializable{
	@Id
	@NotEmpty
	@Column(name="id")
	private long id;
	@NotEmpty
	@Column(name="u_id")
	private long u_id;

	@Column(name = "txdate")
	private String tdate;
	@NotEmpty
	@Column(name="credit")
	private BigDecimal credit;
	@NotEmpty
	@Column(name="debit")
	private BigDecimal debit;
	@NotEmpty
	@Column(name="amount")
	private BigDecimal amount;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

	

	

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	

	public BigDecimal getCredit() {
		return credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public BigDecimal getDebit() {
		return debit;
	}

	public void setDebit(BigDecimal debit) {
		this.debit = debit;
	}

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public long getU_id() {
		return u_id;
	}

	public void setU_id(long u_id) {
		this.u_id = u_id;
	}

}


