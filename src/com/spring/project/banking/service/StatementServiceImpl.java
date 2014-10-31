package com.spring.project.banking.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.project.banking.dao.StatementDao;
import com.spring.project.banking.form.StatementForm;
import com.spring.project.banking.form.UserForm;

/**
 * @author lokesh & nag
 * 
 */
@Service("stmtservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StatementServiceImpl implements StatementService {

	@Autowired
	private StatementDao stDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<StatementForm> prepareListofBeanstmt(List<Object> stmodel) {
		List<StatementForm> stmtlist = null;
		if (stmodel != null && !stmodel.isEmpty()) {
			stmtlist = new ArrayList<StatementForm>();
			StatementForm stform = null;
			System.out.println(stmodel.toString());
			for (Object row : stmodel) {
				System.out.println(row);
				Object[] recordarray = (Object[]) row;
				stform = new StatementForm();
				stform.setAccno(recordarray[0].toString());
				stform.setAccname(recordarray[1].toString());
				stform.setCredit((BigDecimal) (recordarray[3]));
				stform.setDebit((BigDecimal) recordarray[4]);
				stform.setAmount((BigDecimal) recordarray[5]);
				stform.setTxdate(recordarray[2].toString());
				System.out.println(stform.getTxdate());
				stmtlist.add(stform);
			}
			return stmtlist;
		} else {
			return stmtlist;
		}

	}

	public List<Object> Statements(StatementForm stbean, UserForm userbean) {
		// TODO Auto-generated method stub
		List<Object> list = stDao.getStatementModels(stbean, userbean);

		return list;
	}
}
