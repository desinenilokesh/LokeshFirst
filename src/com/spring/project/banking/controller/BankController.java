package com.spring.project.banking.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import jxl.write.WriteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.project.banking.form.RegistrationForm;
import com.spring.project.banking.form.StatementForm;
import com.spring.project.banking.form.UserForm;
import com.spring.project.banking.model.Users;
import com.spring.project.banking.service.EmailStatService;
import com.spring.project.banking.service.ForgotPassword;
import com.spring.project.banking.service.MailStatService;
import com.spring.project.banking.service.RegstrationService;
import com.spring.project.banking.service.StatementService;
import com.spring.project.banking.service.UserService;

/**
 * @author lokesh & nag
 * 
 */
@Controller
@SessionAttributes({ "user" })
public class BankController {

	@Autowired
	private UserService userservice;

	@Autowired
	private EmailStatService emailstatservice;
	@Autowired
	private ForgotPassword forgotpasswordservice;
	@Autowired
	private MailStatService mailservice;
	@Autowired
	private RegstrationService regservice;

	/**
	 * *redirecting to login page
	 * 
	 * @param res
	 * @return model and view
	 */
	@RequestMapping(value = "/")
	public ModelAndView login(HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new UserForm());
		mav.setViewName("login");
System.out.println("hi"
		res.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
		res.setHeader("Pragma", "no-cache");

		return mav;
	}

