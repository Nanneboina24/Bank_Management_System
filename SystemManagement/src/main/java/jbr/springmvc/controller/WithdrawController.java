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
import jbr.springmvc.model.Withdraw;
import jbr.springmvc.model.Sample;

import jbr.springmvc.service.UserService;
import jbr.springmvc.controller.LoginController;

@Controller
public class WithdrawController {
	@Autowired
    public UserService userService;
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    
		  ModelAndView mav = new ModelAndView("withdraw");
	
		 Withdraw withdraw=new Withdraw();
	      mav.addObject("withdraw",withdraw);
	      withdraw.setIdnum(Sample.aid);
	      withdraw.setUser(Sample.user);
	      return mav;
	  }
	
	@RequestMapping(value = "/withdrawProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("withdraw")Withdraw withdraw) {
		  ModelAndView mav=null;
	    int result= userService.withdraw(withdraw);
	    if(result ==1)
	    {
	    	withdraw.setUser(Sample.user);
	    	mav = new ModelAndView("status");
	    	mav.addObject( "firstname",withdraw.getUser());
	    }
	    else
	    {
	    	withdraw.setIdnum(Sample.aid);
	    	mav = new ModelAndView("withdraw");  
	    	mav.addObject("message", "Insuficient Amount In Your Account");
	    }
	     return mav;
	  }
	
}
