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
import jbr.springmvc.model.User;
import jbr.springmvc.model.Sample;

import jbr.springmvc.service.UserService;
import jbr.springmvc.controller.LoginController;

@Controller
public class DepositController {
	@Autowired
    public UserService userService;
	
	 @RequestMapping(value = "/deposit", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    
		  ModelAndView mav = new ModelAndView("deposit");
	
		  Deposit deposit =new Deposit(); 
	      mav.addObject("deposit",deposit);
	      deposit.setIdnum(Sample.aid);
	      deposit.setUser(Sample.user);
	      return mav;
	  }

	  @RequestMapping(value = "/depositProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("deposit") Deposit deposit) {
		  ModelAndView mav=null;
	    int result= userService.deposit(deposit);
	    if(result ==1)
	    {
	    	 deposit.setUser(Sample.user);
	    	mav = new ModelAndView("status");
	    	mav.addObject( "firstname",deposit.getUser());

	    }
	    else
	    {
	    	mav = new ModelAndView("action");
	       
	    }
	
	     return mav;
	  }

}
