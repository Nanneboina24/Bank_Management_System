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
import jbr.springmvc.model.Transfer;
import jbr.springmvc.service.UserService;
import jbr.springmvc.controller.LoginController;

@Controller
public class TransferController {
	@Autowired
    public UserService userService;
	
	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    
		  ModelAndView mav = new ModelAndView("transfer");
	
		  Transfer transfer=new Transfer();
	      mav.addObject("transfer",transfer);
	      transfer.setIdnum(Sample.aid);
	      transfer.setUser(Sample.user);
	      return mav;
	  }
	
	@RequestMapping(value = "/transferProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("transfer") Transfer transfer) {
		  ModelAndView mav=null;
	    int result= userService.transfer(transfer);
	    if(result ==1)
	    {
	    	 transfer.setUser(Sample.user);
	    	mav = new ModelAndView("status");
	    	mav.addObject( "firstname",transfer.getUser());

	    }
	    else
	    {
	    	transfer.setIdnum(Sample.aid);
	    	mav = new ModelAndView("transfer");
	    	mav.addObject("message", "Insuficient Amount Or Invalid Toid Number");
	       
	    }
	
	     return mav;
	  }

}

	
	