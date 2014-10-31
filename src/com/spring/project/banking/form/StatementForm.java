package com.spring.project.banking.form;

import java.math.BigDecimal;

import org.hibernate.type.BigDecimalType;

/**
 * @author lokesh & nag
 * 
 */
public class StatementForm {

	private String fromdate;
	private String todate;
	private String accno;
	private String accname;
	private String txdate;
	private BigDecimal credit;
	private BigDecimal debit;
	private BigDecimal amount;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
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

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public String getTxdate() {
		return txdate;
	}

	public void setTxdate(String txdate) {
		this.txdate = txdate;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}
}