	/**
	 * back to login page
	 * 
	 * @return model and view
	 */
	@RequestMapping(value = "/backlogin")
	public ModelAndView blogin() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new UserForm());
		mav.setViewName("login");

		return mav;
	}

	/**
	 * redirecting to statements page
	 * 
	 * @param userbean
	 * @return
	 */
	@RequestMapping(value = "/statements")
	public ModelAndView statemnt(@ModelAttribute("ubean") UserForm userbean) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("genratestatements", new StatementForm());
		mav.setViewName("Statements");
		return mav;
	}

	/**
	 * redirecting to balance page
	 * 
	 * @param userbean
	 * @return
	 */
	@RequestMapping(value = "/back")
	public ModelAndView back(
			@ModelAttribute("genratestatements") UserForm userbean) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("balance");
		return mav;
	}

	/**
	 * redirecting to login page on logout click
	 * 
	 * @param req
	 * @param res
	 * @param userbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest req,
			@ModelAttribute("user") UserForm userbean, BindingResult result) {
		HttpSession session = req.getSession();
		session.removeAttribute("UserProfile");
		session.invalidate();// invalidating the session
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new UserForm());
		mav.setViewName("login");
		return mav;
	}

	/**
	 * redirecting to forgort password page
	 * 
	 * @param userbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/fgtpwd", method = RequestMethod.GET)
	public ModelAndView forgotpassword(
			@ModelAttribute("forgot") UserForm userbean, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("forgot", new UserForm());
		mav.setViewName("forgotpassword");
		return mav;

	}

	/**
	 * sending statement to the user mail id
	 * 
	 * @param req
	 * @param userbean
	 * @param stbean
	 * @param result
	 * @return
	 * @throws WriteException
	 * @throws IOException
	 */
	@RequestMapping(value = "/emailstmt", method = RequestMethod.GET)
	public ModelAndView emailstat(HttpServletRequest req,
			@ModelAttribute("user") UserForm userbean,
			@ModelAttribute("genratestatements") StatementForm stbean,
			BindingResult result) throws WriteException, IOException {

		HttpSession s = req.getSession(true);
		stbean = (StatementForm) s.getAttribute("stform");
		List<Object> u = stservice.Statements(stbean, userbean);// getting the
																// corresponfing
																// records
		ModelAndView mav = new ModelAndView();
		String flag = "";

		mailservice.writetoexcel(u); // writing records to excel file

		String accno = userbean.getAccno();
		List<Users> us = emailstatservice.getToMail(accno); // mailing the
															// statement
		String to = "";
		for (Users uto : us) {
			to = uto.getEmailid(); // getting the mail id of user
		}

		boolean b = mailservice.sendmail(to);

		String viewname = "";
		// validating mail sent successfully or not
		if (b) {
			flag = "Mail sent to your E-mail "+ to+" check your inbox";
					

			viewname = "Statements";
			mav.addObject("status", flag);
			mav.setViewName(viewname);

		} else {
			flag = "sry error occured in sending mail";
			viewname = "Statements";
			mav.addObject("status", flag);
			mav.setViewName(viewname);

		}

		return mav;
	}

	/**
	 * sending password to the user email id
	 * 
	 * @param userbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/forgotpwd", method = RequestMethod.POST)
	public ModelAndView forgotpasswordsub(
			@ModelAttribute("forgot") UserForm userbean, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		Users umodel = forgotpasswordservice.prepareModelfgtpwd(userbean);
		boolean b = forgotpasswordservice.getUser(umodel); // getting the
															// corresponding
															// user record
															// checking whether
															// user is existing
															// or not
		if (b) {
			modelAndView.addObject("status",
					"Mail sent to your E-mail \n  check your inbox");

			modelAndView.setViewName("forgotpassword");
			return modelAndView;
		} else {

			String msg = "Invalid accno/accname";
			modelAndView.addObject(new UserForm());
			modelAndView.addObject("message", msg);
			modelAndView.setViewName("forgotpassword");
			return modelAndView;
		}

	}

	@Autowired
	private StatementService stservice;

	// generating Statements
	/**
	 * generating statements and displaying in the browser
	 * 
	 * @param req
	 * @param userbean
	 * @param statementbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/genstmt", method = RequestMethod.GET)
	public ModelAndView generatestatement(HttpServletRequest req,
			@ModelAttribute("user") UserForm userbean,
			@ModelAttribute("genratestatements") StatementForm statementbean,
			BindingResult result) {
		List<Object> li = stservice.Statements(statementbean, userbean);
		HttpSession s = req.getSession();
		s.setAttribute("stform", statementbean);
		ModelAndView mav = new ModelAndView();
		mav.addObject("stmt", stservice.prepareListofBeanstmt(li));
		mav.setViewName("Statements");
		return mav;
	}

	// validating user
	/**
	 * validating the user and redirecting to corresponding page
	 * 
	 * @param req
	 * @param userbean
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/validateLogin")
	public ModelAndView validate(HttpServletRequest req,
			@ModelAttribute("user") UserForm userbean, BindingResult result) {

		ModelAndView modelAndView = new ModelAndView();

		if (userbean.getAccno().equals("9999")
				&& userbean.getPwd().equals("admin")) {

			Map<String, Object> model = new HashMap<String, Object>();
			model.put("user",
					userservice.prepareListofusers(regservice.listEmployeess()));

			ModelAndView mav = new ModelAndView();
			mav.addObject("userdata",
					userservice.prepareListofusers(regservice.listEmployeess()));
			mav.setViewName("adminhome");
			return mav;

		} else {

			Users umodel = userservice.prepareModelu(userbean);
			List<Users> l = userservice.ValidateUser(umodel); // getting the
																// user records
																// checking
																// whether user
																// is valid or
																// not
			if (!l.isEmpty()) {

				HttpSession s = req.getSession();
				s.setAttribute("loggedin", "yes");
				s.setAttribute("UserProfile", userbean);

				String an = "";
				String br = "";
				for (Users u : l) {
					an = u.getAname().toUpperCase();
					userbean.setAccname(an);
					br = u.getBranch().toUpperCase();
					userbean.setBranch(br);
				}
				modelAndView.addObject("accno", userbean.getAccno());
				String no = userbean.getAccno();
				BigDecimal bal = userservice.GetBalance(no); // getting user
																// balance
				userbean.setBal(bal);
				modelAndView.addObject("user", userbean);
				modelAndView.setViewName("balance");
			} else {
				modelAndView.addObject("user", userbean);

				modelAndView.addObject("error", "Invalid Accno/Password");
				modelAndView.setViewName("login");
			}

		}
		return modelAndView;
	}
	/*
	 * @RequestMapping(value = "/edit", method = RequestMethod.GET) public
	 * ModelAndView edit(@ModelAttribute("user") UserForm userbean,
	 * BindingResult result) { Map<String, Object> model = new HashMap<String,
	 * Object>(); model.put("user",
	 * prepareCustomerBean(userservice.getCustomer(userbean .getAccno())));
	 * model.put("userdata",
	 * userservice.prepareListofusers(regservice.listEmployeess())); return new
	 * ModelAndView("adminhome", model); }
	 * 
	 * private UserForm prepareCustomerBean(List<Users> us) { List<UserForm>
	 * ubeans = new ArrayList<UserForm>(); UserForm ubean = new UserForm(); for
	 * (Users u : us) { ubean.setAccno("asdasd"); ubean.setAccname("1234");
	 * ubean.setAddress("wasd"); ubean.setBranch("sdfsdfs");
	 * ubean.setContactno("dsfsdfsd"); ubean.setEmailid("asxdasda");
	 * ubean.setStatus("asdasdasd");
	 * 
	 * 
	 * 
	 * break;
	 * 
	 * }
	 * 
	 * return ubean; }
	 * 
	 * @RequestMapping(value = "/registration", method = RequestMethod.POST)
	 * public ModelAndView registration(
	 * 
	 * @ModelAttribute("registration") RegistrationForm regbean, BindingResult
	 * result) {
	 * 
	 * Users umodel = regservice.prepareModelreg(regbean); int j =
	 * regservice.insertusers(umodel); ModelAndView mav = new ModelAndView(); if
	 * (j > 0) { mav.addObject("status", "registered successfully");
	 * mav.setViewName("registration"); } else { mav.addObject("status",
	 * "error occured"); mav.setViewName("registration"); } return mav;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/newuser", method = RequestMethod.GET) public
	 * ModelAndView regstration(
	 * 
	 * @ModelAttribute("registration") RegistrationForm regbean, BindingResult
	 * result) { ModelAndView mav = new ModelAndView();
	 * mav.setViewName("registration"); return mav; }
	 * 
	 * @RequestMapping(value = "/checkuser", method = RequestMethod.GET) public
	 * ModelAndView saveEmployee(
	 * 
	 * @ModelAttribute("ubean") UserForm userform, BindingResult result) {
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.addObject("user", userform);
	 * mav.setViewName("Construction"); return mav; }
	 */
}
