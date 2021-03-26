package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Deposit;
import jbr.springmvc.model.Myaccount;
import jbr.springmvc.model.User;
import jbr.springmvc.model.Sample;
import jbr.springmvc.model.Transfer;
import jbr.springmvc.service.UserService;
import jbr.springmvc.controller.LoginController;

@Controller
public class MyaccountController {
	@Autowired
    public UserService userService;
	
	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    
		  ModelAndView mav = new ModelAndView("myaccount");

		  Myaccount myaccount=null;
		 // myaccount.setIdnum(Sample.aid);
		  myaccount=userService.viewuser(myaccount);
	      mav.addObject("myaccount",myaccount);
	     // myaccount.setIdnum(Sample.aid);
	    //  myaccount.setUsername(Sample.user);
	      return mav;
	}
	
	
	
	
	
	
	
	

}
